package com.github.noxan.jtdge.util;

/**
 * 
 * @author andre
 * @version 0.7b1(r17)
 * @since 0.6b2(r11)
 *
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class Triple<A, B, C> extends Tuple<A, B> {
	/**
	 * @uml.property  name="third"
	 */
	private C third;
	
	public Triple(A first, B second, C third) {
		super(first, second);
		this.third = third;
	}
	
	public void setThird(C third) {
		this.third = third;
	}
	
	public C getThird() {
		return third;
	}
}
