// const { rgb2lab, lab2rgb, deltaE } = require('rgb-lab');
import { rgb2lab, lab2rgb, deltaE } from 'rgb-lab';

class Colour {
    constructor(r, g, b, a = 255) {
        this.rgba = { r, g, b, a };
        this.lab = rgb2lab([r, g, b]);
    }

    difference(other) {
        return deltaE(this.lab, other.lab);
    }

    rgbaArray() {
        return [this.r, this.g, this.b, this.a];
    }
}

// Pantone PMS codes for the colours used in the game
// - Red : 186C
// - Yellow : 123C
// - Black : 433C
// - Pink : 184C
// - Green : 3302C
// - Blue : 2945C
// - Brown : 469C
// - Cue ball : Ivory 1205C

let colours = [
    new Colour(200, 16, 46),  // red
    new Colour(255, 199, 44), // yellow
    new Colour(29, 37, 45),   // black
    new Colour(246, 82, 117), // pink
    new Colour(0, 76, 69),    // green
    new Colour(0, 76, 151),   // blue
    new Colour(105, 63, 35),  // brown
    new Colour(248, 224, 142) // white
];