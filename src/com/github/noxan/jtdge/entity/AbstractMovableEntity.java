package com.github.noxan.jtdge.entity;

import com.github.noxan.jtdge.core.Engine;
import com.github.noxan.jtdge.entity.graphics.Appearance;
import com.github.noxan.jtdge.logic.Movable;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b1(r9)
 * @param <E>
 */
public abstract class AbstractMovableEntity<E extends Engine> extends AbstractEntity<E> implements Movable {
	/**
	 * @uml.property  name="dx"
	 */
	private float dx;
	/**
	 * @uml.property  name="dy"
	 */
	private float dy;
	
	
	public AbstractMovableEntity(float x, float y) {
		this(x, y, 0.0f, 0.0f);
	}
	public AbstractMovableEntity(float x, float y, float dx, float dy) {
		super(x, y);
		setSpeedX(dx);
		setSpeedY(dy);
	}
	public AbstractMovableEntity(Appearance appearance, float x, float y) {
		this(appearance, x, y, 0.0f, 0.0f);
	}
	public AbstractMovableEntity(Appearance appearance, float x, float y, float dx, float dy) {
		super(appearance, x, y);
		setSpeedX(dx);
		setSpeedY(dy);
	}
	
	
	@Override
	public void setSpeedX(float dx) {
		this.dx = dx;
	}
	@Override
	public float getSpeedX() {
		return dx;
	}
	public void setSpeedY(float dy) {
		this.dy = dy;
	}
	@Override
	public float getSpeedY() {
		return dy;
	}
	@Override
	public void setSpeed(float dx, float dy) {
		setSpeedX(dx);
		setSpeedY(dy);
	}
	
	@Override
	public void move(long delta) {
		setX(getX()+dx*(delta/1e9f));
		setY(getY()+dy*(delta/1e9f));
	}
	
	@Override
	public void doLogic(long delta) {
		super.doLogic(delta);
		move(delta);
	}
	
}
