package br.ufrj.dcc.compgraf.im.ui.file;

import java.io.File;

public class FileUtils
{

  public static String extractExtension(File f)
  {
    if (f.getAbsolutePath().lastIndexOf('.') == -1)
      return null;
  
    return f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf('.') + 1);
  }

}
