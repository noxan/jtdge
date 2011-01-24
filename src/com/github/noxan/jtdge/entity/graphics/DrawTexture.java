package com.github.noxan.jtdge.entity.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.github.noxan.jtdge.geom.Point2D;
import com.github.noxan.jtdge.util.GraphicUtilities;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.6b3(r13)
 */
public abstract class DrawTexture implements Appearance {
	/**
	 * @uml.property  name="repaint"
	 */
	private boolean repaint;
	/**
	 * @uml.property  name="image"
	 */
	private BufferedImage image;
	
	public DrawTexture(float width, float height) {
		image = new BufferedImage(GraphicUtilities.f2i(width), GraphicUtilities.f2i(height), BufferedImage.TYPE_INT_ARGB);
		repaint = true;
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
	
	public abstract void draw(Graphics2D g2);
	
	/**
	 * Gibt ein Bild zurück, das dem Aussehen der Textur entspricht.
	 * @return image die Textur 
	 */
	@Override
	public BufferedImage getAppearance() {
		if(repaint) {
			draw(image.createGraphics());
			repaint = false;
		}
		return image;
	}
}
