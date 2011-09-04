package br.ufrj.dcc.compgraf.im.ui.file;

import java.io.File;

import javax.swing.JFileChooser;

import br.ufrj.dcc.compgraf.im.ui.UIContext;

public class FileChooser
{
  private static JFileChooser fc = new JFileChooser();

  public static File open(String startDir)
  {
    fc.setCurrentDirectory(new File(startDir));
    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fc.addChoosableFileFilter(new ImageFilter());

    int retVal = fc.showOpenDialog(UIContext.instance().getMainWindow());

    if (retVal == JFileChooser.APPROVE_OPTION)
    {
      return fc.getSelectedFile();
    }
    else
    {
      return null;
    }
  }
  
  public static File save()
  {
    int retVal = fc.showSaveDialog(UIContext.instance().getMainWindow());
    if (retVal == JFileChooser.APPROVE_OPTION)
    {
      return fc.getSelectedFile();
    }
    else
    {
      return null;
    }
    
  }

}