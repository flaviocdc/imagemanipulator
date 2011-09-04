package br.ufrj.dcc.compgraf.im.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import br.ufrj.dcc.compgraf.im.ui.options.GreyScaleOptionsDialog;
import br.ufrj.dcc.compgraf.im.ui.options.ResizeOptionsDialog;

public class ToolboxPanel extends JPanel
{

  public ToolboxPanel()
  {
    super();
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    setSize(20, 550);
    
    JButton resizeButton = new JButton("Resize");
    resizeButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        new ResizeOptionsDialog().setVisible(true);
      }
    });
    
    JButton cropButton = new JButton("Crop");
    JButton greyScaleButton = new JButton("Greyscale");
    greyScaleButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        new GreyScaleOptionsDialog().setVisible(true);
      }
    });
    
    JButton flipButton = new JButton("Flip");
    JButton rotateButton = new JButton("Rotate");
    
    add(resizeButton);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(cropButton);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(greyScaleButton);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(flipButton);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(rotateButton);
  }
  
}
