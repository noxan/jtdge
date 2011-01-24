package com.github.noxan.jtdge.ewt.style.basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import com.github.noxan.jtdge.ewt.comp.EComponent;
import com.github.noxan.jtdge.ewt.comp.EPanel;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r14)
 */
public class BasicPanelView extends BasicComponentView {
	public BasicPanelView() {
	}
	
	@Override
	public void renderComponent(Graphics2D g2, EComponent c) {
		EPanel panel = (EPanel) c;
		Color color = g2.getColor();
		Shape clip = g2.getClip();
		Font font = g2.getFont();
		
		BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D ig2 = (Graphics2D) image.createGraphics();
		
		ig2.setColor(panel.getBackground());
		ig2.fillRect(0, 0, panel.getWidth(), panel.getHeight());
		
		if(panel.getBorder()!=null) {
			panel.getBorder().paintBorder(panel, ig2, 0, 0, panel.getWidth(), panel.getHeight());
		}
		for(EComponent component:panel.getComponents()) {
			component.render(ig2);
		}
		
		g2.drawImage(image, panel.getX(), panel.getY(), null);
		
		g2.setColor(color);
		g2.setClip(clip);
		g2.setFont(font);
	}
}
