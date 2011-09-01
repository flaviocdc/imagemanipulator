package br.ufrj.dcc.compgraf.im.resize;

import java.awt.image.BufferedImage;

public interface Resize {

  public BufferedImage resize(BufferedImage originalImage, int newX, int newY);
  
}
