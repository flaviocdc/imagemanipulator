package br.ufrj.dcc.compgraf.im.ui;

public class UIContext
{
  private static UIContext instance;

  private UIContext() {}
  
  public static UIContext instance()
  {
    if (instance == null) 
    {
      instance = new UIContext();
    }
    
    return instance;
  }
  
}
