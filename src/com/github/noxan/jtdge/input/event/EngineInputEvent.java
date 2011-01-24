package com.github.noxan.jtdge.input.event;

import com.github.noxan.jtdge.core.EngineEvent;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EngineInputEvent extends EngineEvent {
	public static final int MOUSE_PRESSED = 0;
	public static final int MOUSE_RELEASED = 1;
	public static final int MOUSE_DOUBLECLICKED = 2;
	public static final int MOUSE_MOVED = 3;
	public static final int MOUSE_ENTERED = 4;
	public static final int MOUSE_EXITED = 5;
	public static final int MOUSE_WHEEL_UNIT_SCROLL = 6;
	public static final int MOUSE_WHEEL_BLOCK_SCROLL = 7;
	
	public static final int KEY_PRESSED = 8;
	public static final int KEY_RELEASED = 9;
	
	
	/**
	 * @uml.property  name="type"
	 */
	private int type;
	
	public EngineInputEvent(int type) {
		setType(type);
	}
	
	/**
	 * @param type
	 * @uml.property  name="type"
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * @return
	 * @uml.property  name="type"
	 */
	public int getType() {
		return type;
	}
}
