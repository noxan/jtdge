package com.github.noxan.jtdge.ewt.event;

import com.github.noxan.jtdge.ewt.comp.EComponent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class ActionEvent extends EWTEvent {
	/**
	 * @uml.property  name="action"
	 */
	private String action;
	
	public ActionEvent(EComponent source, String action) {
		super(source);
		this.action = action;
	}
	public ActionEvent(EComponent source, String action, long time) {
		super(source);
		this.setAction(action);
		this.setTime(time);
	}
	
	/**
	 * @param action
	 * @uml.property  name="action"
	 */
	protected void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * @return
	 * @uml.property  name="action"
	 */
	public String getAction() {
		return action;
	}
	
	@Override
	public String toString() {
		return getClass().getName()+"["+getTime()+";"+getAction()+"]@"+getClass().hashCode();
	}
}
