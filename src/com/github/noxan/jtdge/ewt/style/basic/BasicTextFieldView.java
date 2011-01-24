package com.github.noxan.jtdge.ewt.style.basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;

import com.github.noxan.jtdge.ewt.comp.EComponent;
import com.github.noxan.jtdge.ewt.comp.ETextField;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r15)
 */
public class BasicTextFieldView extends BasicComponentView {
	public BasicTextFieldView() {
		super();
	}
	
	@Override
	public void renderComponent(Graphics2D g2, EComponent c) {
		super.renderComponent(g2, c);
		ETextField tf = (ETextField) c;
		Color color = g2.getColor();
		Shape clip = g2.getClip();
		Font font = g2.getFont();
		
		g2.setColor(tf.getBackground());
		g2.fillRect(tf.getX(), tf.getY(), tf.getWidth(), tf.getHeight());
		
		g2.setColor(tf.getForeground());
		TextLayout layout = new TextLayout(tf.getText(), tf.getFont(), g2.getFontRenderContext());
		double twidth = layout.getBounds().getWidth();
		double theight = layout.getBounds().getHeight();
		g2.drawString(tf.getText(), (int)(tf.getX()+(tf.getWidth()-twidth)/2), (int)(tf.getY()+(tf.getHeight()+theight)/2));
		
		g2.setColor(color);
		g2.setClip(clip);
		g2.setFont(font);
	}
}
