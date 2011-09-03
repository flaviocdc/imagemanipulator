package br.ufrj.dcc.compgraf.im.transform;

import java.awt.image.BufferedImage;

/**
 * http://www.cs.nott.ac.uk/~smx/IVIPracticals/exercise1.html
 */
public class Flip
{
  public enum FlipOrientation
  {
    HORIZONTALLY, VERTICALLY
  }

  public BufferedImage flip(BufferedImage source, FlipOrientation orientation)
  {
    switch (orientation)
    {
      case HORIZONTALLY:
      {
        return flipHorizontally(source);
      }
      case VERTICALLY:
      {
        return flipVertically(source);
      }
      default:
      {
        throw new IllegalArgumentException();
      }
    }
  }

  private BufferedImage flipVertically(BufferedImage source)
  {
    BufferedImage newImg = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);

    for (int x = 0; x < source.getWidth(); x++)
    {
      for (int y = 0; y < source.getHeight(); y++)
      {
        newImg.setRGB(x, source.getHeight() - y - 1, source.getRGB(x, y));
      }
    }

    return newImg;
  }

  private BufferedImage flipHorizontally(BufferedImage source)
  {
    BufferedImage newImg = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);

    for (int x = 0; x < source.getWidth(); x++)
    {
      for (int y = 0; y < source.getHeight(); y++)
      {
        newImg.setRGB(source.getWidth() - x - 1, y, source.getRGB(x, y));
      }
    }

    return newImg;
  }
}