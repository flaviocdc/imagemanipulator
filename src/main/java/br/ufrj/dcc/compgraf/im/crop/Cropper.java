package br.ufrj.dcc.compgraf.im.crop;

import java.awt.image.BufferedImage;

import org.apache.log4j.Logger;

public class Cropper {

  private static Logger log = Logger.getLogger(Cropper.class);
  
  private BufferedImage originalImage;
  
  public Cropper(BufferedImage originalImage)
  {
    this.originalImage = originalImage;
  }
  
  public BufferedImage crop(int startx, int starty, int endx, int endy)
  {
    int newWidth = Math.abs(endx - startx);
    int newHeight = Math.abs(endy - starty);
    
    BufferedImage img = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
    
    for (int x = startx, newx = 0; x < endx; x++, newx++)
    {
      for (int y = starty, newy = 0; y < endy; y++, newy++)
      {
        log.debug("Original: " + x + "x" + y + " - Novo: " + newx + "x" + newy);
        img.setRGB(newx, newy, originalImage.getRGB(x, y));
      }
    }
    
    return img;
  }
  
}