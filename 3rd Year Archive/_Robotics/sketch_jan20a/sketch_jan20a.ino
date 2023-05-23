/*int switchState = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(3,OUTPUT);
  pinMode(4,OUTPUT);
  pinMode(5,OUTPUT);
  pinMode(2,INPUT);

}

void loop() {
  // put your main code here, to run repeatedly:
  switchState = digitalRead(2);

   if (switchState == LOW) {
     // the buton is not pressed
     digitalWrite(3, HIGH); // green LED
     digitalWrite(4, LOW); // red LED
     digitalWrite(5, LOW); // red LED
   } else { // the buton is pressed
     digitalWrite(3, LOW);
     digitalWrite(4, LOW);
     digitalWrite(5, HIGH);
     delay(250); // wait for a quarter second
     // toggle the LEDs
     digitalWrite(4, HIGH);
     digitalWrite(5, LOW);
     delay(250); // wait for a quarter second
   }
}*/

const int sensorPin = A0;
const float baselineTemp = 22.0;

void setup() {
  Serial.begin(9600);

  for(int pinNumber = 2; pinNumber < 5; pinNumber++) {
    pinMode(pinNumber, OUTPUT);
    digitalWrite(pinNumber, LOW);
  }
}

void loop() {
  int sensorVal = analogRead(sensorPin);
  Serial.print("Sensor value: ");
  Serial.print(sensorVal);
  float voltage = (sensorVal/1024.0) * 5.0;
  Serial.print(", Volts: ");
  Serial.print(voltage);
  Serial.print(", degrees C: ");
  // convert the voltage to temperature in degrees
  float temperature = (voltage - .5) * 100;
  Serial.println(temperature);
  if (temperature < baselineTemp) {
   digitalWrite(2, LOW);
   digitalWrite(3, LOW);
   digitalWrite(4, LOW);
  } else if (temperature >= baselineTemp+2 && temperature < baselineTemp+4) {
   digitalWrite(2, HIGH);
   digitalWrite(3, LOW);
   digitalWrite(4, LOW);
  } else if (temperature >= baselineTemp+4 && temperature < baselineTemp+6) {
   digitalWrite(2, HIGH);
   digitalWrite(3, HIGH);
   digitalWrite(4, LOW); 
   } else if (temperature >= baselineTemp+6) {
   digitalWrite(2, HIGH);
   digitalWrite(3, HIGH);
   digitalWrite(4, HIGH);
   }
   delay(1);
}
