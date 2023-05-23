void setup() {
  // initialize serial communication:
  Serial.begin(9600);
  Serial.println("waiting");
  pinMode(13, OUTPUT);
}

bool running = false;

void loop(){
  if (Serial.available() > 0) {
    
    char inChar = (char)Serial.read();
    
    if ( inChar == 'g')
      running = true;
    else if (inChar == 's') {
      running = false;
      Serial.println("\t === STOPPED");
    }
  }

  if (running) {
    Serial.println("running");
    digitalWrite(13, HIGH);
    delay(500);
    digitalWrite(13, LOW);
    delay(500);
  }
} 
