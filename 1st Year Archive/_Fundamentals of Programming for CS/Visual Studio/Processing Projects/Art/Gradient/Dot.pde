// A class that represents one instance of the tool used to draw lines.
class Dot
{
  // Variables
  // The coordinate this dot will navigate towards (until it finds a new one).
  Point target;
  // The radius of the dot's orbital movement
  float orbitRadius;
  // This dot's x and y coordinates, used in the ellipse() command at the end of its Update() function.
  float x;
  float y;
  
  float r;
  float g;
  float b;
  
  // Constructors
  // With position input.
  public Dot(float xi, float yi)
  {
    orbitRadius = 1;
    
    r = random(255);
    g = random(255);
    b = random(255);
    
    x = xi;
    y = yi;
  }
  
  // Without input, randomises orbit radius and position.
  public Dot()
  {
    orbitRadius = random(0.1, 2);
    
    r = random(255);
    g = random(255);
    b = random(255);
    
    x = random(width);
    y = random(height);
  }
  
  // Public function to be called in the draw function (in order to make the code actually do something).
  public void Update()
  {      
      x += (target.x - x) * 0.05;
      y += (target.y - y) * 0.05;
      ellipse(x, y, 10, 10);
    }
  }
}