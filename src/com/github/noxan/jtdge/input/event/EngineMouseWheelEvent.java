package com.github.noxan.jtdge.input.event;

import java.awt.Point;

import com.github.noxan.jtdge.geom.Point2D;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EngineMouseWheelEvent extends EngineMouseEvent {
	/**
	 * @uml.property  name="amount"
	 */
	private int amount;
	/**
	 * @uml.property  name="rotation"
	 */
	private int rotation;
	
	public EngineMouseWheelEvent(int type, Point point, int button, int amount, int rotation) {
		this(type, new Point2D.Integer(point), button, amount, rotation);
	}
	
	public EngineMouseWheelEvent(int type, Point2D.Integer point, int button, int amount, int rotation) {
		super(type, point, button);
		this.amount = amount;
		this.rotation = rotation;
	}
	
	/**
	 * @return
	 * @uml.property  name="amount"
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * @return
	 * @uml.property  name="rotation"
	 */
	public int getRotation() {
		return rotation;
	}
}
