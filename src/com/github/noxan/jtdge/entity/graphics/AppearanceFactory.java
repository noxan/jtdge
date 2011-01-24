package com.github.noxan.jtdge.entity.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.github.noxan.jtdge.util.GraphicUtilities;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b1(r17)
 */
public class AppearanceFactory {
	private AppearanceFactory() {}
	
	public static Texture getErrorAppearance(float width, float height) {
		int iwidth = GraphicUtilities.f2i(width);
		int iheight = GraphicUtilities.f2i(height);
		
		BufferedImage image = new BufferedImage(iwidth, iheight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		
		g2.setColor(Color.RED);
		g2.drawLine(0, 0, iwidth-1, iheight-1);
		g2.drawLine(0, iheight-1, iwidth-1, 0);
		
		g2.drawRect(0, 0, iwidth-1, iheight-1);
		return new Texture(image);
	}
	
}
