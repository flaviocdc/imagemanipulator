package br.ufrj.dcc.compgraf.im.ui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolboxPanel extends JPanel
{

  public ToolboxPanel()
  {
    super();
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    setSize(20, 550);
    
    add(new JButton("Resize"));
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(new JButton("Crop"));
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(new JButton("Greyscale"));
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(new JButton("Flip"));
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(new JButton("Rotate"));
  }
  
}
