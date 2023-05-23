sessionStorage.clear();

document.getElementById('input').onchange = function(event) {
    var file = event.target.files[0];
    console.log(file);
    sessionStorage.setItem("file", file["name"]);
    window.location.replace("/html/selectCorners.html");
}