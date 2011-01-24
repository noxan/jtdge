package com.github.noxan.jtdge.logic;

/**
 * 
 * @author andre, richard
 * @version 0.6b1(r9)
 * @since 0.6b1(r9)
 */
public interface Movable {
	public void move(long delta);
	
	public void setSpeedX(float dx);
	public float getSpeedX();
	
	public void setSpeedY(float dy);
	public float getSpeedY();
	
	public void setSpeed(float dx, float dy);
}
