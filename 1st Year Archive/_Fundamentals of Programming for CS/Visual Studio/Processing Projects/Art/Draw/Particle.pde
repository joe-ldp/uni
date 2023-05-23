class Particle
{
  PVector pos;
  int lifeSpan, passedLife;
  boolean dead;
  float weight, decay;
  color col;
  
  Particle(PVector pos_)
  {
    
  }
  
  void Update()
  {
    
  }
  
  void Display()
  {
    strokeWeight(weight+1.5);
    stroke(0);
    point(pos.x, pos.y);
    
    strokeWeight(weight);
    stroke(col);
    point(pos.x, pos.y);
  }
}