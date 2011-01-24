package com.github.noxan.jtdge.pref;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.1.3
 */
public class Version {
	private static final Type TYPE = Type.BETA;
	private static final int MAJOR = 0;
	private static final int MINOR = 7;
	private static final int PATCH = 1;
	private static final int REVISION = 17;
	
	private Version() {}
	
	public static String getType() {
		return TYPE.toString();
	}
	public static int getMajor() {
		return MAJOR;
	}
	public static int getMinor() {
		return MINOR;
	}
	public static int getPatch() {
		return PATCH;
	}
	public static int getRevision() {
		return REVISION;
	}
	
	public static String getVersion() {
		return getVersion("%m.%n.%r");
	}
	public static String getVersionPatch() {
		return getVersion("%m.%n%t%p");
	}
	public static String getVersion(String format) {
		format = format.replace("%t", getType());
		format = format.replace("%m", Integer.toString(getMajor()));
		format = format.replace("%n", Integer.toString(getMinor()));
		if(TYPE!=Type.STABLE) {
			format = format.replace("%p", Integer.toString(getPatch()));
		} else {
			format = format.replace("%p", "");
		}
		format = format.replace("%r", Integer.toString(getRevision()));
		return format;
	}
	/**
	 * @author   richard
	 */
	private enum Type {
		/**
		 * @uml.property  name="aLPHA"
		 * @uml.associationEnd  
		 */
		ALPHA, /**
		 * @uml.property  name="bETA"
		 * @uml.associationEnd  
		 */
		BETA, /**
		 * @uml.property  name="sTABLE"
		 * @uml.associationEnd  
		 */
		STABLE;
		
		public String toString() {
			return super.toString().substring(0, 1).toLowerCase();
		}
	}
}

