package com.github.noxan.jtdge.manager;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * 
 * @author richard
 * @version 0.1.3
 * @since 0.1.3
 */
public class ImageManager {
	private static ImageManager instance;
	private static HashMap<URL, BufferedImage> map;
	
	private ImageManager() {
		map = new HashMap<URL, BufferedImage>();
	}
	
	public static ImageManager getInstance() {
		if(instance==null) {
			instance = new ImageManager();
		}
		return instance;
	}
	
	public BufferedImage[] getImage(String path, int column, int row) {
		URL location = getURLfromRessource(path);
		return getImage(location, column, row);
	}
	
	public BufferedImage[] getImage(URL location, int column, int row) {
		BufferedImage source = map.get(location);
		
		if(source == null) {
			try {
				source = ImageIO.read(location);
			} catch (IOException e) {
				System.err.println("Fehler beim Laden einer Animation: "+e);
				return null;
			}
			map.put(location, source);
		}
		
		int width = source.getWidth()/column;
		int height = source.getHeight()/row;
		
		BufferedImage[] imgs = new BufferedImage[column*row];
		int count = 0;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				imgs[count] = source.getSubimage(j*width, i*height, width, height);
				count++;
			}
		}
		
		return imgs;
	}
	
	public BufferedImage getImage(String path) {
		URL location = getURLfromRessource(path);
		return getImage(location);
	}
	
	public BufferedImage getImage(URL location) {
		BufferedImage img = map.get(location);
		if(img!=null) {
			return img;
		}
		
		try {
			img = ImageIO.read(location);
		} catch (IOException e) {
			System.err.println("Fehler beim Laden eines Bildes: "+e);
			return null;
		}
		
		map.put(location, img);
		
		return img;
	}
	
	
	private URL getURLfromRessource(String path) {
		return getClass().getClassLoader().getResource(path);
	}
}
