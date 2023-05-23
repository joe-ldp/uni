solCanvas = document.getElementById("solCanvas");
ctx = solCanvas.getContext("2d");

ctx.strokeStyle = "#000000";

ctx.fillStyle = "#005700";
ctx.fillRect(0, 0, 100, solCanvas.height);
ctx.fillRect(solCanvas.width - 100, 0, 100, solCanvas.height);

ctx.fillStyle = "#008000";
ctx.fillRect(100, 0, solCanvas.width - 200, solCanvas.height);

solCanvas.addEventListener("mousemove", function(e)
{
	let rect = solCanvas.getBoundingClientRect();
	mX = e.clientX - rect.left; 
	mY = e.clientY - rect.top; 
});

solCanvas.addEventListener("mousedown", function(e)
{
	mDownX = mX;
	mDownY = mY;
	mC = true;
});

solCanvas.addEventListener("mouseup", function(e)
{
	mC = false;
});

var stock, tableauStacks, foundation;

function newGame(difficulty)
{
    /*stock = [];
    foundation = [];
    tableauStacks = [[], [], [], [], [], [], []];*/

    stock = new Stack(24);
    foundation = [new Stack(13), new Stack(13), new Stack(13), new Stack(13)];
    tableauStacks = [new Stack(13), new Stack(13), new Stack(13), new Stack(13), new Stack(13), new Stack(13), new Stack(13)];
    
    for (i = 0; i < 52; i++)
    {

    }
}

