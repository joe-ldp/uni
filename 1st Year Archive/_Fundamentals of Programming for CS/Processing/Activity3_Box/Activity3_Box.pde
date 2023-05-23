Box[] boxes = new Box[200];

void setup()
{
  int w = 1080;
  int h = 720;
  size(1080, 720);
  
  for (int i = 0; i < boxes.length; i++)
  {
    boxes[i] = new Box();
  }
  
  //frameRate(1);
}

void draw()
{
  noStroke();
  fill(255,255,255);
  rect(0, 0, width, height);
  
  for (int i = 0; i < boxes.length; i++)
  {
    boxes[i].draw();
  }
  
  for (int i = 0; i < boxes.length; i++)
  {
    if (i != boxes.length-1)
    {
      if (checkColl(boxes[i], boxes[i+1]))
      {
        boxes[i].ping();
        boxes[i+1].ping();
      }
    }
    else
    {
      if (checkColl(boxes[i], boxes[i-1]))
      {
        boxes[i].ping();
        boxes[i-1].ping();
      }
    }
  }
}

boolean checkColl(Box a, Box b)
{
  boolean coll = false;
  for (int ax = a.coord().x; ax < 100; ax++)
  {
    for (int ay = a.coord().y; ay < 100; ay++)
    {
      if (new Point(ax, ay) == b.coord())
      {
        coll = true;
      }
    }
  }
  
  return coll;
}