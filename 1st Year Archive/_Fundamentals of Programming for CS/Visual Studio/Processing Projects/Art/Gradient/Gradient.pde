void setup()
{
  
}

void draw()
{
  // Iterate through all of the existent dots.
  for (Dot d : dots)
  {
    // For each one, call its respective update function.
    d.Update();
  }
  
  
}