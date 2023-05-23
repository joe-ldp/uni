//Dice[] dice = new Dice[5];
ArrayList<Dice> dice = new ArrayList<Dice>();
ArrayList<Dice> held = new ArrayList<Dice>();
boolean go;

Point paP = new Point(400, 90);
int paS = 555;

void setup()
{
  size(1024, 768);
  background(135, 65, 15);
  
  /*textSize(50);
  textAlign(LEFT);
  text("YAHTZEE", 300, 50);
  textAlign(CENTER);
  text("YAHTZEE", 300, 100);
  textAlign(RIGHT);
  text("YAHTZEE", 300, 150);
  line(300, 0, 300, height);*/
  
  // REGION Dice
  
  for (int i = 0; i < 5; i++)
  {
    dice.add(new Dice(6, paP, paS));
  }
  for (int i = 0; i < dice.size(); i++)
  {
    dice.get(i).Roll();
  }
  
  // END REGION
}

void draw()
{
  background(135, 65, 15);
  Text();
  PlayArea();
  
  strokeWeight(5);
  stroke(0, 100, 0);
  
  fill(20, 240, 20);
  rect(paP.x, paP.y, paS, paS);
  
  for (int i = 0; i < dice.size(); i++)
  {
    if (go) dice.get(i).Roll();
    dice.get(i).draw();
  }
  
  
}

void Text()
{
  textSize(40);
  textAlign(LEFT);
  fill(255, 255, 255);
  text("YAHTZEE", 30, 50);
  
  text("1. Ones:", 30, 120);
  text("2. Twos:", 30, 160);
  text("3. Threes:", 30, 200);
  text("4. Fours:", 30, 240);
  text("5. Fives:", 30, 280);
  text("6. Sixes:", 30, 320);
}

void PlayArea()
{
  strokeWeight(5);
  stroke(0, 100, 0);
  
  fill(20, 240, 20);
  rect(paP.x, paP.y, paS, paS);
}

void keyPressed()
{
  //print(keyCode);
  if (keyCode == 82)
  {
    go = !go;
  }
}