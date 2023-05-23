#include <Arduino.h>
#include <Servo.h>
 
Servo middle, left, right, claw;
bool running = false;
char action;
int midPos = 90;
int leftPos = 90;
int rightPos = 90;
int clawPos = 90;

void setup()
{
  Serial.begin(9600);

  // middle.attach(5);
  // left.attach(10);
  // right.attach(9);
  // claw.attach(6);

  middle.attach(10);
  left.attach(9);
  right.attach(6);
  claw.attach(5);

  middle.write(midPos);
  left.write(leftPos);
  right.write(rightPos);
  claw.write(clawPos);
}

void positions()
{
  String midPosStr = String(midPos);
  String leftPosStr = String(leftPos);
  String rightPosStr = String(rightPos);
  String clawPosStr = String(clawPos);

  // String midPosStr = String(midPos);
  String msg = ("Mid: " + midPosStr + " left: " + leftPosStr + " right: " + rightPosStr + " claw: " + clawPosStr);
  Serial.println(msg);
  delay(250);
}

void loop()
{
  if (Serial.available() > 0)
  {
    action = (char)Serial.read();

    switch (action)
    {
    case 'a':
      midPos -= 5;
      middle.write(midPos);
      break;
    case 's':
      midPos += 5;
      middle.write(midPos);
      break;
    case 'l':
      leftPos -= 5;
      left.write(leftPos);
      break;
    case 'k':
      leftPos += 5;
      left.write(leftPos);
      break;
    case 'p':
      rightPos -= 5;
      right.write(rightPos);
      break;
    case 'o':
      rightPos += 5;
      right.write(rightPos);
      break;
    case 'c':
      clawPos -= 5;
      claw.write(clawPos);
      break;
    case 'x':
      clawPos += 5;
      claw.write(clawPos);
      break;
    default:
      // Serial.println(("Invalid choice"));
      positions();
    }
  }
}
