package com.github.noxan.jtdge.util;

/**
 * 
 * @author andre
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class Tuple<A, B> extends Single<A> {
	/**
	 * @uml.property  name="second"
	 */
	private B second;
	
	public Tuple() {
		this(null, null);
	}
	
	public Tuple(A first, B second) {
		super(first);
		this.second = second;
	}
	
	public void setSecond(B second) {
		this.second = second;
	}
	
	public B getSecond() {
		return second;
	}
}
