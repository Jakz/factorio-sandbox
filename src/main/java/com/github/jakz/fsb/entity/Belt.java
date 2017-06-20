package com.github.jakz.fsb.entity;

public class Belt extends Entity
{
  private BeltType type;
  private BeltFacing facing;
  
  public Belt(BeltType type, BeltFacing facing)
  {
    this.type = type;
    this.facing = facing;
  }
  
  public BeltType type() { return type; }
  public void type(BeltType type) { this.type = type; } 
  
  public BeltFacing facing() { return facing; }
}
