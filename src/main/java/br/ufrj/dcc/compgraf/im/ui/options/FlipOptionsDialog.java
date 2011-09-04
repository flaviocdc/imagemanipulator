package br.ufrj.dcc.compgraf.im.ui.options;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufrj.dcc.compgraf.im.transform.Flip;
import br.ufrj.dcc.compgraf.im.transform.Flip.FlipOrientation;
import br.ufrj.dcc.compgraf.im.ui.SwingUtils;
import br.ufrj.dcc.compgraf.im.ui.UIContext;

public class FlipOptionsDialog extends JDialog
{

  public FlipOptionsDialog()
  {
    super(UIContext.instance().getMainWindow(), "Choose the flipping method", true);
    
    setSize(240, 120);
    
    SwingUtils.configureDialog(this);
    
    initLayout();
  }

  private void initLayout()
  {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    panel.setOpaque(true);
    setContentPane(panel);
    
    final JComboBox methodCombo = new JComboBox();
    for (FlipOrientation orientation : FlipOrientation.values())
    {
      methodCombo.addItem(orientation);
    }
    
    JButton applyButton = new JButton("Apply");
    applyButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        int selected = methodCombo.getSelectedIndex();
        FlipOrientation orientation = FlipOrientation.values()[selected];
        
        BufferedImage newImg = new Flip().flip(UIContext.instance().getCurrentImage(), orientation);
        UIContext.instance().changeCurrentImage(newImg);
        
        dispose();
      }
    });
    
    add(new JLabel("Orientation:"));
    add(methodCombo);
    add(applyButton);
  }
  
}
