#include "PretendServo.h"

int k = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  attach();
}

void loop() {
  // put your main code here, to run repeatedly:
  Serial.println("Hello");
  delay(1000);
  write(k);
  k+= 1;
} 
