package com.github.noxan.jtdge.ewt.border;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;

import com.github.noxan.jtdge.ewt.comp.EComponent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r14)
 */
public class LineBorder extends AbstractBorder {
	/**
	 * @uml.property  name="color"
	 */
	private Color color;
	/**
	 * @uml.property  name="thickness"
	 */
	private int thickness;
	/**
	 * @uml.property  name="roundedCorners"
	 */
	private boolean roundedCorners;
	
	public LineBorder(Color c) {
		this(c, 1, false);
	}
	public LineBorder(Color c, int thickness) {
		this(c, thickness, false);
	}
	public LineBorder(Color color, int thickness, boolean roundedCorners) {
		this.color = color;
		this.thickness = thickness;
		this.roundedCorners = roundedCorners;
	}
	
	@Override
	public void paintBorder(EComponent c, Graphics2D g2, int x, int y, int width, int height) {
		Color oldColor = g2.getColor();
		g2.setColor(color);
		for(int i=0;i<thickness;i++) {
			if(roundedCorners) {
				g2.drawRoundRect(x+i, y+i, width-i-i-1, height-i-i-1, thickness, thickness);
			} else {
				g2.drawRect(x+i, y+i, width-i-1, height-i-1);
			}
		}
		g2.setColor(oldColor);
	}
	
	@Override
	public Insets getBorderInsets() {
		return new Insets(thickness, thickness, thickness, thickness);
	}
}
