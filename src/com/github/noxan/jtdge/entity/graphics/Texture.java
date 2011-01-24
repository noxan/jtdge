package com.github.noxan.jtdge.entity.graphics;

import java.awt.image.BufferedImage;

import com.github.noxan.jtdge.geom.Point2D;

/**
 * Texture ist ein nicht animiertes Aussehen für ein Entity. 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.6b1(r9)
 */
public class Texture implements Appearance {
	/**
	 * @uml.property  name="image"
	 */
	private BufferedImage image;
	
	public Texture(BufferedImage image) {
		this.image = image;
	}
	
	/**
	 * Die Methode ist leer, da es sich um eine nich animierte Textur handelt.
	 * @param delta die vergangene Zeit in ms
	 */
	@Override
	public void animate(long delta) {}
	/**
	 * Gibt die Breite der Textur als float zurück.
	 * @return width die Breite der Textur
	 */
	@Override
	public float getWidth() {
		return image.getWidth();
	}
	/**
	 * Gibt die Höhe der Textur als float zurück.
	 * @return height die Höhe der Textur
	 */
	@Override
	public float getHeight() {
		return image.getHeight();
	}
	/**
	 * Gibt die Abmessungen der Textur als Point2f zurück.
	 * @return size die Abmessungen der Textur
	 */
	@Override
	public Point2D.Float getSize() {
		return new Point2D.Float(getWidth(), getHeight());
	}
	/**
	 * Gibt ein Bild zurück, das dem Aussehen der Textur entspricht.
	 * @return image die Textur 
	 */
	@Override
	public BufferedImage getAppearance() {
		return image;
	}
}
