package com.github.jakz.fsb.ui;

import java.util.*;

import javax.swing.event.*;

import com.github.jakz.fsb.App;
import com.github.jakz.fsb.entity.Belt;
import com.github.jakz.fsb.entity.BeltType;
import com.github.jakz.fsb.gfx.BeltDrawer;
import com.github.jakz.fsb.gfx.GfxEnvironment;
import com.github.jakz.fsb.gfx.Texture;
import com.github.jakz.fsb.gfx.TextureCache;
import com.pixbits.lib.lang.Point;
import com.pixbits.lib.lang.Rect;

import java.awt.event.*;

import processing.core.*;

import java.awt.Color;
import java.awt.Rectangle;


public class Sketch extends PApplet implements ChangeListener, MouseListener, MouseWheelListener, GfxEnvironment
{
  private PImage font;
  
  
  public final static long serialVersionUID = 1L;

  public PFont font1 = createFont("Helvetica", 20, true);
  
  long ticks = 0;
  long elapsed;
  
  BeltDrawer drawer = new BeltDrawer(this);
  
  public void setup()
  {
    //hint(DISABLE_OPENGL_2X_SMOOTH);
    
    font = this.loadImage(getClass().getResource("/com/github/jakz/fsb/gfx/font.png").getPath());
    
    size(800,600, PApplet.P2D);
    frameRate(60.0f);
    
    //textFont(font1);
    //textSize(20);

  }

  public void rect(int[] coords)
  {
    this.rect(coords[0], coords[1], coords[2], coords[3]);
  }
  
  public void rect(Rect rect)
  {
    this.rect(rect.x, rect.y, rect.w, rect.h);
  }

  public void draw()
  {
    long current = System.nanoTime();
    float fps = 1000.0f / (current - elapsed);
    elapsed = current;

    
    background(170);
    
    Belt belt1 = new Belt();
    belt1.type(BeltType.NORMAL);
    
    Belt belt2 = new Belt();
    belt2.type(BeltType.FAST);
    
    for (int i = 0; i < 5; ++i)
    {
      //drawer.draw(belt2, new Point(32*i,0));
      //drawer.draw(belt2, new Point(32*i,36));

    }
    
    fill(Color.BLACK);
    drawText(String.format("TICKS %d : TIME %2.2f : FPS %2.2f", ticks, seconds(), this.frameRate), 20, height - 30);
    
    ++ticks;
  }

  public void drawText(String text, int x, int y)
  {
    final int W = 5;
    final int H = 8;
    final int HS = 1;
    final int VS = 1;
    
    final int PS = 1;
    
    final int length = text.length();
    for (int i = 0; i < length; ++i)
    {
      char c = text.charAt(i);
      int index = c - ' ';
      int row = index / 32;
      int col = index % 32;
      
      this.blend(font, col*(W+HS), (row+1)*(H+VS), W, H, x, y, W, H, PApplet.BLEND);
      x += W + PS;
    }
  }

  public void keyPressed()
  {

  }

  public void mouseReleased()
  {

  }

  public void mousePressed()
  {
    redraw();
  }

  public void mouseMoved()
  {
  }
  
  @Override public void mouseWheelMoved(MouseWheelEvent e)
  {
    
  }

  public void mouseDragged()
  {

  }

  public void stateChanged(ChangeEvent e)
  {

  }


  public void fill(java.awt.Color c)
  {
    fill(c.getRed(), c.getGreen(), c.getBlue());
  }

  public void stroke(java.awt.Color c)
  {
    stroke(c.getRed(), c.getGreen(), c.getBlue());
  }

  public PImage process(PImage input)
  {
    int w = input.width*2;
    int h = input.height*2;
    int f = 2;

    PImage newImg = createImage(w, h, PConstants.ARGB);

    input.loadPixels();
    newImg.loadPixels();
    int[] oldPixels = input.pixels;
    int[] newPixels = newImg.pixels;

    for (int i = 0; i < input.height; ++i)
    {
      for (int j = 0; j < input.width; ++j)
      {
        int color = oldPixels[j+(i*input.width)];

        for (int y = 0; y < f; ++y)
          for (int x = 0; x < f; ++x)
            newPixels[(j*f)+x+((i*f+y)*w)] = color;
      }
    }

    newImg.updatePixels();

    return newImg;
  }

  @Override
  public void drawImage(Texture texture, int x, int y, int w, int h, int dx, int dy)
  {
    this.blend(texture.image, x, y, w, h, dx, dy, w, h, PApplet.BLEND);
  }
  
  @Override public long ticks() { return ticks; }
  @Override public float seconds() { return ticks / 60.0f; }
}