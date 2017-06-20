package com.github.jakz.fsb.entity;

public enum BeltFacing
{
  NORTH(Dir.SOUTH, Dir.NORTH),
  EAST(Dir.WEST, Dir.EAST),
  SOUTH(Dir.NORTH, Dir.SOUTH),
  WEST(Dir.EAST, Dir.WEST),
  
  ;
  
  public final Dir from;
  public final Dir to;
  
  private BeltFacing(Dir from, Dir to)
  {
    this.from = from;
    this.to = to;
  }
}
