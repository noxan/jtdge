package com.github.noxan.jtdge.core;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EngineEvent extends AbstractEngineObject<Engine>{
	/**
	 * @uml.property  name="time"
	 */
	private long time;
	
	public EngineEvent() {
		super(Engine.getDefaultEngine());
		setTime(System.nanoTime());
	}
	
	/**
	 * @param time
	 * @uml.property  name="time"
	 */
	protected void setTime(long time) {
		this.time = time;
	}
	
	/**
	 * @return
	 * @uml.property  name="time"
	 */
	public long getTime() {
		return time;
	}
}
