const selectMessages = [
    "Welcome! Please select the inner-most corner of the yellow corner pocket first by clicking on it.",
    "Now select the inner-most corner of the  green corner pocket.",
    "Next select inner-most corner of the the yellow (usually left-hand) side black pocket.",
    "Finally, select inner-most corner of the the green (usually right-hand) side black pocket.",
];
let selectMessageElem = document.getElementById("selectNext");
let selectionDiv = document.getElementById("selection");
let canvas = document.getElementById('canvas');
let ctx = canvas.getContext('2d');

let media;
let width = height = 0;
let scaled = false;
let corners = [];

let mediaSrc = sessionStorage.getItem("file");
sessionStorage.removeItem("originCorners");

if (isVideo(mediaSrc)) {
    media = document.getElementById('video');
    media.src = '/media/' + mediaSrc;
    media.addEventListener('canplay', function canplay() {
        media.removeEventListener('canplay', canplay);
        width = media.videoWidth; height = media.videoHeight;
        amendScale(media.videoWidth > (screen.width * 0.8) || media.videoHeight > (screen.height * 0.9));
        canvas.addEventListener('click', canvasClicked);
        nextMessage();
    });
} else {
    media = new Image();
    media.src = '/media/' + mediaSrc;
    media.onload = function() {
        width = media.width; height = media.height;
        amendScale(width > (screen.width * 0.8) || height > (screen.height));
        ctx.drawImage(media, 0, 0, width, height);
        canvas.addEventListener('click', canvasClicked);
        nextMessage();
    }
}

function amendScale(scaleDown) {
    if (scaleDown) {
        scaled = true;
        width /= 2; height /= 2;
    }
    media.width = width; media.height = height;
    canvas.width = width; canvas.height = height;
    selectionDiv.style.width = width + "px";
    selectionDiv.style.height = height + "px";
}

// event handler for clicks
function canvasClicked(event) {
    // get the mouse position relative to the canvas
    let x = event.pageX - canvas.offsetLeft - canvas.clientLeft;
    let y = event.pageY - canvas.offsetTop - canvas.clientTop;
    
    // visualise the selected corner
    ctx.beginPath();
    ctx.arc(x, y, Math.min(canvas.width, canvas.height) / 60, 0, 2 * Math.PI);
    ctx.fillStyle = "rgba(255, 0, 0, 0.4)";
    ctx.strokeStyle = "red";
    ctx.fill();
    ctx.stroke();

    if (scaled) {
        x *= 2;
        y *= 2;
    }
    console.log(x, y);
    corners.push(x);
    corners.push(y);
    
    // check if all corners have been selected
    if (corners.length == 8) {
        // store the selected corners and redirect to the next page
        console.log("corners", corners);
        canvas.removeEventListener('click', canvasClicked);
        sessionStorage.setItem("originCorners", JSON.stringify(corners));
        if (mediaSrc.includes("mp4"))
            window.location.replace("/html/analyseVideo.html");
        else
            window.location.replace("/html/analyseFrame.html");
        return;
    }

    nextMessage();
}

function nextMessage() {
    selectMessageElem.innerHTML = selectMessages[corners.length / 2];
}

function isVideo(file) {
    return (
        file.includes("mp4") ||
        file.includes("webm") ||
        file.includes("mov") ||
        file.includes("avi") ||
        file.includes("wmv") ||
        file.includes("flv") ||
        file.includes("mkv"));
}