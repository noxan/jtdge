package com.github.noxan.jtdge.display;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.2.4
 */
public class DefaultEngineDisplay implements EngineDisplay {
	/**
	 * @uml.property  name="frame"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JFrame frame;
	/**
	 * @uml.property  name="canvas"
	 */
	private Canvas canvas;
	/**
	 * @uml.property  name="bufferStrategy"
	 */
	private BufferStrategy bufferStrategy;
	
	
	public DefaultEngineDisplay(String title, int x, int y, int width, int height) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.setIgnoreRepaint(true);
		frame.setResizable(false);
		frame.setLocation(x, y);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		
		frame.add(canvas);
		
		frame.pack();
		
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		
		canvas.requestFocus();
	}
	
	@Override
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
	
	@Override
	public boolean isVisible() {
		return frame.isVisible();
	}
	
	@Override
	public void dispose() {
		frame.dispose();
	}
	
	@Override
	public void setResizable(boolean resizeable) {
		frame.setResizable(resizeable);
	}
	
	@Override
	public boolean isResizable() {
		return frame.isResizable();
	}
	
	@Override
	public void setLocation(int x, int y) {		
		frame.setLocation(x, y);
	}
	
	@Override
	public void setLocation(Point location) {
		frame.setLocation(location);
	}
	
	@Override
	public Point getLocation() {
		return frame.getLocation();
	}
	
	@Override
	public void setWidth(int width) {
		canvas.setPreferredSize(new Dimension(width, canvas.getHeight()));
		frame.pack();
	}
	
	@Override
	public int getWidth() {
		return canvas.getWidth();
	}
	
	@Override
	public void setHeight(int height) {
		canvas.setPreferredSize(new Dimension(canvas.getWidth(), height));
		frame.pack();
	}
	
	@Override
	public int getHeight() {
		return canvas.getHeight();
	}
	
	@Override
	public void setSize(Dimension size) {
		canvas.setPreferredSize(size);
		frame.pack();
	}
	
	@Override
	public Dimension getSize() {
		return canvas.getSize();
	}
	
	@Override
	public Component getCanvas() {
		return canvas;
	}
	
	/**
	 * @return
	 * @uml.property  name="frame"
	 */
	@Override
	public JFrame getFrame() {
		return frame;
	}
	
	@Override
	public void requestFocus() {
		canvas.requestFocus();
	}
	
	@Override
	public Graphics2D getDrawGraphics2D() {
		return (Graphics2D)bufferStrategy.getDrawGraphics();
	}
	
	@Override
	public void repaint() {
		if(!bufferStrategy.contentsLost()) {
			bufferStrategy.show();
		}
	}
}