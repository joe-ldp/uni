// PretendServo.cpp
#include <Arduino.h>
#include "PretendServo.h"

void attach(){
  Serial.println("servo attached");
}

void detach(){
  Serial.println("servo detached");
}

void write(int x){
  Serial.print("writing ");
  Serial.println(x);
} 
