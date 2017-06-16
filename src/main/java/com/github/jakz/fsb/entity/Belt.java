package com.github.jakz.fsb.entity;

public class Belt
{
  private BeltType type;
  private Dir dirFrom;
  private Dir dirTo;
  
  public BeltType type() { return type; }
  public void type(BeltType type) { this.type = type; } 
  
  public Dir from() { return dirFrom; }
  public Dir to() { return dirTo; }
  
}
