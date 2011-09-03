package br.ufrj.dcc.compgraf.im;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ufrj.dcc.compgraf.im.ui.FileChooser;

public class ImageLoader
{

  public static BufferedImage loadImage() throws IOException
  {
    File selectedFile = FileChooser.chooseFile(".");

    return selectedFile == null ? null : ImageIO.read(selectedFile);
  }

}