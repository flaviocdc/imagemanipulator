package br.ufrj.dcc.compgraf.im;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import br.ufrj.dcc.compgraf.im.crop.Cropper;
import br.ufrj.dcc.compgraf.im.ui.FileChooser;

public class App {
  private static Logger log = Logger.getLogger(App.class);

  public static void main(String[] args)
  {
    File selectedFile = FileChooser.chooseFile("/export/home/andromeda/flavio/Desktop/SIGA/");
    
    try {
      BufferedImage image = ImageIO.read(selectedFile);
      BufferedImage newImage = new Cropper(image).crop(20, 0, 100, 80);
      
      ImageIO.write(newImage, "jpeg", new File("dest1.jpg"));
    } catch (IOException e) {
      log.error(e, e);
    }
  }
}