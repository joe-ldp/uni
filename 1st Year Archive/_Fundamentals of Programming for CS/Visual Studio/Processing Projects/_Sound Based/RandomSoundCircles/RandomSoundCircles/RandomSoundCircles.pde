import processing.sound.*;

public static Amplitude amp;
public AudioIn audioIn;
SoundFile audio;

ArrayList<lDot> dots = new ArrayList<lDot>();

void setup()
{
  //fullScreen();
  size(600, 400);

  stroke(0);
  fill(255);

  frameRate(60);

  amp = new Amplitude(this);
  
  //audioIn = new AudioIn(this, 0);
  //audioIn.start();
  //amp.input(audioIn);
  
  audio = new SoundFile(this, "Rare.mp3");
  audio.play();
  amp.input(audio);
  
  for (int i = 0; i < 8; i++)
    dots.add(new lDot());
  
  for (lDot dot : dots)
  {
    dot.init();
    
    for (int i = 0; i < 10; i++)
    {
      dot.AddSDot();
    }
  }
}

void draw()
{
  background(150);
  
  for (lDot dot : dots)
    dot.UpdateShape();
}

public class Point
{
  public float x;
  public float y;
  public boolean occupied;
  
  public Point(float xi, float yi)
  {
    x = xi;
    y = yi;
  }
}

public class lDot
{
  public float posX = random(width);
  public float posY = random(height);
  
  public ArrayList<sDot> children;
  
  public Point[] trail;
  
  float weightX = random(-2, 1);
  float weightY = random(-2, 1);
  
  public int trailNo;
  
  boolean f20;
  int trailDummy = 0;
  
  void init()
  {
    children = new ArrayList<sDot>();
    
    trail = new Point[20];
    
    trailNo = 0;
  }
  
  public void AddSDot()
  {
    sDot newDot = new sDot();
    
    newDot.posX = random(posX - (width / 4), posX + (width / 4));
    newDot.posY = random(posY - (height / 4), posY + (height / 4));
    
    newDot.parent = this;
    
    children.add(newDot);
  }
  
  void UpdateShape()
  {
    UpdateTrail();
    
    float targetX = (random(posX - 50, posX + 50) + (weightX * (5000 * amp.analyze())));
    float xM = targetX - posX;
    posX += xM * 0.05;
    
    float targetY = (random(posY - 50, posY + 50) + (weightY * (5000 * amp.analyze())));
    float yM = targetY - posY;
    posY += yM * 0.05;
  
    if (posX > width)
    {
      posX = width;
      weightX = random(-2, 1);
    }
    if (posX < 0)
    {
      posX = 0;
      weightX = random(-2, 1);
    }
    if (posY > height)
    {
      posY = height;
      weightY = random(-2, 1);
    }
    if (posY < 0)
    {
      posY = 0;
      weightY = random(-2, 1);
    }
    
    ellipse(posX, posY, 50, 50);
    
    for (sDot dot : children)
    {
      dot.UpdateShape();
    }
  }
  
  void UpdateTrail()
  {
    if (!f20)
    {
      if (frameCount >= 20)
      {
        f20 = true;
      }
      else
      {        
        trail[frameCount - 1] = new Point(posX, posY);
        
        trailNo++;
      }
    }
    else
    {
      trailDummy++;
      if (trailNo == 20)
      {
        for (int i = 0; i < 20; i++)
        {
          if (i > 0)
            trail[i - 1] = trail[i];
        }
        
        trailNo = 0;
      }
      
      if (trailDummy % 20 == 0)
      {
        trail[trailNo] = new Point(posX, posY);
      
        trailNo++;
      }
    }
  }
}

public class sDot
{
  public float posX;
  public float posY;
  
  public lDot parent;
  
  void UpdateShape()
  {
    int potato = 0;
    for (Point p : parent.trail)
    {
      if (p != null)
      {
        //println(p.x, p.y);
        potato++;
      }
    }
    
    int rand = round(random(potato - 1));
    //println(rand);
    
    float targetX = parent.trail[rand].x;
    float xM = targetX - posX;
    posX += xM * 0.05;
    
    float targetY = parent.trail[rand].y;
    float yM = targetY - posY;
    posY += yM * 0.05;
    
    ellipse(posX, posY, 20, 20);
  }
}