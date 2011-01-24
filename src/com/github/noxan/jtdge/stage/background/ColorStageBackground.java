package com.github.noxan.jtdge.stage.background;

import java.awt.Color;
import java.awt.Graphics2D;

import com.github.noxan.jtdge.render.Camera;

/**
 * 
 * @author andre
 * @version 0.7b1(r17)
 * @since 0.6b2(r12)
 */
public class ColorStageBackground extends AbstractStageBackground {
	/**
	 * @uml.property  name="color"
	 */
	private Color color;
	
	public ColorStageBackground(Color color) {
		setColor(color);
	}
	
	/**
	 * @param color
	 * @uml.property  name="color"
	 */
	public void setColor(Color color) {
		if(color==null) {
			throw new IllegalArgumentException("color must not be null");
		}
		this.color = color;
	}
	
	/**
	 * @return
	 * @uml.property  name="color"
	 */
	public Color getColor() {
		return color;
	}
	
	@Override
	public void render(Graphics2D g2D) {
		Camera cam = getStage().getCamera();
		Color c = g2D.getColor();
		g2D.setColor(color);
		g2D.fillRect(cam.getX(), cam.getY(), cam.getWidth(), cam.getHeight());
		g2D.setColor(c);
	}
}
