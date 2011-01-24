package com.github.noxan.jtdge.math;


/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 */
public class Vector2f {
	/**
	 * @uml.property  name="x"
	 */
	public float x;
	/**
	 * @uml.property  name="y"
	 */
	public float y;
	
	
	public Vector2f() {
		this(0.0f, 0.0f);
	}
	
	public Vector2f(Vector2f v) {
		this(v.x, v.y);
	}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * @param x
	 * @uml.property  name="x"
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * @return
	 * @uml.property  name="x"
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * @param y
	 * @uml.property  name="y"
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * @return
	 * @uml.property  name="y"
	 */
	public float getY() {
		return y;
	}
	
	public void setDirection(Vector2f v) {
		this.x = v.x;
		this.y = v.y;
	}
	
	public void setDirection(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2f getDirection() {
		return new Vector2f(x, y);
	}
	
	public float getLength() {
		return (float)(Math.sqrt(x*x+y*y));
	}
	
	public Vector2f add(Vector2f v) {
		x += v.x;
		y += v.y;
		return this;
	}
	
	public Vector2f subtract(Vector2f v) {
		x -= v.x;
		y -= v.y;
		return this;
	}
	
	public Vector2f multiply(Vector2f v) {
		x *= v.x;
		y *= v.y;
		return this;
	}
	
	public Vector2f divide(Vector2f v) {
		x /= v.x;
		y /= v.y;
		return this;
	}
	
	public Vector2f negate() {
		x = -x;
		y = -y;
		return this;
	}
	
	public Vector2f normalize() {
		float length = (float)(Math.sqrt(x*x+y*y));
		x /= length;
		y /= length;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if(obj instanceof Vector2f) {
			Vector2f v = (Vector2f)obj;
			return x == v.x && y == v.y;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return getClass().getName()+"["+x+"/"+y+"]";
	}
}
