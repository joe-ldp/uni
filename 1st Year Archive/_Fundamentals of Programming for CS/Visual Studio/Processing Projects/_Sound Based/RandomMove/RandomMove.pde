public float posX;
public float weightX;
public float posY;
public float weightY;

import processing.sound.*;
Amplitude amp;
AudioIn in;

void setup()
{
  fullScreen();

  posX = width / 2;
  posY = height / 2;
  
  weightX = random(-2, 1);
  weightY = random(-2, 1);

  stroke(0);
  fill(200);
  
  frameRate(1000000);
  
  amp = new Amplitude(this);
  in = new AudioIn(this, 0);
  in.start();
  amp.input(in);
}

void draw()
{
  //background(150);
  
  posX = (random(posX - 10, posX + 10)) + weightX;
  posY = (random(posY - 10, posY + 10)) + weightY;
  
  if (posX > width)
  {
    posX = width;
    weightX = random(-1, 1);
  }
  if (posX < 0)
  {
    posX = 0;
    weightX = random(-1, 1);

  }
  if (posY > height)
  {
    posY = height;
    weightY = random(-1, 1);
  }
  if (posY < 0)
  {
    posY = 0;
    weightY = random(-1, 1);
  }
  
  ellipse(posX, posY, 50, 50);
}