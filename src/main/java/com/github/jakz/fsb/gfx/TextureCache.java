package com.github.jakz.fsb.gfx;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.github.jakz.fsb.App;
import com.pixbits.lib.exceptions.FileNotFoundException;

import processing.core.PImage;

public class TextureCache
{
  private Map<Enum<?>, Texture> textures;
  private Function<String, PImage> loader;
  
  public TextureCache(Function<String, PImage> loader)
  {
    textures = new HashMap<>();
    this.loader = loader;
  }
  
  public Texture load(String path, Enum<?> key)
  {
    PImage image = loader.apply(path);
    
    if (image != null)
    {
      Texture texture = new Texture(key, path, image);
      textures.put(key, texture);
      return texture;
    }
    else
      throw new FileNotFoundException(Paths.get(path), "Texture not found");
  }
  
  public PImage get(Enum<?> key)
  {
    Texture t = textures.get(key);
    return t != null ? t.image : null; 
  }
}
