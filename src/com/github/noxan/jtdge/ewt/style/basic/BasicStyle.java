package com.github.noxan.jtdge.ewt.style.basic;

import java.awt.Color;
import java.awt.Font;

import com.github.noxan.jtdge.ewt.Style;
import com.github.noxan.jtdge.ewt.comp.EComponent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 
 */
public class BasicStyle implements Style {
	public BasicStyle() {
	}
	
	@Override
	public BasicComponentView getView(EComponent c) {
		final String packageString = "com.beanstalkapp.noxan.jtdge.ewt.style.basic.Basic";
		ClassLoader loader = c.getClass().getClassLoader();
		try {
			Class<?> ext = loader.loadClass(packageString+c.getViewID());
			BasicComponentView view = (BasicComponentView) ext.newInstance();
			return view;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Color getBackground() {
		return new Color(200, 200, 200);
	}
	@Override
	public Color getForeground() {
		return new Color(0, 0, 0);
	}
	@Override
	public Font getFont() {
		return new Font("Verdana", Font.PLAIN, 10);
	}
}
