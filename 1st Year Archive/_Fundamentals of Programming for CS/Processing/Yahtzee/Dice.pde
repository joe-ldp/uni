class Dice
{
  int posX, posY;
  int speedX, speedY;
  int numSides;
  Point paP;
  int paS;
  
  Dice(int numSides_, Point paP_, int paS_)
  {
    numSides = numSides_;
    paP = paP_;
    paS = paS_;
    
    posX = (int)random(paP.x+5, paP.x+paS-75);
    posY = (int)random(paP.y+5, paP.y+paS-75);
    speedX = 3;
    speedY = 3;
  }
  
  void draw()
  {
    
  }
  
  int Roll()
  {
    posX+= speedX;
    if (posX<paP.x+5)
    {
      speedX = -speedX;
    }
     else
     {
       if (posX>(paP.x+paS-80))
       {
         speedX = -speedX;  
       }
     }
       
    posY+= speedY;
    if (posY<paP.y+5)
    {
      speedY = -speedY;
    }
    else
    {
      if (posY>(paP.y+paS-80))
      {
        speedY = -speedY;
      }
    }
    
    strokeWeight(2);
    stroke(0, 0, 0);
    fill(255, 255, 255);
    rect(posX, posY, 75, 75);
    
    noStroke();
    fill(0, 0, 0);
    textAlign(CENTER, CENTER);
    text(round(random(1, numSides)), posX+75/2, posY+70/2);
    
    return 0;
  }
}