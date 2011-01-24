package com.github.noxan.jtdge.entity.graphics;

import java.awt.image.BufferedImage;

import com.github.noxan.jtdge.geom.Point2D;

/**
 * Interface für das Aussehen von Enitites.
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.6b1(r9)
 */
public interface Appearance {
	/**
	 * @uml.property  name="appearance"
	 */
	public BufferedImage getAppearance();
	
	public void animate(long delta);
	
	public float getWidth();
	public float getHeight();
	/**
	 * @uml.property  name="size"
	 * @uml.associationEnd  
	 */
	public Point2D.Float getSize();
}
