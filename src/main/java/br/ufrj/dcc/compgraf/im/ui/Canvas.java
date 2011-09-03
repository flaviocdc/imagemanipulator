package br.ufrj.dcc.compgraf.im.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Canvas extends JPanel
{

  public Canvas()
  {
    super();
    
    setSize(500, 500);
  }
  
  @Override
  public void paint(Graphics g)
  {
    System.out.println("Teste");
    
    Graphics2D g2d = (Graphics2D) g;
    
    g2d.setColor(Color.WHITE);
    g2d.drawRect(0, 0, getWidth(), getHeight());
    g2d.fillRect(0, 0, getWidth(), getHeight());
  }
  
}