package br.ufrj.dcc.compgraf.im.color;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * http://www.johndcook.com/blog/2009/08/24/algorithms-convert-color-grayscale/ 
 */
public class GreyScale
{

  public enum GreyScaleType
  {
    LIGHTNESS
    {

      @Override
      protected int toGreyScale(int rgb)
      {
        Color c = new Color(rgb);
        
        int max = Math.max(Math.max(c.getRed(), c.getBlue()), c.getGreen());
        int min = Math.min(Math.min(c.getRed(), c.getBlue()), c.getGreen());
        int ret = (max + min) / 2;
        
        return new Color(ret, ret, ret).getRGB();
      }
      
    },
    
    AVERAGE
    {

      @Override
      protected int toGreyScale(int rgb)
      {
        Color c = new Color(rgb);
        int ret = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
        
        return new Color(ret, ret, ret).getRGB();
      }
      
    },
    
    LUMINOSITY
    {

      @Override
      protected int toGreyScale(int rgb)
      {
        Color c = new Color(rgb);
        int ret = (int) ((c.getRed() * 0.2126D) + (c.getGreen() * 0.7152D) + (c.getBlue() * 0.0722D));
        
        return new Color(ret, ret, ret).getRGB();
      }
      
    };
    
    protected abstract int toGreyScale(int rgb);
  }
  
  public BufferedImage toGreyScale(BufferedImage source, GreyScaleType type)
  {
    BufferedImage newImg = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
    
    for (int x = 0; x < source.getWidth(); x++)
    {
      for (int y = 0; y < source.getHeight(); y++)
      {
        newImg.setRGB(x, y, type.toGreyScale(source.getRGB(x, y)));
      }
    }
    
    return newImg;
  }
  
}
