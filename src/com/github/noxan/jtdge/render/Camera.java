package com.github.noxan.jtdge.render;


import java.awt.Graphics2D;

import com.github.noxan.jtdge.core.Engine;
import com.github.noxan.jtdge.core.EngineObject;

/**
 * 
 * @author andre
 * @version 0.6b2(r11)
 * @since 0.6b2(r11)
 */
public interface Camera extends EngineObject<Engine> {
	public void setX(int x);
	public int getX();
	
	public void setY(int y);
	public int getY();
	
	public void setZoomX(float zoomX);
	public float getZoomX();
	
	public void setZoomY(float zoomY);
	public float getZoomY();
	
	public int getWidth();
	public int getHeight();
	
	public void prepare(Graphics2D g2D);
	public void restore(Graphics2D g2D);
}
