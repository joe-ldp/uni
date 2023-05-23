let canvasOut;
let videoElem;
let states = [];
let positionsDiv;
let debugTxt;
let blankMat;
const black = new cv.Scalar(0,   0,   0,   255);
const white = new cv.Scalar(255, 255, 255, 255);
const baize = new cv.Scalar(40,  160, 40,  255);

const thickness = 1.5;
let baulkLine, dRadius, dCenter, axes;

const spotSize = 3;
let brownSpot, blueSpot, pinkSpot, blackSpot;

document.addEventListener('DOMContentLoaded', () => {
    canvasOut    = document.getElementById('canvasOutput');
    videoElem    = document.getElementById('videoInput');
    debugTxt     = document.getElementById("debugText");
    positionsDiv = document.getElementById("positions");
    
    videoElem.src = '/media/' + sessionStorage.getItem("file");
    videoElem.addEventListener('loadeddata', () => {
        let videoSettings = videoElem.captureStream().getVideoTracks()[0].getSettings();
        videoElem.height = videoSettings.height;
        videoElem.width = videoSettings.width;
        blankMat = new cv.Mat(videoElem.height, videoElem.width, cv.CV_8UC4);
        videoElem.play();
        processVideo(videoElem, videoSettings);

        videoElem.removeEventListener('loadeddata', this);
    });

    document.getElementById('canvasInput').addEventListener('click', playPause);
    document.getElementById('canvasOutput').addEventListener('click', playPause);

    // Markings from:
    // https://www.bluemoonleisure.com/what-are-the-markings-for-a-pool-table-and-a-snooker-table
    baulkLine = canvasOut.height / 5;
    dRadius = canvasOut.width / 6;
    dCenter = new cv.Point(canvasOut.width / 2, baulkLine);
    axes = new cv.Size(dRadius, dRadius);

    brownSpot = new cv.Point(canvasOut.width / 2, baulkLine);
    blueSpot =  new cv.Point(canvasOut.width / 2, canvasOut.height / 2);
    pinkSpot =  new cv.Point(canvasOut.width / 2, canvasOut.height * 0.75);
    blackSpot = new cv.Point(canvasOut.width / 2, canvasOut.height - (canvasOut.height / 11));
});

function playPause() {
    if (videoElem.paused) {
        videoElem.play();
    } else {
        videoElem.pause();
    }
}

function processVideo(videoElem, videoSettings) {
    const FPS = Math.min(videoSettings.frameRate, 5);
    let cap = new cv.VideoCapture(videoElem.id);
    let thisPosition = [];
    let lastSaved = [];
    let confidence = {
        potted: 0,
        replaced: 0,
        still: 0
    };

    function processFrame() {
        let begin = Date.now(); // capture time at start of processing

        if (!videoElem.paused) {
            let src = blankMat.clone();
            cap.read(src); // capture next frame

            src = normaliseView(src, true, 'canvasInput');
            let candidatePosition = trackBalls(src);
            renderPosition(candidatePosition, false);

            if (states.length == 0) {
                savePosition(candidatePosition, "Initial state saved");
                thisPosition = candidatePosition.slice();
            } else {
                // update confidence values
                let posDiff = compareStates(thisPosition, candidatePosition);
                // console.log(posDiff.toFixed(2) + ", " + confidence.still + ", " + confidence.potted + ", " + confidence.replaced);
                if (posDiff >= 5) {
                    thisPosition = candidatePosition.slice();
                    confidence.still = -1;
                } else {
                    confidence.still = Math.min(confidence.still + 1, 20);
                }

                if (candidatePosition.length < lastSaved.length) // ball was maybe potted
                    confidence.potted = Math.min(confidence.potted + 1, 20);
                else
                    confidence.potted = 0;

                if (candidatePosition.length > lastSaved.length) // ball was maybe added (cue ball/colour replaced)
                    confidence.replaced = Math.min(confidence.replaced + 1, 20);
                else
                    confidence.replaced = 0;

                // review confidence values
                if (confidence.still >= 15) {
                    if (confidence.potted >= 15) {
                        savePosition(candidatePosition, "State saved, ball potted and balls at rest at a new position");
                    } else if (confidence.replaced >= 15) {
                        removePosition(states.length - 1);
                        savePosition(candidatePosition, "Last state replaced, ball respotted");
                    } else if (compareStates(lastSaved, thisPosition) >= 5) {
                        savePosition(candidatePosition, "State saved, balls at rest at a new position");
                    }
                }
            }

            src.delete();
        }
        
        let delay = 1000 / FPS - (Date.now() - begin);
        setTimeout(processFrame, delay); // calculated delay before next frame to maintain real-time processing
    }

    function savePosition(position, reason) {
        if (position.length > 0) {
            let c = positionsDiv.appendChild(document.createElement("canvas"));
            c.id = states.length;
            c.classList.add("state");
            c.addEventListener('click', showStateLarge);
            renderPosition(position, true, c.id, 0.3);
            
            lastSaved = position.slice();
            states.push(position);
            console.log(reason);
            debugTxt.innerHTML = reason;
        }

        confidence.potted = 0;
        confidence.replaced = 0;
        confidence.still = 0;
    }

    function removePosition(index) {
        states.splice(index, 1);
        positionsDiv.removeChild(positionsDiv.childNodes[index]);
        console.log("Position removed");
    }

    setTimeout(processFrame, 0);
}

/**
 * @param {cv.Mat} src of type cv.Mat, should be a raw frame of video or image
 * @param {boolean} imshow of type boolean, if true, will display the result in the canvas specified by `canvas`
 * @param {string} canvas of type string, the id of the canvas element to display the result in
 * @returns cv.Mat, perspective-warped `src` based on `corners` in sessionStorage
 */
function normaliseView(src, imshow = false, canvas = 'canvasInput') {
    let dsize = new cv.Size(canvasOut.width, canvasOut.height);
    let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, JSON.parse(sessionStorage.getItem("originCorners")));
    let dstTri = cv.matFromArray(4, 1, cv.CV_32FC2, [
        0, 0,
        canvasOut.width, 0,
        0, canvasOut.height,
        canvasOut.width, canvasOut.height
    ]);
    let transform = cv.getPerspectiveTransform(srcTri, dstTri);

    cv.warpPerspective(src, src, transform, dsize, cv.INTER_LINEAR, cv.BORDER_CONSTANT, new cv.Scalar());
    if (imshow)
        cv.imshow(canvas, src);

    srcTri.delete(); dstTri.delete(); transform.delete();
    return src;
}

/**
 * @param {cv.Mat} src of type cv.Mat, should be a perspective-warped top down view of only the bed of the table
 * @returns of type Array of Objects, list of tracked balls; each Object contains `angle`, `position` and `size`
 */
function trackBalls(src) {
    let filteredBallRects = [];

    // mask image using lower and upper
    let low = new cv.Mat(src.rows, src.cols, src.type(), [0, 90, 0, 0]);
    let high = new cv.Mat(src.rows, src.cols, src.type(), [80, 200, 80, 255]);
    cv.inRange(src, low, high, src);

    // find contours

    let contours = new cv.MatVector();
    let hierarchy = new cv.Mat();
    cv.findContours(src, contours, hierarchy, cv.RETR_CCOMP, cv.CHAIN_APPROX_SIMPLE);

    hierarchy.delete();

    for (let i = 0; i < contours.size(); ++i) {
        let contour = contours.get(i);
        let rect = cv.minAreaRect(contour);
        let w = rect.size.width;
        let h = rect.size.height;
        let aspect = h > w ? h / w : w / h;
        let area = w * h;
        if (aspect > 0.7 && aspect < 1.8 && area > 70 && area < 200) {
            // console.log(Math.round(rect.center.x) + ", " + Math.round(rect.center.y) + ", " + aspect.toFixed(2) + ", " + area.toFixed(2));
            filteredBallRects.push(rect);
        }
    }

    contours.delete();
    // console.log(filteredBallRects.length + " balls found");
    return filteredBallRects;
}

/**
 * @param {Object} ball of type Object, should contain `position`
 * @param {cv.Mat} inputImg of type cv.Mat, should be a perspective-warped top down view of only the bed of the table
 * @param {number} rows of type Number, the number of rows in the input image
 * @param {number} cols of type Number, the number of columns in the input image
 * @returns cv.Scalar, the colour of the ball at `ball.position`
 */
function getBallColour(ballRect, inputImg, rows, cols) {
    let mask      = new cv.Mat(rows, cols, cv.CV_8UC4, black);
    let alphaMask = new cv.Mat(rows, cols, cv.CV_8UC1, black);
    let masked    = new cv.Mat();

    cv.circle(mask,      ballRect.center, 2, white, 1, cv.FILLED, 0);
    cv.circle(alphaMask, ballRect.center, 2, white, 1, cv.FILLED, 0);

    cv.bitwise_and(inputImg, mask, masked);
    let foundColour = cv.mean(masked, alphaMask);

    mask.delete(); alphaMask.delete(); masked.delete();

    // console.log(foundColour);
    return foundColour;
}

/**
 * @param {Array} ballRects of type Array of Objects, should contain `position`
 * @param {boolean} doColour of type boolean, if true, will colour the balls based on their colour
 * @param {string} canvas of type string, the id of the canvas element to display the result in
 * @param {number} scale of type Number, the scale of the canvas element to display the result in
 * @returns nothing
 */
function renderPosition(ballRects, doColour = true, canvas = 'canvasOutput', scale = 1) {
    let inputImg = cv.imread('canvasInput');
    let dst = new cv.Mat(canvasOut.height, canvasOut.width, cv.CV_8UC3, baize);

    // draw baulk line
    cv.line(dst, new cv.Point(0, baulkLine), new cv.Point(canvasOut.width, baulkLine), white, thickness, cv.LINE_AA, 0);
    // draw D
    cv.ellipse(dst, dCenter, axes, 0 /*rot*/ , 180 /*start ang*/ , 360 /*end*/ , white, thickness, cv.LINE_AA, 0);
    // draw spots
    cv.line(dst, brownSpot, brownSpot, white, spotSize, cv.LINE_AA, 0);
    cv.line(dst, blueSpot,  blueSpot,  white, spotSize, cv.LINE_AA, 0);
    cv.line(dst, pinkSpot,  pinkSpot,  white, spotSize, cv.LINE_AA, 0);
    cv.line(dst, blackSpot, blackSpot, white, spotSize, cv.LINE_AA, 0);

    ballRects.forEach(ballRect => {
        let colour;
        if (doColour)
            colour = getBallColour(ballRect, inputImg, dst.rows, dst.cols);
        else
            colour = white;
        cv.circle(dst, ballRect.center, 2, colour, 5, cv.FILLED, 0);
    });

    if (scale != 1) {
        let dsize = new cv.Size(canvasOut.width * scale, canvasOut.height * scale);
        cv.resize(dst, dst, dsize, 0, 0, cv.INTER_AREA);
    }
    cv.imshow(canvas, dst);

    dst.delete(); inputImg.delete();
}

/**
 * Calculates the difference between two states.
 * @param {Array} state1 of type Array of Objects, each containing `center.x` and `center.y`
 * @param {Array} state2 of type Array of Objects, each containing `center.x` and `center.y`
 * @returns a number representing the difference between the two states (higher = more different)
 */
function compareStates(state1, state2) {
    let moreBalls, fewerBalls, ballDists = [];
    if (state1.length >= state2.length) {
        moreBalls = state1.slice();
        fewerBalls = state2.slice();
    } else {
        moreBalls = state2.slice();
        fewerBalls = state1.slice();
    }

    for (let i = 0; i < fewerBalls.length; i++) {
        let minBallIndex = 0;
        let minBallDistance = Infinity;
        for (let j = 0; j < moreBalls.length; j++) {
            let dx = fewerBalls[i].center.x - moreBalls[j].center.x;
            let dy = fewerBalls[i].center.y - moreBalls[j].center.y;
            let dist = dx * dx + dy * dy;
            if (dist < minBallDistance) {
                minBallIndex = j;
                minBallDistance = dist;
            }
        }
        moreBalls.splice(minBallIndex, 1);
        ballDists.push(minBallDistance);
    }

    while (moreBalls.length) {
        let ball = moreBalls.pop();
        let minBallIndex = 0;
        let minBallDistance = Infinity;
        for (let i = 0; i < fewerBalls.length; i ++) {
            let dx = ball.x - fewerBalls[i].center.x;
            let dy = ball.y - fewerBalls[i].center.y;
            let dist = dx * dx + dy * dy;
            if (dist < minBallDistance) {
                minBallIndex = i;
                minBallDistance = dist;
            }
        }
        if (minBallDistance < ballDists[minBallIndex]) {
            ballDists[minBallIndex] = minBallDistance;
        }
    }

    return ballDists.reduce((a, b) => a + b, 0);
}

/**
 * Shows a large render of a state. To be registered as an event listener on one of the miniature canvases.
 * @param {event} event the event that triggered the function
 */
function showStateLarge(event) {
    videoElem.pause();
    let scale = Math.min(window.innerWidth / canvasOut.width, window.innerHeight / canvasOut.height) * 0.95;
    let miniCanvas = document.getElementById(event.target.id);
    let largeCanvas = document.body.appendChild(document.createElement('canvas'));
    largeCanvas.id = 'canvasLarge';
    largeCanvas.width = canvasOut.width * scale;
    largeCanvas.height = canvasOut.height * scale;
    largeCanvas.style.position = 'absolute';
    largeCanvas.style.top = (window.innerHeight - largeCanvas.height) / 2 + 'px';
    largeCanvas.style.left = (window.innerWidth - largeCanvas.width) / 2 + 'px';
    largeCanvas.style.zIndex = '100';
    renderPosition(states[miniCanvas.id], true, 'canvasLarge', scale);
    largeCanvas.addEventListener('click', () => {
        document.body.removeChild(largeCanvas);
        videoElem.play();
    });
}