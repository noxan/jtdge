package com.github.noxan.jtdge.ewt.focus;

import java.util.LinkedList;
import java.util.List;

import com.github.noxan.jtdge.ewt.comp.EComponent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b1(r17)
 */
public class EWTFocusManager {
	public static EWTFocusManager instance;
	
	/**
	 * @uml.property  name="focusables"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.ewt.focus.Focusable"
	 */
	private List<Focusable> focusables;
	/**
	 * @uml.property  name="focusOwner"
	 * @uml.associationEnd  readOnly="true"
	 */
	@SuppressWarnings("unused")
	private EComponent focusOwner;
	
	public EWTFocusManager() {
		focusables = new LinkedList<Focusable>();
	}
	
	public static EWTFocusManager getCurrentManager() {
		if(instance==null) {
			instance = new EWTFocusManager();
		}
		return instance;
	}
	
	public static void addFocusable(int index, Focusable focusable) {
		instance.focusables.add(index, focusable);
	}
	public static void removeFocusable(int index) {
		instance.focusables.remove(index);
	}
	public static void removeFocusable(Focusable focusable) {
		instance.focusables.remove(focusable);
	}
	
	
}
