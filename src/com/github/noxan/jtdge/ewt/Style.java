package com.github.noxan.jtdge.ewt;

import java.awt.Color;
import java.awt.Font;

import com.github.noxan.jtdge.ewt.comp.EComponent;
import com.github.noxan.jtdge.ewt.style.ComponentView;

/**
 * @author  richard
 * @version  0.7b1(r17)
 * @since  0.6b2(r11)
 */
public interface Style {
	public ComponentView getView(EComponent c);
	
	/**
	 * @uml.property  name="font"
	 */
	public Font getFont();
	/**
	 * @uml.property  name="background"
	 */
	public Color getBackground();
	/**
	 * @uml.property  name="foreground"
	 */
	public Color getForeground();
}
