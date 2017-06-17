package com.github.jakz.fsb.gfx;

import java.util.HashMap;
import java.util.Map;

public class PainterMap<T>
{
  private final Map<Class<? extends T>, Painter<? extends T>> painters;
  
  public PainterMap()
  {
    painters = new HashMap<>();
  }
  
  public void registerType(Class<? extends T> type, Painter<? extends T> drawer)
  {
    painters.put(type, drawer);
  }
  
  public Painter<T> find(T o)
  {
    Painter<? extends T> painter = painters.get(o.getClass());
    return painter != null ? (Painter<T>)painter : null;
  }
}
