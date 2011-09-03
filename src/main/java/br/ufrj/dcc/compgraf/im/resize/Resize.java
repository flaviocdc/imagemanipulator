package br.ufrj.dcc.compgraf.im.resize;

import java.awt.image.BufferedImage;

import br.ufrj.dcc.compgraf.im.resize.KeepAspectRatioResize.KeepAspectRatioType;

public interface Resize
{

  public BufferedImage resize(KeepAspectRatioType type, BufferedImage originalImage, int newX, int newY);

}