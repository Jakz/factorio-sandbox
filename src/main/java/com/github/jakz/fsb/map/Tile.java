package com.github.jakz.fsb.map;

import com.github.jakz.fsb.entity.Entity;

public class Tile
{
  private final Chunk chunk;
  private final int x, y;
  private Entity entity;
  
  public Tile(Chunk chunk, int x, int y)
  {
    this.chunk = chunk;
    this.x = x;
    this.y = y;
    this.entity = null;
  }
  
  public Entity entity() { return entity; }
  public void entity(Entity entity) { this.entity = entity; }
}
