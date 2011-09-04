package br.ufrj.dcc.compgraf.im.transform;

import java.awt.image.BufferedImage;

import org.apache.log4j.Logger;

/**
 * http://www.cs.nott.ac.uk/~smx/IVIPracticals/exercise1.html 
 */
public class Rotate
{

  private static Logger log = Logger.getLogger(Rotate.class);

  public enum Degree
  {
    ROTATE_90("90"), ROTATE_180("180"), ROTATE_270("270");
    
    private String name;
    
    private Degree(String name)
    {
      this.name = name;
    }
    
    public String descriptiveName() {
      return name;
    }
  }
  
  public enum Direction
  {
    CLOCKWISE("Clockwise"), COUNTER_CLOCKWISE("Counter Clockwise");
    
    private String name;
    
    private Direction(String name)
    {
      this.name = name;
    }
    
    public String descriptiveName() {
      return name;
    }
  }

  public BufferedImage rotate(BufferedImage source, Degree degree, Direction direction)
  {
    switch (degree)
    {
      case ROTATE_90:
      {
        return rotate90(source, direction);
      }
      case ROTATE_180:
      {
        return rotate90(rotate90(source, direction), direction);
      }
      case ROTATE_270:
      {
        return rotate90(rotate90(rotate90(source, direction), direction), direction);
      }
      default:
      {
        throw new IllegalArgumentException();
      }
    }
  }

  private BufferedImage rotate90(BufferedImage source, Direction direction)
  {
    BufferedImage rotated = new BufferedImage(source.getHeight(), source.getWidth(), BufferedImage.TYPE_INT_RGB);

    log.debug("Original image: " + source.getWidth() + "x" + source.getHeight());
    log.debug("Rotated image: " + rotated.getWidth() + "x" + rotated.getHeight());

    for (int x = 0; x < source.getWidth(); x++)
    {
      for (int y = 0; y < source.getHeight(); y++)
      {
        if (direction == Direction.COUNTER_CLOCKWISE)
          rotated.setRGB(y, x, source.getRGB(source.getWidth() - 1 - x, y));
        else if (direction == Direction.CLOCKWISE)
          rotated.setRGB(y, x, source.getRGB(x, source.getHeight() - 1 - y));
      }
    }

    return rotated;
  }
}