package com.github.noxan.jtdge.ewt.event;

import com.github.noxan.jtdge.core.EngineEvent;
import com.github.noxan.jtdge.ewt.comp.EComponent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EWTEvent extends EngineEvent {
	/**
	 * @uml.property  name="source"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private EComponent source;
	
	public EWTEvent(EComponent source) {
		setSource(source);
	}
	
	/**
	 * @param source
	 * @uml.property  name="source"
	 */
	private void setSource(EComponent source) {
		this.source = source;
	}
	
	/**
	 * @return
	 * @uml.property  name="source"
	 */
	public EComponent getSource() {
		return source;
	}
}
