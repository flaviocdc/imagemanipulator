package br.ufrj.dcc.compgraf.im.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import br.ufrj.dcc.compgraf.im.ui.UIContext;
import br.ufrj.dcc.compgraf.im.ui.file.FileChooser;

public class SaveFileActionListener implements ActionListener
{

  private static Logger log = Logger.getLogger(SaveFileActionListener.class);
  
  @Override
  public void actionPerformed(ActionEvent event)
  {
    File destinationFile = FileChooser.save();
    
    try
    {
      ImageIO.write(UIContext.instance().getCurrentImage(), "jpeg", destinationFile);
    }
    catch (IOException e)
    {
      log.error(e, e);
    }
  }

}
