package br.ufrj.dcc.compgraf.im.resize;

public abstract class KeepAspectRatioResize implements Resize
{

  public enum KeepAspectRatioType
  {
    HORIZONTAL, VERTICAL, NONE
  }

  public ImageSize calculateImageSize(KeepAspectRatioType type, int originalX, int originalY, int newX, int newY)
  {
    if (type == KeepAspectRatioType.NONE)
    {
      return new ImageSize(newX, newY);
    }
    else
    {
      if (type == KeepAspectRatioType.HORIZONTAL)
      {
        double resizeRatio = originalX / (double) newX;
        newY = (int) (originalY / resizeRatio);
      }
      else if (type == KeepAspectRatioType.VERTICAL)
      {
        double resizeRatio = originalY / (double) newY;
        newX = (int) (originalX / resizeRatio);
      }

      return new ImageSize(newX, newY);
    }
  }
}
