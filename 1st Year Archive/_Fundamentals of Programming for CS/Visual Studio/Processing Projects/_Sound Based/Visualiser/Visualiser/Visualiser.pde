import processing.sound.*;

FFT fft;
SoundFile audio;
int bands = 256;
float[] spectrum = new float[bands];
float[] bars = new float[bands];
float scale;

void setup()
{
  fullScreen();
  
  fill(255, 255, 0);
  
  frameRate(60);
  
  fft = new FFT(this, bands);
  audio = new SoundFile(this, "Rare.mp3");
  
  audio.play();
  //audio.pan(90);
  
  fft.input(audio);
  
  scale = width / bands;
}

void draw()
{
  background(0);
  fft.analyze(spectrum);
  
  for (int i = 0; i < bars.length; i ++)
  {
    float prevBar = bars[i];
    bars[i] = lerp(prevBar, (spectrum[i]*height), 0.1);
    ResizeAdjacentBars(i);
  }
  
  for (int i = 0; i < bars.length; i++)
  {
   rect(i * scale, height - bars[i], scale, bars[i]); 
  }
}

void ResizeAdjacentBars(int i)
{
  float resize = bars[i] * 0.05f;

  if (i != 0)
  {
      bars[i - 1] += resize;
  }
  if (i != bars.length - 1)
  {
      bars[i + 1] += resize;
  }
}