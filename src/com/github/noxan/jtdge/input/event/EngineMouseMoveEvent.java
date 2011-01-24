package com.github.noxan.jtdge.input.event;

import java.awt.Point;

import com.github.noxan.jtdge.geom.Point2D;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EngineMouseMoveEvent extends EngineMouseEvent {
	/**
	 * @uml.property  name="last"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Point2D.Integer last;
	
	public EngineMouseMoveEvent(int type, Point point, Point last, int button) {
		this(type, new Point2D.Integer(point), new Point2D.Integer(last), button);
	}
	
	public EngineMouseMoveEvent(int type, Point2D.Integer point, Point2D.Integer last, int button) {
		super(type, point, button);
		if(last == null) {
			last = point;
		}
	}
	
	/**
	 * @return
	 * @uml.property  name="last"
	 */
	public Point2D.Integer getLast() {
		return last;
	}
	
	
	
}
