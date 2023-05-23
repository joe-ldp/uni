createTestSliders();
    var img = loadImage();
    resizeCanvas();
    getTransformedImage();

function createTestSliders() {
    let sliders = document.getElementById('sliders');
    let threshold1 = 1; // defaults found by trial and error
    let threshold2 = 92;

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

function loadImage() {
    let img = new Image();
    img.src = './media/topdown1.png';
    img.onload = function() {
        let canvas = document.getElementById('canvasInput');
        let ctx = canvas.getContext('2d');
        ctx.drawImage(img, 0, 0);
    }
}

function resizeCanvas() {
    let canvas = document.getElementById('canvasInput');
    let src = cv.imread('canvasInput');
    canvas.width = src.cols;
    canvas.height = src.rows;
}

function getTransformedImage() {
    let src = cv.imread('canvasInput');
    let dsize = new cv.Size(src.cols, src.rows);

    // let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, [296, 531, 672, 447, 1641, 717, 1499, 496]);
    let srcTri = cv.matFromArray(4, 1, cv.CV_32FC2, [21, 20, 277, 25, 20, 538, 277, 536]);
    let dstTri = cv.matFromArray(4, 1, cv.CV_32FC2, [0, 0, src.cols, 0, 0, src.rows, src.cols, src.rows]);
    let transform = cv.getPerspectiveTransform(srcTri, dstTri);
    cv.warpPerspective(src, img, transform, dsize, cv.INTER_LINEAR, cv.BORDER_CONSTANT, new cv.Scalar()); 
    cv.imshow('canvasInput', img);

    src.delete(); srcTri.delete(); dstTri.delete(); transform.delete();
}

function trackFrame(img) {
    let dst = new cv.Mat();
    // grayscale
    cv.cvtColor(img, img, cv.COLOR_RGBA2GRAY, 0);
    // blur
    let ksize = new cv.Size(3, 3);
    cv.GaussianBlur(img, img, ksize, 0, 0, cv.BORDER_DEFAULT);

    cv.Canny(img, dst, threshold1, threshold2, 3, false);

    cv.imshow('canvasOutput', dst);
    console.log(dst);
}

function trackVideo() {
    
}