package com.github.noxan.jtdge.ewt.style.basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;

import com.github.noxan.jtdge.ewt.EWTManager;
import com.github.noxan.jtdge.ewt.comp.EButton;
import com.github.noxan.jtdge.ewt.comp.EComponent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r14)
 */
public class BasicButtonView extends BasicComponentView {
	public BasicButtonView() {
		
	}
	
	@Override
	public void renderComponent(Graphics2D g2, EComponent c) {
		EButton button = (EButton) c;
		Color color = g2.getColor();
		Shape clip = g2.getClip();
		Font font = g2.getFont();
		
		Color bg = c.getBackground();
		Color fg = c.getForeground();
		
		if(!c.isEnabled()) {
			bg = bg.darker();
			fg = fg.darker();
		} else {
			if(c.isClick()) {
				bg = bg.darker();
			} else if(c.hasFocus()) {
				bg = bg.brighter();
			}
		}
		
		paintButton(g2, button.getX(), button.getY(), button.getWidth(), button.getHeight(), button.getText(), 
				EWTManager.getStyle().getFont(), fg, bg);
		
		
		g2.setColor(color);
		g2.setClip(clip);
		g2.setFont(font);
	}
	
	
	private void paintButton(Graphics2D g2, int x, int y, int width, int height, String text, Font font, Color fg, Color bg) {
		g2.setColor(bg);
		g2.fillRect(x, y, width, height);
		g2.setColor(bg.brighter());
		g2.drawRect(x, y, width-1, height-1);
		TextLayout layout = new TextLayout(text, font, g2.getFontRenderContext());
		double twidth = layout.getBounds().getWidth();
		double theight = layout.getBounds().getHeight();
		g2.setColor(fg);
		g2.setFont(font);
		/*if(twidth>=width && theight>=height) {
			g2.drawString(text, (int)(x+(width-twidth)/2), (int)(y+(height+theight)/2));
		} else if(twidth>=width) {
			g2.drawString(text, (int)(x+(width-twidth)/2), (int)(y+(height+theight)/2));
		} else if(theight>=height) {
			g2.drawString(text, (int)(x+(width-twidth)/2), (int)(y+(height+theight)/2));
		} else {*/
			g2.drawString(text, (int)(x+(width-twidth)/2), (int)(y+(height+theight)/2));
		/*}*/
	}
}
