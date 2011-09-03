package br.ufrj.dcc.compgraf.im.transform;

import java.awt.image.BufferedImage;

import org.apache.log4j.Logger;

public class Rotate {

	private static Logger log = Logger.getLogger(Rotate.class);
	
	public enum Degree {
		ROTATE_90,  ROTATE_180, ROTATE_270;
	}
	
	public BufferedImage rotate(BufferedImage source, Degree degree) {
		switch(degree) {
			case ROTATE_90: {
				return rotate90(source);
			}
			case ROTATE_180: {
				return rotate90(rotate90(source));
			}
			case ROTATE_270: {
				return rotate90(rotate90(rotate90(source)));
			}
			default: {
				throw new IllegalArgumentException();
			}
		}
	}
	
	private BufferedImage rotate90(BufferedImage source) {
		BufferedImage rotated = new BufferedImage(source.getHeight(), source.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		log.debug("Original image: " + source.getWidth() + "x" + source.getHeight());
		log.debug("Rotated image: " + rotated.getWidth() + "x" + rotated.getHeight());
		
		for (int x = 0; x < source.getWidth(); x++) {
			for (int y = 0; y < source.getHeight(); y++) {
				rotated.setRGB(y, x, source.getRGB(source.getWidth() - 1 - x, y));
			}
		}
		
		return rotated;
	}
	
}