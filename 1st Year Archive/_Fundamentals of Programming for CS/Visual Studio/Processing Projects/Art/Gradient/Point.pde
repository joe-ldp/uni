// Basic class for storing coordinates.
class Point
{
  public float x;
  public float y;
  
  // Constructors
  // Without inputs, randomises x and y.
  public Point()
  {
    x = random(width);
    y = random(height);
  }
  
  // With inputs.
  public Point(float xi, float yi)
  {
    x = xi;
    y = yi;
  }
}