package com.github.jakz.fsb.gfx;

public interface GfxEnvironment
{
  void drawImage(Texture texture, int x, int y, int w, int h, int dx, int dy);
  void drawImage(Texture texture, int x, int y, int w, int h, int dx, int dy, int angle);
  
  long ticks();
  float seconds();
}
