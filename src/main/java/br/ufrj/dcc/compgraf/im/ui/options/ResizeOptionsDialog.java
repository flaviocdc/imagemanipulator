package br.ufrj.dcc.compgraf.im.ui.options;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufrj.dcc.compgraf.im.resize.NearestNeighborResize;
import br.ufrj.dcc.compgraf.im.resize.KeepAspectRatioResize.KeepAspectRatioType;
import br.ufrj.dcc.compgraf.im.ui.SwingUtils;
import br.ufrj.dcc.compgraf.im.ui.UIContext;

public class ResizeOptionsDialog extends JDialog
{

  private JTextField widthField = new JTextField(6);
  private JTextField heightField = new JTextField(6);
  
  public ResizeOptionsDialog()
  {
    super(UIContext.instance().getMainWindow(), "Resize parameters", true);
    
    initLayout();
    
    setSize(200, 150);
    
    SwingUtils.addEscapeListener(this);
  }

  private void initLayout()
  {
    JPanel container = new JPanel();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    
    add(container);
    
    JPanel inputContainer = new JPanel(new GridLayout(2, 2, 10, 10));
    inputContainer.add(new JLabel("Width:"));
    inputContainer.add(widthField);
    inputContainer.add(new JLabel("Height:  "));
    inputContainer.add(heightField);
    
    container.add(inputContainer);
    
    JButton resizeButton = new JButton("Resize");
    resizeButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        int width = Integer.parseInt(widthField.getText());
        int height = Integer.parseInt(heightField.getText());
        
        BufferedImage newImg = new NearestNeighborResize().resize(KeepAspectRatioType.VERTICAL, UIContext.instance().getCurrentImage(), width, height);
        
        UIContext.instance().changeCurrentImage(newImg);

        setVisible(false);
      }
    });
    
    container.add(resizeButton);
  }
  
}
