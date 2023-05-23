int a = 0;
int b = 0;

void setup()
{
  background(255, 0, 255);
  frameRate(300000000);
  fullScreen();
}
void draw()
{
  b += 25;
  if (b > height + 50)
  {
    a += 25;
    b = 0;
  }
  fill(random(255), random(255), random(255));
  ellipse(a, b, 50, 50);
}