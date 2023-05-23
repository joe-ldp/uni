import g4p_controls.*;
import processing.serial.*;

int bgcol = 15;

// The serial port:
Serial zumoPort;

public void setup() {
  // List all the available serial ports:
  printArray(Serial.list());
  
  // Open the port you are using at the rate you want:
  zumoPort = new Serial(this, Serial.list()[2], 9600);
  zumoPort.bufferUntil(10);
  
  // Send a capital "A" out the serial port
  zumoPort.write(65);
  
  size(500, 360);
  createGUI();
}

public void draw() {
  background(200, 200, 200);

}
