package br.ufrj.dcc.compgraf.im.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.log4j.Logger;

import br.ufrj.dcc.compgraf.im.ImageLoader;
import br.ufrj.dcc.compgraf.im.ui.UIContext;

public class OpenFileActionListener implements ActionListener
{

  private static Logger log = Logger.getLogger(OpenFileActionListener.class);

  @Override
  public void actionPerformed(ActionEvent event)
  {
    try
    {
      final BufferedImage image = ImageLoader.loadImage();

      if (image == null)
      {
        log.debug("No image was selected, stopping...");
        return;
      }
      
      log.debug(image);
      
      UIContext.instance().changeCurrentImage(image);
    }
    catch (IOException e)
    {
      log.error(e, e);
    }
  }

}
