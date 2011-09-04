package br.ufrj.dcc.compgraf.im.resize;

public abstract class KeepAspectRatioResize implements Resize
{

  public enum KeepAspectRatioType
  {
    HORIZONTAL("Horizontally"),
    VERTICAL("Vertically"),
    DONT_KEEP("No");
    
    private final String name;
    
    private KeepAspectRatioType(String name) {
      this.name = name;
    }
    
    public String descriptiveName() {
      return name;
    }
  }

  public ImageSize calculateImageSize(KeepAspectRatioType type, int originalX, int originalY, int newX, int newY)
  {
    if (type == KeepAspectRatioType.DONT_KEEP)
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
