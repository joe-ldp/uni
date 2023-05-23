class Box
{
  float xpos, ypos;
  float speedX, speedY;
  
  Box()
  {
    xpos = random(0, width);
    ypos = random(0, height);
    
    speedX = random(5, 10);
    speedY = random(5, 10);
  }
  
  Point coord()
  {
    return new Point((int)xpos, (int)ypos);
  }
  
  void ping()
  {
    speedX = -speedX;
    speedY = -speedY;
    print("pong!");
  }

  void draw()
  {
    
    noStroke();
    fill(255,255,255);
    
    xpos+= speedX;
    if (xpos<0)
    {
      xpos=0;
      speedX = -speedX;
    }
     else
     {
       if (xpos>(width-100))
       {
         xpos=(width-100);
         //speedX=random(40,50);
         speedX = -speedX;  
       }
     }
       
    ypos+= speedY;
    if (ypos<0)
    {
      ypos=0;
      speedY = -speedY;
    }
    else
    {
      if (ypos>(height-100))
      {
        ypos=(height-100);
        //speedY=random(40, 50);
        speedY = -speedY;
      }
    }
    
    float r = 0, b = 0;
    if (xpos > width/2)
    {
      r = width-xpos;
    }
    else
    {
      r = xpos;
    }
    if (ypos > height/2)
    {
      b = height-ypos;
    }
    else
    {
      b = ypos;
    }
    fill(r, 255, b);
    //fill(100, 100, 100);
    
    rect(xpos, ypos, 100, 100);
    
    //print("hello i am box yes\n");
  }
}