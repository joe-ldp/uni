import processing.serial.*;
import g4p_controls.*;

Serial connexion;;

int bgcol = 15;

public void setup() {
  String portName = Serial.list()[1];
  connexion = new Serial(this, portName, 9600);
  size(500, 360);
  createGUI();
}

public void draw() {
  background(200, 200, 200);

}