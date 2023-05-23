public float backRand = random(255);

void setup()
{
  fullScreen();
  background(backRand, backRand, backRand);
}

void draw()
{
  background(backRand, backRand, backRand);
  
  stroke(random(255), random(255), random(255));
  fill(random(255), random(255), random(255));
  
  ellipse(mouseX, mouseY, mouseX, height - mouseY);
}