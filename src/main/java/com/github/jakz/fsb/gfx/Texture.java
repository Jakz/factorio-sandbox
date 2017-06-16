package com.github.jakz.fsb.gfx;

import processing.core.PImage;

public class Texture
{
  public final Enum<?> key;
  private final String path;
  public final PImage image;
  
  Texture(Enum<?> key, String path, PImage image)
  {
    this.key = key;
    this.path = path;
    this.image = image;
  }
}