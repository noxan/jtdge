package com.github.noxan.jtdge.ewt.style;

import java.awt.Graphics2D;

import com.github.noxan.jtdge.ewt.comp.EComponent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r14)
 */
public interface ComponentView {
	public void renderComponent(Graphics2D g2, EComponent c);
}
