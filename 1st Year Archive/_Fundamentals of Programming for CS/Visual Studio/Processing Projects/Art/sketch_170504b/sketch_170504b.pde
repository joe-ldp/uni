int x;
int y;

void setup()
{
  fullScreen();
  stroke(255);
}

void draw()
{
  ellipse(x, y, 10, 10);
  x += ((mouseX - x) + sin(mouseX - x)) * 0.1;
  y += ((mouseY - y)) * 0.1;
}