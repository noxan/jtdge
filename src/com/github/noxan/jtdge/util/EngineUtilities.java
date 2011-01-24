package com.github.noxan.jtdge.util;

/**
 * 
 * @author andre, richard
 * @version 0.3.6
 * @since 0.2.5
 */
public final class EngineUtilities {
	private EngineUtilities() {}
	
	public static long sleepNanos(long nanoTime) {
		long start = System.nanoTime();
		while(System.nanoTime()-start<nanoTime) {
			Thread.yield();
		}
		return (System.nanoTime()-start)-nanoTime;
	}
}
