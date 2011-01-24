package com.github.noxan.jtdge.util;

/**
 * 
 * @author andre
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class Single<A> {
	/**
	 * @uml.property  name="first"
	 */
	private A first;
	
	public Single() {
		this(null);
	}
	
	public Single(A first) {
		this.first = first;
	}
	
	public void setFirst(A first) {
		this.first = first;
	}
	
	public A getFirst() {
		return first;
	}
}
