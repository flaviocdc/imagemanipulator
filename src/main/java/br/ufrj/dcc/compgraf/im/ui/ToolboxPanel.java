package br.ufrj.dcc.compgraf.im.ui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import br.ufrj.dcc.compgraf.im.ui.actions.OpenResizeDialogActionListener;

public class ToolboxPanel extends JPanel
{

  public ToolboxPanel()
  {
    super();
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    setSize(20, 550);
    
    JButton resizeButton = new JButton("Resize");
    resizeButton.addActionListener(new OpenResizeDialogActionListener());
    JButton cropButton = new JButton("Crop");
    JButton greyScale = new JButton("Greyscale");
    JButton flipButton = new JButton("Flip");
    JButton rotateButton = new JButton("Rotate");
    
    add(resizeButton);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(cropButton);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(greyScale);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(flipButton);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(rotateButton);
  }
  
}
