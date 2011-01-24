package com.github.noxan.jtdge.render;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import com.github.noxan.jtdge.core.AbstractEngineObject;
import com.github.noxan.jtdge.core.Engine;

/**
 * 
 * @author andre
 * @version 0.7b1(r17)
 * @since 0.6b2(r11)
 */
public class DefaultCamera extends AbstractEngineObject<Engine> implements Camera {
	/**
	 * @uml.property  name="x"
	 */
	private int x;
	/**
	 * @uml.property  name="y"
	 */
	private int y;

	/**
	 * @uml.property  name="width"
	 */
	private int width;
	/**
	 * @uml.property  name="height"
	 */
	private int height;
	
	/**
	 * @uml.property  name="zoomX"
	 */
	private float zoomX;
	/**
	 * @uml.property  name="zoomY"
	 */
	private float zoomY;
	
	/**
	 * @uml.property  name="save"
	 */
	private AffineTransform save;
	
	
	public DefaultCamera() {
		this(0, 0);
	}
	
	public DefaultCamera(int x, int y) {
		this(Engine.getDefaultEngine(), x, y);
	}
	
	public DefaultCamera(Engine engine, int x, int y) {
		this(engine, x, y, 1.0f, 1.0f);
	}
	
	public DefaultCamera(int x, int y, float zoomX, float zoomY) {
		this(Engine.getDefaultEngine(), x, y, zoomX, zoomY);
	}
	
	public DefaultCamera(Engine engine, int x, int y, float zoomX, float zoomY) {
		super(engine);
		this.x = x;
		this.y = y;
		this.zoomX = zoomX;
		this.zoomY = zoomY;
	}	
	
	/**
	 * @param x
	 * @uml.property  name="x"
	 */
	@Override
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @return
	 * @uml.property  name="x"
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/**
	 * @param y
	 * @uml.property  name="y"
	 */
	@Override
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return
	 * @uml.property  name="y"
	 */
	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * @param zoomX
	 * @uml.property  name="zoomX"
	 */
	@Override
	public void setZoomX(float zoomX) {
		this.zoomX = zoomX;
	}
	
	/**
	 * @return
	 * @uml.property  name="zoomX"
	 */
	@Override
	public float getZoomX() {
		return zoomX;
	}
	
	/**
	 * @param zoomY
	 * @uml.property  name="zoomY"
	 */
	@Override
	public void setZoomY(float zoomY) {
		this.zoomY = zoomY;
	}
	
	/**
	 * @return
	 * @uml.property  name="zoomY"
	 */
	@Override
	public float getZoomY() {
		return zoomY;
	}
	
	/**
	 * @return
	 * @uml.property  name="width"
	 */
	@Override
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return
	 * @uml.property  name="height"
	 */
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void prepare(Graphics2D g2D) {
		width = (int)(getEngine().getEngineDisplay().getWidth()/zoomX);
		height = (int)(getEngine().getEngineDisplay().getHeight()/zoomY);
		save = g2D.getTransform();
		g2D.scale(zoomX, zoomY);
		g2D.translate(-x, -y);
	}
	
	@Override
	public void restore(Graphics2D g2D) {
		g2D.setTransform(save);
	}
}
