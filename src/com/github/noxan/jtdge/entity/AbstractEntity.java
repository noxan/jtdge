package com.github.noxan.jtdge.entity;

import java.awt.Graphics2D;
import java.awt.Shape;

import com.github.noxan.jtdge.core.AbstractEngineObject;
import com.github.noxan.jtdge.core.Engine;
import com.github.noxan.jtdge.entity.graphics.Appearance;
import com.github.noxan.jtdge.entity.graphics.AppearanceFactory;
import com.github.noxan.jtdge.geom.Point2D;
import com.github.noxan.jtdge.stage.Stage;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b1(r9)
 * @param <E>
 */
public abstract class AbstractEntity<E extends Engine> extends AbstractEngineObject<E> implements Entity<E> {
	/**
	 * @uml.property  name="stage"
	 * @uml.associationEnd  
	 */
	private Stage stage;
	/**
	 * @uml.property  name="appearance"
	 * @uml.associationEnd  
	 */
	private Appearance appearance;
	/**
	 * @uml.property  name="x"
	 */
	private float x;
	/**
	 * @uml.property  name="y"
	 */
	private float y;
	/**
	 * @uml.property  name="visible"
	 */
	private boolean visible;
	
	public AbstractEntity() {
		this(0.0f, 0.0f, 10.0f, 10.0f);
	}
	public AbstractEntity(float x, float y) {
		this(x, y, 10.0f, 10.0f);
	}
	public AbstractEntity(float x, float y, float width, float height) {
		this(AppearanceFactory.getErrorAppearance(width, height), x, y);
	}
	public AbstractEntity(Appearance appearance, float x, float y) {
		this.appearance = appearance;
		this.setLocation(x, y);
		this.setVisible(true);
	}
	
	/**
	 * @return
	 * @uml.property  name="stage"
	 */
	@Override
	public Stage getStage() {
		return stage;
	}
	/**
	 * @param stage
	 * @uml.property  name="stage"
	 */
	@Override
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * @param x
	 * @uml.property  name="x"
	 */
	@Override
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * @return
	 * @uml.property  name="x"
	 */
	@Override
	public float getX() {
		return x;
	}
	/**
	 * @param y
	 * @uml.property  name="y"
	 */
	@Override
	public void setY(float y) {
		this.y = y;
	}
	/**
	 * @return
	 * @uml.property  name="y"
	 */
	@Override
	public float getY() {
		return y;
	}
	@Override
	public void setLocation(float x, float y) {
		setX(x);
		setY(y);
	}
	@Override
	public void setLocation(Point2D.Float p) {
		setX(p.x);
		setY(p.y);
	}
	@Override
	public Point2D.Float getLocation() {
		return new Point2D.Float(getX(), getY());
	}
	
	@Override
	public float getWidth() {
		return appearance.getWidth();
	}
	@Override
	public float getHeight() {
		return appearance.getHeight();
	}
	@Override
	public Point2D.Float getSize() {
		return appearance.getSize();
	}
	
	@Override
	public void doLogic(long delta) {
		appearance.animate(delta);
	}
	/**
	 * @param b
	 * @uml.property  name="visible"
	 */
	@Override
	public void setVisible(boolean b) {
		visible = b;
	}
	/**
	 * @return
	 * @uml.property  name="visible"
	 */
	@Override
	public boolean isVisible() {
		return visible;
	}
	/**
	 * @param appearance
	 * @uml.property  name="appearance"
	 */
	@Override
	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}
	/**
	 * @return
	 * @uml.property  name="appearance"
	 */
	@Override
	public Appearance getAppearance() {
		return appearance;
	}
	@Override
	public void render(Graphics2D g2d) {
		if(isVisible()) {
			Shape clip = g2d.getClip();
			g2d.setClip(Math.round(getX()), Math.round(getY()), Math.round(getWidth()), Math.round(getHeight()));
			g2d.drawImage(appearance.getAppearance(), Math.round(getX()), Math.round(getY()), null);
			g2d.setClip(clip);
		}
	}
}
