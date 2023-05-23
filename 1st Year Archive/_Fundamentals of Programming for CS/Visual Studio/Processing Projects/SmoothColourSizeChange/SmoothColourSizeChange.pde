public int potato = 0;
public int x = mouseX;
public int y = mouseY;
public boolean sign = false;

void setup()
{
  fullScreen();
}

void draw()
{
  if (!sign || mousePressed)
  {
    potato++;
  } else
  { 
    potato--;
  }

  if (potato > 255)
  {
    sign = true;
  }
  if (potato < 0)
  {
    sign = false;
  }
  
  background(potato, 255 - potato, potato);
  ellipse(mouseX, mouseY, potato, potato);
}