public float r;
public float g;
public float b;
public float posX;
public float weightX;
public float posY;
public float weightY;
public boolean rgbAscend = true;

void setup()
{
  fullScreen();
  //size(150, 150);

  posX = width / 2;
  posY = height / 2;
  
  weightX = random(-2, 1);
  weightY = random(-2, 1);

  stroke(0);
  fill(200);
  
  frameRate(1000000);
}

void draw()
{
  if (rgbAscend)
    RGBAscend();
  else
    RGBDescend();
  
  stroke(255);
  fill(r, g, b);
  
  posX = random(posX - 10, posX + 10);
  posY = random(posY - 10, posY + 10);
  
  
  if (frameCount % 240 == 0)
  {
    posX += weightX;
    posY += weightY;
  }
  
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

void RGBAscend()
{
  if (r < 255)
  {
    r++;
  }
  else
  {
    if (g < 255)
    {
      g++;
    }
    else
    {
      if (b < 255)
      {
        b++;
      }
      else
      {
        rgbAscend = false;
      }
    }
  }
}

void RGBDescend()
{
  if (r > 0)
  {
    r--;
  }
  else
  {
    if (g > 0)
    {
      g--;
    }
    else
    {
      if (b > 0)
      {
        b--;
      }
      else
      {
        rgbAscend = true;
      }
    }
  }
}