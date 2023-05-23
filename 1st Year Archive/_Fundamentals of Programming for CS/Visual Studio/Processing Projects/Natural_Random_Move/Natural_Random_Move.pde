public static ArrayList<Dot> dots = new ArrayList<Dot>();

public static float er = 200;

float x;
float y;

void setup()
{
  fullScreen();
  //size(1536, 864);

  background(0);
  stroke(255);
  noFill();

  for (int x = 0; x < width; x++)
  {
    if (x % 50 == 0)
    {
      for (int y = 0; y < height; y++)
      {
        if (y % 50 == 0)
        {
          dots.add(new Dot(x, y));
        }
      }
    }
  }
}

void draw()
{
  
  background(0);
  
  for (Dot d : dots)
  {
    d.Update();
    d.Show();
  }
}