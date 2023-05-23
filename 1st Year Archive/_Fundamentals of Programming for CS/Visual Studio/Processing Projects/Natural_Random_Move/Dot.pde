class Dot
{
  public float x;
  public float y;

  float r;
  float ox;
  float oy;

  public Dot(float xi, float yi)
  {
    x = xi;
    y = yi;

    ox = x;
    oy = y;

    r = 50;
  }

  public void Show()
  {
    ellipse(x, y, r, r);
  }

  public void Update()
  {
    if (mousePressed && dist(x, mouseX, y, mouseY) <= er)
    {
      MouseUpdate();
    }
    else if (!mousePressed || dist(x, mouseX, y, mouseY) > er)
    {
      NonMouseUpdate();
    }
  }
  
  public void MouseUpdate()
  {
    if (dist(x, mouseX, y, mouseY) <= er)
    {
      x -= (mouseX - x) * 0.01;// * (1 / dist(x, mouseX, y, mouseY));
      y -= (mouseY - y) * 0.01;// * (1 / dist(x, mouseX, y, mouseY));
    }
  }
  
  public void NonMouseUpdate()
  {
    x += (ox - x) * 0.1;
    y += (oy - y) * 0.1;
  }
}