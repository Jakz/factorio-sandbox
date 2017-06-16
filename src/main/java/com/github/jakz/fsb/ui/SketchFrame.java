package com.github.jakz.fsb.ui;

import java.awt.BorderLayout;

import javax.swing.*;

public class SketchFrame extends JFrame
{
  public final static long serialVersionUID = 1L;
  
  private final Sketch sketch;

  public SketchFrame(Sketch sketch)
  {
    super("Factorio Sandbox v0.1");

    this.sketch = sketch;
    
    setLayout(new BorderLayout());
    add(sketch, BorderLayout.CENTER);

    //JPanel test = new JPanel();
    //test.setPreferredSize(new Dimension(380,1024));

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pack();
  }
}
