package com.github.noxan.jtdge.ewt.border;

import java.awt.Graphics2D;
import java.awt.Insets;

import com.github.noxan.jtdge.ewt.comp.EComponent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r14)
 */
public abstract class AbstractBorder implements Border {
	@Override
	public void paintBorder(EComponent c, Graphics2D g2, int x, int y, int width, int height) {
	}
	public Insets getBorderInsets() {
		return new Insets(0, 0, 0, 0);
	}
}
