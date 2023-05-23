import g4p_controls.*;
import processing.serial.*;
import java.util.LinkedList;
//import java.util.ArrayList;

// The serial port:
Serial zumoPort;
LinkedList messages;

public void setup() {
  messages = new LinkedList<String>();
  printArray(Serial.list());
  //String portName = choosePort();
  //while (zumoPort == null) {
  //}
  //if (zumoPort == null) {
  //  println("Failed to find serial port. Please make sure the Zumo is connected and running acknowledgement code");
  //} else {
  //  print("Found serial port ");
  //}
  
  
  zumoPort = new Serial(this, Serial.list()[2], 9600);
  zumoPort.bufferUntil(10);
  
  size(500, 360);
  createGUI();
}

public void draw() {
  background(200);
  
  //if (messages.size() > 0) {
  //  String newMsg = messages.removeFirst().toString();
  //  txtReceivedMsgs.appendText(newMsg);
  //}
  if (zumoPort.available() > 0) {
    String inString = zumoPort.readString();
    // use readChar() instead, should append the linefeed when it is received
    print(inString);
    txtReceivedMsgs.appendText(inString);
  }
}

//public String choosePort() {
//  for (String portName : Serial.list()) {
//    println(portName);
//    try {
//      Serial port = new Serial(this, portName, 9600);
//      port.write(char(5));
//      println(portName);
//      delay(1000);
//      if (port.available() == 1 && port.lastChar() == char(6)) {
//        port.stop();
//        return portName;
//      }
//      port.stop();
//    } catch(Exception e) {
//      e.printStackTrace();
//    }
//  }
  
//  return "-";
//}

public void SerialEvent(Serial p) {
  println("serial");
  //if (zumoPort == null && p.readChar() == char(5)) {
  //  zumoPort = p;
  //  zumoPort.bufferUntil(10);
  //  return;
  //}
  String msg = p.readString();
  messages.add(msg);
}

void keyPressed() {
  switch(keyCode) {
    case UP: // W
      zumoPort.write("W#");
      break;
    case LEFT: // A
      zumoPort.write("A#");
      break;
    case DOWN: // S
      zumoPort.write("S#");
      break;
    case RIGHT: // D
      zumoPort.write("D#");
      break;
  }
}

void keyReleased() {
  zumoPort.write("w#");
}
