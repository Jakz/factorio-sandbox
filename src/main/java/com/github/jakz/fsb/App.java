package com.github.jakz.fsb;

import com.github.jakz.fsb.gfx.TextureCache;
import com.github.jakz.fsb.ui.Sketch;
import com.github.jakz.fsb.ui.SketchFrame;

public class App 
{
  private static Sketch sketch;  
  private static SketchFrame sketchFrame;
  
  private static TextureCache cache;
  
  public static String factorioPath = 
      "/Volumes/OSX Data/Games/Steam/SteamApps/common/Factorio/factorio.app/Contents" +
      "/data/base/graphics/entity/";
  
  
  public static void main( String[] args )
  {
    cache = new TextureCache(s -> sketch.loadImage(s));

    sketch = new Sketch();
    sketch.init();
    sketchFrame = new SketchFrame(sketch);
    sketchFrame.setVisible(true);
    sketchFrame.setLocationRelativeTo(null);    
  }
  
  public static Sketch sketch() { return sketch; }
  public static TextureCache cache() { return cache; }
}
