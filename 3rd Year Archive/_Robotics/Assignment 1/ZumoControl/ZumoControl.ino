#include <Wire.h>
#include <Zumo32U4.h>

Zumo32U4Motors motors;
Zumo32U4Buzzer buzzer;
Zumo32U4ButtonA buttonA;
Zumo32U4LineSensors lineSensors;
Zumo32U4ProximitySensors proxSensors;
int speed = 200;
bool connected = false;

void setup() {
  Serial.begin(9600);
  Serial1.begin(9600);

  lineSensors.initFiveSensors();
  proxSensors.initFrontSensor();
}

void loop() {
  // if (!connected) {
  //   Serial.write(5);
  //   Serial1.write(5);
  //   if ((Serial1.available() > 0 && Serial1.read() == 6) || (Serial.available() > 0 && Serial.read() == 6)) {
  //     connected = true;
  //   }
  // }
  if (Serial1.available() > 0 || Serial.available() > 0) {
    int incomingByte;
    if (Serial1.available() > 0)
      incomingByte = Serial1.read();
    else
      incomingByte = Serial.read();
    // Serial1.print("I received: ");
    // Serial1.println(incomingByte, DEC);
    // Serial.print("I received: ");
    // Serial.println(incomingByte, DEC);

    switch(incomingByte) {
      case 87: // W
        motors.setLeftSpeed(speed);
        motors.setRightSpeed(speed);
        break;
      case 65: // A
        motors.setLeftSpeed(-speed);
        motors.setRightSpeed(speed);
        break;
      case 83: // S
        motors.setLeftSpeed(-speed);
        motors.setRightSpeed(-speed);
        break;
      case 68: // D
        motors.setLeftSpeed(speed);
        motors.setRightSpeed(-speed);
        break;
      case 119: // w
        motors.setLeftSpeed(0);
        motors.setRightSpeed(0);
        break;
      case 43:
        speed += 10;
        Serial.print("Increased speed to: ");
        Serial.println(speed, DEC);
        Serial1.print("Increased speed to: ");
        Serial1.println(speed, DEC);
        break;
      case 45:
        speed -= 10;
        speed = max(speed, 10);
        Serial.print("Decreased speed to: ");
        Serial.println(speed, DEC);
        Serial1.print("Decreased speed to: ");
        Serial1.println(speed, DEC);
        break;
    }
  }
  
//  proxSensors.read();
//  if (proxSensors.countsFrontWithLeftLeds() >= 2 || proxSensors.countsFrontWithRightLeds() >= 2) {
//    Serial1.println("Detected an object");
//  }
}
