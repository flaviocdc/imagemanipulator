package br.ufrj.dcc.compgraf.im;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import br.ufrj.dcc.compgraf.im.crop.Cropper;
import br.ufrj.dcc.compgraf.im.resize.NearestNeighborResize;
import br.ufrj.dcc.compgraf.im.resize.KeepAspectRatioResize.KeepAspectRatioType;

public class App {
  private static Logger log = Logger.getLogger(App.class);

  public static void main(String[] args)
  {
    try {
      BufferedImage image = ImageLoader.loadImage();
      
      if (image == null)
      {
        log.debug("No image was selected, stopping...");
        return;
      }
      
      BufferedImage newImage = new Cropper(image).crop(20, 0, 100, 80);
      ImageIO.write(newImage, "jpeg", new File("crop.jpg"));
      
      newImage = new NearestNeighborResize().resize(KeepAspectRatioType.NONE,image, 200, 200);
      ImageIO.write(newImage, "jpeg", new File("resize_enlarge.jpg"));
      
      newImage = new NearestNeighborResize().resize(KeepAspectRatioType.NONE, image, 50, 50);
      ImageIO.write(newImage, "jpeg", new File("resize_reduce.jpg"));
      
      newImage = new NearestNeighborResize().resize(KeepAspectRatioType.VERTICAL, image, 250, 200);
      ImageIO.write(newImage, "jpeg", new File("resize_reduce_keep_arv.jpg"));
      
      newImage = new NearestNeighborResize().resize(KeepAspectRatioType.HORIZONTAL, image, 250, 200);
      ImageIO.write(newImage, "jpeg", new File("resize_reduce_keep_arh.jpg"));
    } catch (IOException e) {
      log.error(e, e);
    }
  }
}