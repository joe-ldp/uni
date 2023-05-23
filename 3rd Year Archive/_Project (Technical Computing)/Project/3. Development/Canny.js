const lower = [0, 90, 0, 0];
const upper = [80, 200, 80, 255];

function createDebugSliders() {
    let sliders = document.getElementById('sliders');
    var threshold1 = 1; // defaults found by trial and error
    var threshold2 = 92;
    
    sliders.children[1].value = threshold1;
    sliders.children[3].value = threshold2;
    
    document.getElementById('threshold1').oninput = function() {
        threshold1 = parseInt(this.value);
        sliders.children[0].innerHTML = "threshold1: " + threshold1;
        trackFrame();
    };
    document.getElementById('threshold2').oninput = function() {
        threshold2 = parseInt(this.value);
        sliders.children[2].innerHTML = "threshold2: " + threshold2;
        trackFrame();
    };
}

function ready() {
    // createDebugSliders();
    loadImage().then(trackFrame);
}

function loadImage() {
    let srcImg = new Image();
    srcImg.src = '/media/' + sessionStorage.getItem("file");;
    return new Promise((resolve) => {
        srcImg.onload = function() {
            let canvasIn = document.getElementById('canvasInput');
            canvasIn.width = srcImg.width;
            canvasIn.height = srcImg.height;
            
            let ctx = canvasIn.getContext('2d');
            ctx.drawImage(srcImg, 0, 0);
            resolve();
        }
    });
}

function trackFrame() {
    let canvasOut = document.getElementById('canvasOutput');
    let src = cv.imread('canvasInput');
    let dst = cv.Mat.zeros(canvasOut.height, canvasOut.width, cv.CV_8UC3);
    let dsize = new cv.Size(canvasOut.width, canvasOut.height);
    
    // let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, [296, 531, 672, 447, 1641, 717, 1499, 496]);
    // let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, [21, 20, 277, 25, 20, 538, 277, 536]);
    //let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, [0, 300, 10, 36, 525, 292, 512, 42]);
    let corners = JSON.parse(sessionStorage.getItem("originCorners"));
    let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, corners);
    let dstTri = cv.matFromArray(4, 1, cv.CV_32FC2, [0, 0, canvasOut.width, 0, 0, canvasOut.height, canvasOut.width, canvasOut.height]);
    let transform = cv.getPerspectiveTransform(srcTri, dstTri);
    
    cv.warpPerspective(src, src, transform, dsize, cv.INTER_LINEAR, cv.BORDER_CONSTANT, new cv.Scalar()); 

    cv.imshow('canvasInput', src);
    srcTri.delete(); dstTri.delete(); transform.delete();

    // grayscale
    cv.cvtColor(src, src, cv.COLOR_RGBA2GRAY, 0);
    // blur
    let ksize = new cv.Size(3, 3);
    cv.GaussianBlur(src, src, ksize, 0, 0, cv.BORDER_DEFAULT);
    
    cv.Canny(src, src, 1, 92, 3, false);

    document.getElementById('canvasOutput').style.opacity = 0.5;    
    cv.imshow('canvasOutput', src);

    src.delete(); dst.delete(); contours.delete(); hierarchy.delete();
}