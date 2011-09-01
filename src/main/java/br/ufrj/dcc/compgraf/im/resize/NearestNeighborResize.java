package br.ufrj.dcc.compgraf.im.resize;

import java.awt.image.BufferedImage;

public class NearestNeighborResize extends KeepAspectRatioResize {

  public BufferedImage resize(KeepAspectRatioType type, BufferedImage originalImage, int newX, int newY) {
    int originalX = originalImage.getWidth();
    int originalY = originalImage.getHeight();

    ImageSize size = calculateImageSize(type, originalX, originalY, newX, newY);
    newX = size.getWidth();
    newY = size.getHeight();

    BufferedImage img = new BufferedImage(newX, newY, BufferedImage.TYPE_INT_RGB);
    
    double xRatio = originalX / (double) newX;
    double yRatio = originalY / (double) newY;
    
    for (int x = 0; x < newX; x++)
    {
      for (int y = 0; y < newY; y++)
      {
        double px = Math.floor(x * xRatio);
        double py = Math.floor(y * yRatio);
        
        img.setRGB(x, y, originalImage.getRGB((int) px, (int) py));
      }
    }
    
    return img;
  }

}