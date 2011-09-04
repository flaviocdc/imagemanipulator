package br.ufrj.dcc.compgraf.im.ui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import br.ufrj.dcc.compgraf.im.ui.swing.ext.ScrollablePicture;

public class UIContext
{
  private static UIContext instance;

  private BufferedImage currentImage;
  private JScrollPane imageScrollPane;
  private MainWindow mainWindow;
  
  private UIContext() {}
  
  public static UIContext instance()
  {
    if (instance == null) 
    {
      instance = new UIContext();
    }
    
    return instance;
  }
  
  public BufferedImage getCurrentImage()
  {
    return currentImage;
  }

  public void setImageScrollPane(JScrollPane imageScrollPane)
  {
    this.imageScrollPane = imageScrollPane;
  }
  
  public void changeCurrentImage(BufferedImage image)
  {
    currentImage = image;
    
    ImageIcon icon = new ImageIcon(image);
    ScrollablePicture scrlImg = new ScrollablePicture(icon);
    
    imageScrollPane.setViewportView(scrlImg);
  }

  public MainWindow getMainWindow()
  {
    return mainWindow;
  }

  public void setMainWindow(MainWindow mainWindow)
  {
    this.mainWindow = mainWindow;
  }
}