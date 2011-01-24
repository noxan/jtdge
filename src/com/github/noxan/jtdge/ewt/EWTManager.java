package com.github.noxan.jtdge.ewt;

import com.github.noxan.jtdge.ewt.comp.EComponent;
import com.github.noxan.jtdge.ewt.style.ComponentView;
import com.github.noxan.jtdge.ewt.style.basic.BasicStyle;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r11)
 */
public class EWTManager {
	private static Style style = new BasicStyle();
	
	public static ComponentView getView(EComponent c) {
		return style.getView(c);
	}
	public static Style getStyle() {
		return style;
	}
}
