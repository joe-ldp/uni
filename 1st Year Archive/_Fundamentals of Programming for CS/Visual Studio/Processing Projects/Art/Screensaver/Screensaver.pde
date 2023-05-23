// A globally available list of points (a class with a public x and y float, representing coordinates), these are what the dots navigate towards to draw lines.
public static ArrayList<Point> points = new ArrayList<Point>();
// A list of the dots that will be moving towards the points.
ArrayList<Dot> dots = new ArrayList<Dot>();
int count = 0;
int r;
int g;
int b;
boolean rgbAscend;
int numPoints;

// setup() is the first function that is called, equivalent to static void Main(string[] args) in standard C#, or void Start() / void Awake() in Unity. This should be used for declaration.
void setup()
{
  // Set up the canvas; make it fullscreen and limit (and target) the framerate to 60 (generally a good default to go for).
  fullScreen();
  //size(500, 500);
  
  background(r, g, b);
  
  frameRate(50);
  
  // This is the number of points that the dots will be navigating to. *** Try changing this number and see what it does to the code! ***
  numPoints = 100;
  
  // Initialise the above number of points.
  for (int i = 0; i < numPoints; i++)
  {
    points.add(new Point());
  }
  
  // Initialise four times as many dots.
  for (int i = 0; i < numPoints * 4; i++)
  {
    dots.add(new Dot());
  }
  /*
  for (int i = 0; i < width; i++)
  {
    if (i % 4 == 0)
      dots.add(new Dot(i, 0));
  }
  for (int i = 0; i < width; i++)
  {
    if (i % 4 == 0)
      dots.add(new Dot(i, height));
  }
  for (int i = 0; i < height; i++)
  {
    if (i % 4 == 0)
      dots.add(new Dot(0, i));
  }
  for (int i = 0; i < height; i++)
  {
    if (i % 4 == 0)
     dots.add(new Dot(width, i));
  }
  */
}

// draw() is where all the fancy stuff happens. This is called once per frame; here is where to put any and all of the runtime code (or references to runtime code, e.g. "d.Update()" which then draws to the canvas).
void draw()
{
  println(frameRate);
  
  if (rgbAscend)
    RGBAscend();
  else
    RGBDescend();
  
  stroke(r, g, b);
  fill(r, g, b);
  
  // Iterate through all of the existent dots.
  for (Dot d : dots)
  {
    // For each one, call its respective update function.
    d.Update();
  }
  
  count++;
  
  if (points.size() > 1)
  {
    if (count >= 60)
    {
      for (int i = 0; i < points.size() / 2; i++)
      {
        //points.remove((int)random(points.size()));
      }
      
      background(r, g, b);
        
      count = 0;
      
      ArrayList<Dot> dotsToRemove = new ArrayList<Dot>();
      for (Dot d : dots)
      {
        dotsToRemove.add(d);
      }
      for (Dot d : dotsToRemove)
      {
        dots.remove(d);
      }
      
      
      ArrayList<Point> pointsToRemove = new ArrayList<Point>();
      float numOfPoints = points.size();
      
      for (Point p : points)
      {
        pointsToRemove.add(p);
      }
      for (Point p : pointsToRemove)
      {
        points.remove(p);
      }
      for (int j = 0; j < numOfPoints; j++)
      {
        points.add(new Point());
      }
      
      
      for (int j = 0; j < numPoints * 4; j++)
      {
        dots.add(new Dot());
      }
      
      /*
      for (int j = 0; j < width; j++)
      {
        if (j % 4 == 0)
          dots.add(new Dot(j, 0));
      }
      for (int j = 0; j < width; j++)
      {
        if (j % 4 == 0)
          dots.add(new Dot(j, height));
      }
      for (int j = 0; j < height; j++)
      {
        if (j % 4 == 0)
          dots.add(new Dot(0, j));
      }
      for (int j = 0; j < height; j++)
      {
        if (j % 4 == 0)
          dots.add(new Dot(width, j));
      }
      */
    }
  }
}

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
    orbitRadius = 1;
    
    r = random(255);
    g = random(255);
    b = random(255);
    
    x = random(width);
    y = random(height);
  }
  
  // Public function to be called in the draw function (in order to make the code actually do something).
  public void Update()
  {
    Point nearest = points.get(int(random(points.size())));
    Point currentPos = new Point(x, y);
    
    for (Point p : points)
    {
      if (ACloserThanB(currentPos, p, nearest))
      {
        nearest = p;
      }
    }
    
    target = nearest;
    //println(round(target.x), round(target.y));
    
    if (target.x - x != 0 && target.y - y != 0)
    {
      //fill(r, g, b);
      //stroke(r/2, g/2, b/2);
      
      x += (target.x - x) * 0.;
      y += (target.y - y) * 0.05;
      
      float size = dist(x, y, target.x, target.y) / 2;
      //float size = 20;
      
      if (target.x - x > 0 && target.y - y < 0)
      {
        ellipse(x - ((orbitRadius) * cos((((g)) * PI)/180)), y + ((orbitRadius) * sin((((g)) * PI)/180)), size, size);
      }
      if (target.x - x > 0 && target.y - y > 0)
      {
        ellipse(x - ((orbitRadius) * cos((((g)) * PI)/180)), y - ((orbitRadius) * sin((((g)) * PI)/180)), size, size);
      }
      if (target.x - x < 0 && target.y - y > 0)
      {
        ellipse(x + ((orbitRadius) * cos((((g)) * PI)/180)), y - ((orbitRadius) * sin((((g)) * PI)/180)), size, size);
      }
      if (target.x - x < 0 && target.y - y < 0)
      {
        ellipse(x + ((orbitRadius) * cos((((g)) * PI)/180)), y + ((orbitRadius) * sin((((g)) * PI)/180)), size, size);
      }
      //if (target.x - x == 0 || target.y - y == 0)
      //{
      //  ellipse(x, y, 10, 10);
      //}
      
      /*
      x += (target.x - x) * 0.05;
      y += (target.y - y) * 0.05;
      ellipse(x, y, 10, 10);
      */
    }
  }
}

boolean ACloserThanB (Point pos, Point a, Point b)
{
  float aDist = dist(pos.x, pos.y, 0, a.x, a.y, 0);
  float bDist = dist(pos.x, pos.y, 0, b.x, b.y, 0);
  
  if (aDist < bDist)
  {
    return true;
  }
  else
  {
    return false;
  }
}

int potato = 255 / int(random(4, 10));

void RGBAscend()
{
  if (r < 255)
  {
    r += potato;
  }
  else
  {
    if (g < 255)
    {
      g += potato;
    }
    else
    {
      if (b < 255)
      {
        b += potato;
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
    r -= potato;
  }
  else
  {
    if (g > 0)
    {
      g -= potato;
    }
    else
    {
      if (b > 0)
      {
        b -= potato;
      }
      else
      {
        rgbAscend = true;
      }
    }
  }
}

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