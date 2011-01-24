package com.github.noxan.jtdge.input.event;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EngineKeyEvent extends EngineInputEvent {
	/**
	 * @uml.property  name="key"
	 */
	private int key;
	
	public EngineKeyEvent(int type, int key) {
		super(type);
		this.key = key;
	}
	
	/**
	 * @return
	 * @uml.property  name="key"
	 */
	public int getKey() {
		return key;
	}
}
