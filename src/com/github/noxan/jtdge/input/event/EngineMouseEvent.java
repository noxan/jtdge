package com.github.noxan.jtdge.input.event;

import java.awt.Point;

import com.github.noxan.jtdge.geom.Point2D;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EngineMouseEvent extends EngineInputEvent {
	public static final int BUTTON_NO = 0;
	public static final int BUTTON_1 = 1;
	public static final int BUTTON_2 = 2;
	public static final int BUTTON_3 = 4;
	
	/**
	 * @uml.property  name="button"
	 */
	private int button;
	/**
	 * @uml.property  name="point"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Point2D.Integer point;
	
	
	public EngineMouseEvent(int type, Point point, int button) {
		this(type, new Point2D.Integer(point), button);
	}
	
	public EngineMouseEvent(int type, Point2D.Integer point, int button) {
		super(type);
		if(point == null) {
			throw new IllegalArgumentException("point must not be null");
		}
		if(button<0 || button>7) {
			throw new IllegalArgumentException("button must be in range [0;7]");
		}
		this.point = point;
		this.button = button;
	}
	
	/**
	 * @return
	 * @uml.property  name="button"
	 */
	public int getButton() {
		return button;
	}
	
	public boolean isButtonPressed(int button) {
		return (this.button&button)==button;
	}
	
	public int getX() {
		return point.x;
	}
	public int getY() {
		return point.y;
	}
	/**
	 * @return
	 * @uml.property  name="point"
	 */
	public Point2D.Integer getPoint() {
		return point;
	}
	
	public EngineMouseEvent translate(int x, int y) {
		return new EngineMouseEvent(getType(), new Point2D.Integer(getPoint().x+x, getPoint().y+y), getButton());
	}
}

