package com.github.jakz.fsb.gfx;

import com.github.jakz.fsb.App;
import com.github.jakz.fsb.entity.Belt;
import com.pixbits.lib.lang.Point;

import processing.core.PImage;

public class BeltDrawer implements Drawer<Belt>
{
  enum TextureID
  {
    NORMAL_BELT("transport-belt/transport-belt.png", 16, 1.875f),
    FAST_BELT("fast-transport-belt/fast-transport-belt.png", 32, 3.75f),
    EXPRESS_BELT("express-transport-belt/express-transport-belt.png", 32, 5.625f)
    
    ;

    private TextureID(String path, int ticks, float speed)
    {
      this.path = path;
      this.texture = null;
      this.ticks = ticks;
      this.speed = speed;
    }
    
    
    private Texture texture;
    public final int ticks;
    public final float speed;
    public final String path;
    
    public Texture get()
    {
      if (texture != null)
        return texture;
      else
      {
        this.texture = App.cache().load(App.factorioPath + path, this);
        return this.texture;
      }
    }
  };
  
  private static TextureID[] textures = new TextureID[] {
      TextureID.NORMAL_BELT,
      TextureID.FAST_BELT,
      TextureID.EXPRESS_BELT
  };
  
  private final GfxEnvironment env;
  
  public BeltDrawer(GfxEnvironment env)
  {
    this.env = env;
  }

  @Override public void draw(Belt entity, Point position)
  {
    TextureID textureID = textures[entity.type().ordinal()];
    Texture texture = textureID.get();
    
    float period = 1.0f / textureID.speed;
    float percent = (env.seconds() % period) / period;
    
    //System.out.printf("period: %2.2f, seconds: %2.2f, percent: %2.2f\n", period, env.seconds(), percent);
    
    env.drawImage(texture, 40*(int)(percent*(textureID.ticks-1)), 0, 40, 40, (int)position.x, (int)position.y);
    
  }

}
