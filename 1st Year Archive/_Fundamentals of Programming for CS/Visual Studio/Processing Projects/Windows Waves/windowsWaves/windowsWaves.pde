ChildApplet [] cas;
ChildFrame [] cfs;

int amt = 50;
float hInterval = 5;
float hRange = 128;
float vRange = 128;

void setup()
{
  size(150, 150);
  cas = new ChildApplet[amt];
  cfs = new ChildFrame[amt];

  for (int i = 0; i < amt; i++)
  {
    cas[i] = new ChildApplet(i);
    cfs[i] = new ChildFrame(cas[i]);
  }
}

void draw()
{
  background(255);

  for (int i = 0; i < amt; i++)
  {
    cas[i].update();
    cfs[i].setBounds(cas[i].x-cas[i].w/2, cas[i].y-cas[i].h/2, cas[i].w+19, cas[i].h+48);
  }
}