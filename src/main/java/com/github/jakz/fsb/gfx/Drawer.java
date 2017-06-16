package com.github.jakz.fsb.gfx;

import com.pixbits.lib.lang.Point;

public interface Drawer<T>
{
  void draw(T entity, Point position);
}
