#include <SPI.h>
#include <Pixy2.h>
#include <Servo.h>

Pixy2 pixy;
Servo middle, left, right, claw;  // creates 4 "servo objects"

int signature = 0;

int midPos = 90;     // 20 - 160 (0 - 90)
int leftPos = 100;   // 30 - 170 ()
int rightPos = 100;  // 30 - 170 ()
int clawPos = 105;   // 30 - 180

void positions() {
  String midPosStr = String(midPos);
  String leftPosStr = String(leftPos);
  String rightPosStr = String(rightPos);
  String clawPosStr = String(145);

  // String midPosStr = String(midPos);
  String msg = ("Mid: " + midPosStr + " left: " + leftPosStr + " right: " + rightPosStr + " claw: " + clawPosStr);
  Serial.println(msg);
  delay(250);
}

void setup() {
  // Serial.begin(115200);
  Serial.begin(9600);
  Serial.println("Starting...");

  middle.attach(10);
  left.attach(9);
  right.attach(6);
  claw.attach(5);

  resetPositions();
  moveArm();

  pixy.init();
  pixy.setLamp(1, 1);

  delay(2000);
}

void loop() {
  // positions();
  int idx = getColourIdx();
  if (idx > 0) {
    Serial.print("Found colour idx: ");
    Serial.println(idx);
    delay(2000);
    moveClaw(false);
    delay(2000);
    moveToSpot(idx);
    delay(2000);
    moveClaw(true);
    delay(2000);
    resetPositions();
    moveArm();
  }
  delay(500);
}

void resetPositions() {
  midPos = 90;     // (0 - 90 used))
  leftPos = 100;   // 30 - 170
  rightPos = 100;  // 30 - 170
  clawPos = 105;   // 30 - 180
}

int getColourIdx() {
  pixy.ccc.getBlocks();
  if (pixy.ccc.numBlocks) {
    return pixy.ccc.blocks[0].m_signature;
  } else {
    return -1;
  }
}

void moveArm() {
  delay(300);
  left.write(leftPos);
  delay(300);
  right.write(rightPos);
  delay(300);
  middle.write(midPos);
  delay(300);
  positions();
}

void moveClaw(bool open) {
  if (open) {
    clawPos = 25;
  } else {
    clawPos = 180;
  }
  delay(300);
  claw.write(clawPos);
  delay(300);
  positions();
}

void moveToSpot(int colourIdx) {
  switch (colourIdx) {
    case 1:
      midPos = 35;
      leftPos = 105;
      rightPos = 180;
      break;
    case 2:
      midPos = 0;
      leftPos = 60;
      rightPos = 170;
      break;
    case 3:
      midPos = 0;
      leftPos = 10;
      rightPos = 135;
      break;
    case 4:
      midPos = 0;
      leftPos = 35;
      rightPos = 150;
      break;
    case 5:
      midPos = 25;
      leftPos = 50;
      rightPos = 155;
      break;
    case 6:
      midPos = 30;
      leftPos = 60;
      rightPos = 165;
      break;
    case 7:
      midPos = 45;
      leftPos = 105;
      rightPos = 180;
      break;
    default:
      resetPositions();
      break;
  }
  moveArm();
}