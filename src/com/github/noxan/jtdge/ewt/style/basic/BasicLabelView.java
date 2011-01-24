package com.github.noxan.jtdge.ewt.style.basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;

import com.github.noxan.jtdge.ewt.comp.EComponent;
import com.github.noxan.jtdge.ewt.comp.ELabel;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 
 */
public class BasicLabelView extends BasicComponentView {
	@Override
	public void renderComponent(Graphics2D g2, EComponent c) {
		ELabel label = (ELabel) c;
		Color color = g2.getColor();
		Shape clip = g2.getClip();
		Font font = g2.getFont();
		g2.setClip(label.getX(), label.getY(), label.getWidth(), label.getHeight());
		
		g2.setColor(label.getBackground());
		g2.fillRect(label.getX(), label.getY(), label.getWidth(), label.getHeight());
		
		g2.setColor(label.getForeground());
		g2.setFont(label.getFont());
		TextLayout layout = new TextLayout(label.getText(), label.getFont(), g2.getFontRenderContext());
		g2.drawString(label.getText(), (int)(label.getX()+(label.getWidth()-layout.getBounds().getWidth())/2), (int)(label.getY()+(label.getHeight()+layout.getBounds().getHeight())/2));
		
		g2.setColor(color);
		g2.setClip(clip);
		g2.setFont(font);
	}
}
