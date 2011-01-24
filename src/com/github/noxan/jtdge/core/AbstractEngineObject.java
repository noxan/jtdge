package com.github.noxan.jtdge.core;

/**
 * @author andre
 * @version 0.7b1(r17)
 * @since 0.6b1(r9)
 * @param <E >
 */
public abstract class AbstractEngineObject<E extends Engine> implements EngineObject<E> {
	/**
	 * @uml.property  name="engine"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private E engine;
	
	@SuppressWarnings("unchecked")
	public AbstractEngineObject() {
		this((E)Engine.getDefaultEngine());
	}
	
	public AbstractEngineObject(E engine) {
		if(engine==null) {
			throw new IllegalArgumentException("engine must not be null");
		}
		this.engine = engine;
	}
	
	/**
	 * @return
	 * @uml.property  name="engine"
	 */
	@Override
	public E getEngine() {
		return engine;
	}
}
