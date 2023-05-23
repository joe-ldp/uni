//Serial1 communicates over XBee
//Serial communicates over USB cable

void setup()
{
  Serial1.begin(9600);
}

void loop()
{
  int incomingByte = 0;
  if (Serial1.available() > 0)
  {
    incomingByte = Serial1.read();
    Serial1.print("I received: ");
    Serial1.print(incomingByte, DEC);
    Serial1.println(" on Serial1");
  }

  else if (Serial.available() > 0)
  {
    incomingByte = Serial.read();
    Serial.print("I received: ");
    Serial.print(incomingByte, DEC);
    Serial.println(" on Serial");
  }
}