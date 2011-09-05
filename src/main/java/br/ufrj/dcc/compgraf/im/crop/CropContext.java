package br.ufrj.dcc.compgraf.im.crop;

import java.awt.Point;

public class CropContext
{
  private static CropContext instance;
  
  private boolean cropRunning = false;
  
  private Point clickedPixel;
  private Point currentPixel;
  
  private CropContext() { }
  
  public static CropContext instance() {
    if (instance == null)
      instance = new CropContext();
    
    return instance;
  }

  public Point getClickedPixel()
  {
    return clickedPixel;
  }

  protected void setClickedPixel(Point clickedPixel)
  {
    this.clickedPixel = clickedPixel;
  }

  public Point getCurrentPixel()
  {
    return currentPixel;
  }

  protected void setCurrentPixel(Point currentPixel)
  {
    this.currentPixel = currentPixel;
  }

  public boolean isCropRunning()
  {
    return cropRunning;
  }

  public void setCropRunning(boolean cropRunning)
  {
    this.cropRunning = cropRunning;
  }
}  