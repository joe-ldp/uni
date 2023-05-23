public class ChildApplet extends PApplet
{
  int x, y, w = 128, h = 128;
  float f;
  PVector acr, pos, ofst;

  ChildApplet(int idx)
  {
    acr = new PVector(idx*hInterval-amt*.5*hInterval+960, 540);
    ofst = new PVector(0, 0);
    pos = new PVector(0, 0);
    f = TWO_PI/amt*idx;
  }

  void update()
  {
    
    ofst.set(
      cos(f)*hRange, sin(f)*vRange);
    
    f += PI*.01;

    pos.set(
      acr.x + ofst.x, 
      acr.y + ofst.y
      );
      
    w = round(128 + sin(f*2)*64);
    h = round(128 + cos(f*4)*64);

    x = int(pos.x);
    y = int(pos.y);
  }
}