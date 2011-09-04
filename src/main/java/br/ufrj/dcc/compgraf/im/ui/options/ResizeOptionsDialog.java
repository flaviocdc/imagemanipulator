package br.ufrj.dcc.compgraf.im.ui.options;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import br.ufrj.dcc.compgraf.im.resize.KeepAspectRatioResize.KeepAspectRatioType;
import br.ufrj.dcc.compgraf.im.resize.NearestNeighborResize;
import br.ufrj.dcc.compgraf.im.ui.SwingUtils;
import br.ufrj.dcc.compgraf.im.ui.UIContext;
import br.ufrj.dcc.compgraf.im.ui.swing.ext.SpringUtilities;

public class ResizeOptionsDialog extends JDialog
{

  private boolean isPercentageResize = false;
  
  private JTextField widthField = new JTextField(6);
  private JTextField heightField = new JTextField(6);
  private JTextField percentField = new JTextField(6);
  private JRadioButton pixelRadio = new JRadioButton("Pixels");
  private JRadioButton percentRadio = new JRadioButton("Percentage");
  private JButton resizeButton = new JButton("Resize");
  
  private JComboBox keepAspectCombo = new JComboBox();

  private JPanel pixelInputContainer = new JPanel(new SpringLayout());
  private JPanel percentInputContainer = new JPanel(new SpringLayout());
  
  private KeepAspectRatioType keepAspectRatioType = KeepAspectRatioType.DONT_KEEP;
  
  public ResizeOptionsDialog()
  {
    super(UIContext.instance().getMainWindow(), "Resize parameters", true);
    
    initLayout();
    
    setSize(240, 240);
    
    SwingUtils.configureDialog(this);
  }

  private void initLayout()
  {
    JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    container.setOpaque(true);
    setContentPane(container);
    
    JPanel radioPanel = new JPanel(new SpringLayout());
    
    radioPanel.add(pixelRadio);
    radioPanel.add(percentRadio);
    
    SpringUtilities.makeCompactGrid(radioPanel, 1, 2, 6, 6, 6, 6);
    
    pixelInputContainer.add(new JLabel("Width:"));
    pixelInputContainer.add(widthField);
    pixelInputContainer.add(new JLabel("Height:"));
    pixelInputContainer.add(heightField);
    pixelInputContainer.add(new JLabel("Keep aspect ratio:"));
    pixelInputContainer.add(keepAspectCombo);
    
    SpringUtilities.makeCompactGrid(pixelInputContainer, 3, 2, 6, 6, 6, 6);
    
    percentInputContainer.add(new JLabel("Percent:"));
    percentInputContainer.add(percentField);
    
    SpringUtilities.makeCompactGrid(percentInputContainer, 1, 2, 6, 6, 6, 6);
    
    add(radioPanel);
    add(pixelInputContainer);
    add(percentInputContainer);
    add(resizeButton);
    
    percentInputContainer.setVisible(false);
    
    initButtons();
    initKeepAspectCombo();
  }
  
  private void initKeepAspectCombo()
  {
    for (KeepAspectRatioType type : KeepAspectRatioType.values())
    {
      keepAspectCombo.addItem(type.descriptiveName());
    }
    
    keepAspectCombo.setSelectedIndex(2);
    
    keepAspectCombo.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        JComboBox cb = (JComboBox)e.getSource();
        int i = cb.getSelectedIndex();
        
        keepAspectRatioType = KeepAspectRatioType.values()[i];
        
        switch (keepAspectRatioType) {
          case HORIZONTAL:
          {
            heightField.setEnabled(false);
            widthField.setEnabled(true);
            break;
          }
          case VERTICAL:
          {
            heightField.setEnabled(true);
            widthField.setEnabled(false);
            break;
          }
          case DONT_KEEP:
          {
            heightField.setEnabled(true);
            widthField.setEnabled(true);
            break;
          }
          default:
            throw new IllegalArgumentException();
        }
      }
    });
  }

  private void initButtons() 
  {
    pixelRadio.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        isPercentageResize = false;
        resizeButton.setEnabled(true);
        percentInputContainer.setVisible(false);
        pixelInputContainer.setVisible(true);
      }
    });
    
    pixelRadio.setSelected(true);
    
    percentRadio.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        isPercentageResize = true;
        resizeButton.setEnabled(true);
        percentInputContainer.setVisible(true);
        pixelInputContainer.setVisible(false);
      }
    });
    
    ButtonGroup group = new ButtonGroup();
    group.add(pixelRadio);
    group.add(percentRadio);
    
    resizeButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        int width, height;
        BufferedImage img = UIContext.instance().getCurrentImage();
        
        if (isPercentageResize)
        {
          double percent = Double.parseDouble(percentField.getText()) / 100;
          
          width = (int) (img.getWidth() * percent);
          height = (int) (img.getHeight() * percent);
          
          keepAspectRatioType = KeepAspectRatioType.DONT_KEEP;
        }
        else
        {
          width = Integer.parseInt(widthField.getText());
          height = Integer.parseInt(heightField.getText());
        }
        
        BufferedImage newImg = new NearestNeighborResize().resize(keepAspectRatioType, UIContext.instance().getCurrentImage(), width, height);
        
        UIContext.instance().changeCurrentImage(newImg);

        dispose();
      }
    });
  }
  
}
