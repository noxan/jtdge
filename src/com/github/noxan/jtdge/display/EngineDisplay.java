package com.github.noxan.jtdge.display;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JFrame;

/**
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.2.4
 */
public interface EngineDisplay {
	public void setVisible(boolean b);
	public boolean isVisible();
	public void dispose();
	
	public void setResizable(boolean resizeable);
	public boolean isResizable();
	
	public void setLocation(int x, int y);
	/**
	 * @param location
	 * @uml.property  name="location"
	 */
	public void setLocation(Point location);
	/**
	 * @uml.property  name="location"
	 */
	public Point getLocation();
	
	public void setWidth(int width);
	public int getWidth();
	
	public void setHeight(int height);
	public int getHeight();
	
	/**
	 * @param size
	 * @uml.property  name="size"
	 */
	public void setSize(Dimension size);
	/**
	 * @uml.property  name="size"
	 */
	public Dimension getSize();
	
	/**
	 * @uml.property  name="canvas"
	 */
	public Component getCanvas();
	/**
	 * @uml.property  name="frame"
	 * @uml.associationEnd  
	 */
	public JFrame getFrame();
	
	public void requestFocus();
	
	/**
	 * @uml.property  name="drawGraphics2D"
	 */
	public Graphics2D getDrawGraphics2D();
	public void repaint();
}
