package com.github.noxan.jtdge.beta;


import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


//TODO: proper image loader + image library

/**
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r15)
 */
public class ImageLoader {
	/**
	 * @uml.property  name="instance"
	 * @uml.associationEnd  
	 */
	private static ImageLoader instance;
	
	
	private ImageLoader() {}
	
	
	/**
	 * @return
	 * @uml.property  name="instance"
	 */
	public static ImageLoader getInstance() {
		if(instance == null) {
			instance = new ImageLoader();
		}
		return instance;
	}
	
	public BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(getClass().getClassLoader().getResource(path));
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}
