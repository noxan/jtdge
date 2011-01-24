package com.github.noxan.jtdge.input.event;

import java.awt.Point;

import com.github.noxan.jtdge.geom.Point2D;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EngineMouseClickEvent extends EngineMouseEvent {
	public static final int MOUSE_PRESSED = 0;
	public static final int MOUSE_RELEASED = 1;
	public static final int MOUSE_DOUBLECLICKED = 2;
	
	/**
	 * @uml.property  name="last"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Point2D.Integer last;
	
	public EngineMouseClickEvent(int type, Point2D.Integer point, Point2D.Integer last, int button) {
		super(type, point, button);
		if(last == null) {
			last = point;
		}
	}
	
	public EngineMouseClickEvent(int type, Point point, Point last, int button) {
		this(type, new Point2D.Integer(point), new Point2D.Integer(last), button);
	}
	
	/**
	 * @return
	 * @uml.property  name="last"
	 */
	public Point2D.Integer getLast() {
		return last;
	}
}
