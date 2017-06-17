package com.github.jakz.fsb.gfx;

import com.pixbits.lib.lang.Point;

public interface Painter<T>
{
  void draw(T entity, int x, int y);
}
