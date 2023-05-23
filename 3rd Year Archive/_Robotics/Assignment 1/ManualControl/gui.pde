public void txtReceivedMsgs_change(GTextArea source, GEvent event) {
  //println("txtReceivedMsgs - GTextArea >> GEvent." + event + " @ " + millis());
}

public void btnSendMsg_click(GButton source, GEvent event) {
  println("btnSendMsg - GButton >> GEvent." + event + " @ " + millis());
  zumoPort.write(txtMsgToSend.getText());
}

public void txtMsgToSend_change(GTextField source, GEvent event) {
  //println("txtMsgToSend - GTextField >> GEvent." + event + " @ " + millis());
}

public void btnLeft_click(GButton source, GEvent event) {
  println("btnLeft - GButton >> GEvent." + event + " @ " + millis());
  if (event == GEvent.PRESSED)
    zumoPort.write("A#");
  else if (event == GEvent.RELEASED || event == GEvent.CLICKED)
    zumoPort.write("w#");
}

public void btnRight_click(GButton source, GEvent event) {
  println("btnRight - GButton >> GEvent." + event + " @ " + millis());
  if (event == GEvent.PRESSED)
    zumoPort.write("D#");
  else if (event == GEvent.RELEASED || event == GEvent.CLICKED)
    zumoPort.write("w#");
}

public void btnForward_click(GButton source, GEvent event) {
  println("btnForward - GButton >> GEvent." + event + " @ " + millis());
  if (event == GEvent.PRESSED)
    zumoPort.write("W#");
  else if (event == GEvent.RELEASED || event == GEvent.CLICKED)
    zumoPort.write("w#");
}

public void btnBackward_click(GButton source, GEvent event) {
  println("btnBackward - GButton >> GEvent." + event + " @ " + millis());
  if (event == GEvent.PRESSED)
    zumoPort.write("S#");
  else if (event == GEvent.RELEASED || event == GEvent.CLICKED)
    zumoPort.write("w#");
}

// Create all the GUI controls.
public void createGUI() {
  G4P.messagesEnabled(false);
  G4P.setGlobalColorScheme(GCScheme.BLUE_SCHEME);
  G4P.setCursor(ARROW);
  surface.setTitle("Search & Rescue Control Centre");
  
  txtReceivedMsgs = new GTextArea(this, 237, 11, 198, 199, G4P.SCROLLBARS_BOTH | G4P.SCROLLBARS_AUTOHIDE);
  txtReceivedMsgs.setText("Messages from Zumo");
  txtReceivedMsgs.setLocalColorScheme(GCScheme.PURPLE_SCHEME);
  txtReceivedMsgs.setOpaque(true);
  txtReceivedMsgs.addEventHandler(this, "txtReceivedMsgs_change");
  
  btnSendMsg = new GButton(this, 19, 275, 91, 60);
  btnSendMsg.setTextAlign(GAlign.CENTER, GAlign.CENTER);
  btnSendMsg.setText("Send message to Zumo");
  btnSendMsg.setTextBold();
  btnSendMsg.setLocalColorScheme(GCScheme.PURPLE_SCHEME);
  btnSendMsg.addEventHandler(this, "btnSendMsg_click");
  
  txtMsgToSend = new GTextField(this, 110, 300, 160, 30, G4P.SCROLLBARS_NONE);
  txtMsgToSend.setText("Messages To Zumo");
  txtMsgToSend.setLocalColorScheme(GCScheme.PURPLE_SCHEME);
  txtMsgToSend.setOpaque(true);
  txtMsgToSend.addEventHandler(this, "txtMsgToSend_change");
  
  btnLeft = new GButton(this, 11, 169, 80, 30);
  btnLeft.setText("Left");
  btnLeft.setTextBold();
  btnLeft.addEventHandler(this, "btnLeft_click");
  btnLeft.fireAllEvents(true);
  
  btnRight = new GButton(this, 127, 171, 80, 31);
  btnRight.setText("Right");
  btnRight.setTextBold();
  btnRight.addEventHandler(this, "btnRight_click");
  btnRight.fireAllEvents(true);
  
  btnForward = new GButton(this, 71, 121, 80, 30);
  btnForward.setText("Forward");
  btnForward.setTextBold();
  btnForward.addEventHandler(this, "btnForward_click");
  btnForward.fireAllEvents(true);
  
  btnBackward = new GButton(this, 69, 225, 80, 30);
  btnBackward.setText("Back");
  btnBackward.setTextBold();
  btnBackward.addEventHandler(this, "btnBackward_click");
  btnBackward.fireAllEvents(true);
}

// GUI declarations
GTextArea txtReceivedMsgs; 
GButton btnSendMsg; 
GTextField txtMsgToSend; 
GButton btnLeft; 
GButton btnRight; 
GButton btnForward; 
GButton btnBackward; 
