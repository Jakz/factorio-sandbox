package com.github.jakz.fsb.map;

public class Chunk 
{
  public final int SIZE = 32;
  
  private Tile[][] tiles;
  
  public Chunk()
  {
    
  }
  
  public void allocate()
  {
    tiles = new Tile[SIZE][SIZE];
    
    for (int x = 0; x < SIZE; ++x)
      for (int y = 0; y < SIZE; ++y)
        tiles[x][y] = new Tile(this, x, y);
  }
  
  public Tile tile(int x, int y)
  {
    return tiles == null ? null : tiles[x][y];
  }
}
