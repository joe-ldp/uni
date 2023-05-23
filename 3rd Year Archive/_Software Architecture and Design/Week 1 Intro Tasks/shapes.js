class Vertex {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
}

class TwoDShape {
    constructor(vertices, colour) {
        this.vertices = vertices;
        this.colour = colour;
        this.numSides = vertices.length;
    }
}

class Square extends TwoDShape {
    constructor(area, pos, colour) {
        let sL = Math.sqrt(area);
        super([
            new Vertex(pos.x, pos.y),
            new Vertex(pos.x + sL, pos.y),
            new Vertex(pos.x + sL, pos.y + sL),
            new Vertex(pos.x, pos.y + sL)], colour);
        this.numSides = 4;
    }
}

class Rectangle extends TwoDShape {
    constructor(width, height, pos, colour) {
        super([
            new Vertex(pos.x, pos.y),
            new Vertex(pos.x + width, pos.y),
            new Vertex(pos.x + width, pos.y + height),
            new Vertex(pos.x, pos.y + height)], colour);
        this.numSides = 4;
        }
}

class Rhomboid extends TwoDShape {
    constructor(width, height, pos, bottomOffset, colour) {
        super([
            new Vertex(pos.x, pos.y),
            new Vertex(pos.x + width, pos.y),
            new Vertex(pos.x + width + bottomOffset, pos.y + height),
            new Vertex(pos.x + bottomOffset, pos.y + height)], colour);
        this.numSides = 4;
        }
}

var canvas;
var ctx;

function main() {    
    canvas = document.getElementById("cvs");
    ctx = canvas.getContext("2d");
    
    //let s = new Square(48000, new Vertex(50, 50), "#FF00FF");
    //let s = new Rectangle(200, 100, new Vertex(50, 50), "#FF00FF");
    let s = new Rhomboid(200, 100, new Vertex(50, 50), 50, "#FF00FF");
    draw(s);
}

function draw(s) {
    ctx.beginPath();
    ctx.moveTo(s.vertices[0].x, s.vertices[0].y);
    ctx.strokeStyle = s.colour;
    
    s.vertices.forEach(v => {
        ctx.lineTo(v.x, v.y);
        ctx.moveTo(v.x, v.y);
    });
    ctx.lineTo(s.vertices[0].x, s.vertices[0].y);
    ctx.stroke();
}