package com.github.noxan.jtdge.core;

import java.util.HashMap;
import java.util.Map;

/**
 * TEST ONLY! (beta)
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b1(r17)
 * @param <E >
 */
public class EngineHints<E extends Engine> {
	/**
	 * @uml.property  name="kEY_DEBUG"
	 * @uml.associationEnd  
	 */
	public static final Key KEY_DEBUG = new Key();
	
	/**
	 * @uml.property  name="vALUE_DEBUG_ON"
	 * @uml.associationEnd  
	 */
	public static final Value VALUE_DEBUG_ON = new Value(KEY_DEBUG);
	/**
	 * @uml.property  name="vALUE_DEBUG_OFF"
	 * @uml.associationEnd  
	 */
	public static final Value VALUE_DEBUG_OFF = new Value(KEY_DEBUG);
	/**
	 * @uml.property  name="vALUE_DEBUG_DEFAULT"
	 * @uml.associationEnd  
	 */
	public static final Value VALUE_DEBUG_DEFAULT = new Value(KEY_DEBUG);
	
	/**
	 * @uml.property  name="instance"
	 * @uml.associationEnd  
	 */
	private static EngineHints<Engine> instance;
	/**
	 * @uml.property  name="map"
	 * @uml.associationEnd  qualifier="key:com.beanstalkapp.noxan.jtdge.core.EngineHints$Key com.beanstalkapp.noxan.jtdge.core.EngineHints$Value"
	 */
	private Map<Key, Value> map;
	
	private EngineHints() {
		map = new HashMap<EngineHints.Key, EngineHints.Value>();
	}
	
	/**
	 * @return
	 * @uml.property  name="instance"
	 */
	public static EngineHints<Engine> getInstance() {
		if(instance==null) {
			instance = new EngineHints<Engine>();
		}
		return instance;
	}
	
	public static void setEngineHint(Key key, Value val) {
		if(val.isCompatible(key)) {
			getInstance().map.put(key, val);
		}
	}
	
	private static class Key {
		protected Key() {
		}
		
		@Override
		public boolean equals(Object obj) {
			return this==obj;
		}
	}
	
	/**
	 * @author  richard
	 */
	private static class Value {
		/**
		 * @uml.property  name="key"
		 * @uml.associationEnd  
		 */
		private Key key;
		
		protected Value(Key key) {
			this.key = key;
		}
		
		public boolean isCompatible(Key key) {
			return this.key.equals(key);
		}
	}
}
