var dst;
var canvasOut;
const black = new cv.Scalar(0,   0,   0,   255);
const white = new cv.Scalar(255, 255, 255, 255);

function ready() {
    loadImage().then(trackFrame);
}

function loadImage() {
    let srcImg = new Image();
    imgSrc = sessionStorage.getItem("file");
    srcImg.src = '/media/' + imgSrc;
    return new Promise((resolve) => {
        srcImg.onload = function() {
            let canvasIn = document.getElementById('canvasInput');
            canvasOut = document.getElementById('canvasOutput');
            canvasIn.width = srcImg.width;
            canvasIn.height = srcImg.height;
            
            let ctx = canvasIn.getContext('2d');
            ctx.drawImage(srcImg, 0, 0);
            resolve();
        }
    });
}

function trackFrame() {
    let src = cv.imread('canvasInput');

    dst = new cv.Mat(canvasOut.height, canvasOut.width, cv.CV_8UC3, new cv.Scalar(40, 160, 40, 255));
    
    src = normaliseView(src, true, 'canvasInput');

    let filteredBallRects = trackBalls(src);
    src.delete();

    renderPosition(filteredBallRects);
}

/**
 * @param {*} src of type cv.Mat, should be a raw frame of video or image
 * @param {*} imshow of type boolean, if true, will display the result in the canvas specified by `canvas`
 * @param {*} canvas of type string, the id of the canvas element to display the result in
 * @returns of type cv.Mat, perspective-warped `src` based on `corners` in sessionStorage
 */
function normaliseView(src, imshow = false, canvas = 'canvasInput') {
    let dsize = new cv.Size(canvasOut.width, canvasOut.height);
    
    // let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, [296, 531, 672, 447, 1641, 717, 1499, 496]);
    // let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, [21, 20, 277, 25, 20, 538, 277, 536]);
    //let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, [0, 300, 10, 36, 525, 292, 512, 42]);
    let corners = JSON.parse(sessionStorage.getItem("originCorners"));
    let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, corners);
    let dstTri = cv.matFromArray(4, 1, cv.CV_32FC2, [0, 0, canvasOut.width, 0, 0, canvasOut.height, canvasOut.width, canvasOut.height]);
    let transform = cv.getPerspectiveTransform(srcTri, dstTri);
    
    cv.warpPerspective(src, src, transform, dsize, cv.INTER_LINEAR, cv.BORDER_CONSTANT, new cv.Scalar()); 

    if (imshow)
        cv.imshow(canvas, src);
    srcTri.delete(); dstTri.delete(); transform.delete();
    return src;
}

/**
 * @param {*} src of type cv.Mat, should be a perspective-warped top down view of only the bed of the table
 * @returns of type Array of Objects, list of tracked balls; each Object contains `position` and `colour`
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
    console.log(filteredBallRects.length + " balls found");
    return filteredBallRects;
}

/**
 * @param {*} ball of type Object, should contain `position`
 * @returns of type String, one of the eight pre-defined ball colours
 */
function getBallColour(ballRect, inputImg, dst, black, white) {
    let mask = new cv.Mat(dst.rows, dst.cols, cv.CV_8UC4, black);
    let alphaMask = new cv.Mat(dst.rows, dst.cols, cv.CV_8UC1, black);
    let masked = new cv.Mat();
    
    cv.circle(mask, ballRect.center, 2, white, 1, cv.FILLED, 0);
    cv.circle(alphaMask, ballRect.center, 2, white, 1, cv.FILLED, 0);
    
    cv.bitwise_and(inputImg, mask, masked);
    // cv.imshow('canvasOutput', masked);
    let foundColour = cv.mean(masked, alphaMask);
    // console.log(foundColour);
    mask.delete(); alphaMask.delete(); masked.delete();

    /*let foundColourObj = new Colour(foundColour[0], foundColour[1], foundColour[2]);
    
    let diffs = colours.map(c => c.difference(foundColourObj));
    console.log(diffs);
    let colour = colours[diffs.indexOf(Math.min(...diffs))];
    console.log(colour);

    return colour.array();*/
    console.log(foundColour);
    return foundColour;
}

/**
 * @param {*} balls of type Array of Objects, each Object should contain `position` and `colour`
 * @returns nothing
 */
function renderPosition(ballRects) {
    let inputImg = cv.imread('canvasInput');

    let width = canvasOut.width;
    let height = canvasOut.height;

    // Markings from:
    // https://www.bluemoonleisure.com/what-are-the-markings-for-a-pool-table-and-a-snooker-table
    let thickness = 1.5;
    let baulkLine = height / 5;
    let dRadius   = width / 6;
    let dCenter   = new cv.Point(width / 2, baulkLine);
    let axes      = new cv.Size(dRadius, dRadius);

    let spotSize = 3;
    let brownSpot = new cv.Point(150, baulkLine);
    let blueSpot =  new cv.Point(150, height / 2);
    let pinkSpot =  new cv.Point(150, height * 0.75);
    let blackSpot = new cv.Point(150, height - (height / 11));
    
    // draw baulk line
    cv.line(dst, new cv.Point(0, baulkLine), new cv.Point(300, baulkLine), white, thickness, cv.LINE_AA, 0);
    // draw D
    cv.ellipse(dst, dCenter, axes, 0 /*rot*/, 180 /*start ang*/, 360 /*end*/, white, thickness, cv.LINE_AA, 0);
    // draw spots
    cv.line(dst, brownSpot, brownSpot, white, spotSize, cv.LINE_AA, 0);
    cv.line(dst, blueSpot,  blueSpot,  white, spotSize, cv.LINE_AA, 0);
    cv.line(dst, pinkSpot,  pinkSpot,  white, spotSize, cv.LINE_AA, 0);
    cv.line(dst, blackSpot, blackSpot, white, spotSize, cv.LINE_AA, 0);

    ballRects.forEach(ballRect => {
        let colour = getBallColour(ballRect, inputImg, dst, black, white);
        cv.circle(dst, ballRect.center, 2, colour, 5, cv.FILLED, 0);
    });
    
    cv.imshow('canvasOutput', dst);

    dst.delete(); inputImg.delete();
}