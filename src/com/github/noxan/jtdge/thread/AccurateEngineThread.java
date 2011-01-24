package com.github.noxan.jtdge.thread;

import com.github.noxan.jtdge.core.Engine;
import com.github.noxan.jtdge.util.EngineUtilities;

/**
 * A AndreEngineThread is a simple implementation of an EngineThread. Internally it is controlled by
 * a single Thread.
 * @author andre
 * @version 0.7b1(r17)
 */
public class AccurateEngineThread implements EngineThread, Runnable {
	public static final int DEFAULT_DELAYS_PER_YIELD = 16;
	public static final long DEFAULT_FPS_UPDATE_TIME = 1000000000L;
	
	/**
	 * @uml.property  name="engine"
	 * @uml.associationEnd  
	 */
	private Engine engine;
	/**
	 * @uml.property  name="executor"
	 */
	private Thread executor;
	
	/**
	 * @uml.property  name="isRunning"
	 */
	private boolean isRunning;
	
	/**
	 * @uml.property  name="sleepTime"
	 */
	private long sleepTime;
	/**
	 * @uml.property  name="fpsUpdateTime"
	 */
	private long fpsUpdateTime;
	
	/**
	 * @uml.property  name="fps"
	 */
	private float fps;
	
	/**
	 * @uml.property  name="delaysPerYield"
	 */
	private int delaysPerYield;

	
	public AccurateEngineThread(long sleepTime) {
		this(Engine.getDefaultEngine(), sleepTime);
	}
	
	public AccurateEngineThread(long sleepTime, long fpsUpdateTime, int delaysPerYield) {
		this(Engine.getDefaultEngine(), sleepTime, fpsUpdateTime, delaysPerYield);
	}
	
	public AccurateEngineThread(Engine engine, long sleepTime) {
		this(engine, sleepTime, DEFAULT_FPS_UPDATE_TIME, DEFAULT_DELAYS_PER_YIELD);
	}

	public AccurateEngineThread(Engine engine, long sleepTime, long fpsUpdateTime, int delaysPerYield) {
		if(engine == null) {
			throw new IllegalArgumentException("engine must not be null");
		}
		setSleepTime(sleepTime);
		setFpsUpdateTime(fpsUpdateTime);
		setDelaysPerYield(delaysPerYield);
		this.engine = engine;
		this.fps = 0.0f;
	}

	
	@Override
	public void start() {
		if(!isRunning) {
			executor = new Thread(this);
			executor.start();
		}
	}
	@Override
	public void stop() {
		if(isRunning) {
			isRunning = false;
		}
	}
	
	@Override
	public void restart() {
		stop();
		start();
	}

	/**
	 * @return
	 * @uml.property  name="isRunning"
	 */
	@Override
	public boolean isRunning() {
		return isRunning;
	}
	
	public void setDelaysPerYield(int delaysPerYield) {
		if(delaysPerYield < 1) {
			throw new IllegalArgumentException("delaysPerYield must not be less one: " + delaysPerYield);
		}
	}
	
	/**
	 * @return
	 * @uml.property  name="delaysPerYield"
	 */
	public int getDelaysPerYield() {
		return delaysPerYield;
	}

	/**
	 * @param fpsUpdateTime
	 * @uml.property  name="fpsUpdateTime"
	 */
	@Override
	public void setFpsUpdateTime(long fpsUpdateTime) {
		if(fpsUpdateTime < 1L) {
			throw new IllegalArgumentException("fpsUpdateTime must not be less one: " + fpsUpdateTime);
		}
		this.fpsUpdateTime = fpsUpdateTime;
	}

	/**
	 * @return
	 * @uml.property  name="fpsUpdateTime"
	 */
	@Override
	public long getFpsUpdateTime() {
		return fpsUpdateTime;
	}

	/**
	 * @param sleepTime
	 * @uml.property  name="sleepTime"
	 */
	@Override
	public void setSleepTime(long sleepTime) {
		if(sleepTime < 0L) {
			throw new IllegalArgumentException("sleepTime must not be less zero: " + sleepTime);
		}
		this.sleepTime = sleepTime;
	}

	/**
	 * @return
	 * @uml.property  name="sleepTime"
	 */
	@Override
	public long getSleepTime() {
		return sleepTime;
	}

	/**
	 * @return
	 * @uml.property  name="fps"
	 */
	@Override
	public float getFps() {
		return fps;
	}

	@Override
	public void run() {
		long before = 0L;
		long after = 0L;
		long delta = 0L;
		long sleep = 0L;
		long overSleep = 0L;
		long fpsDelta = 0L;
		int fpsCounter = 0;
		int delays = 0;

		fps = 1e9f/sleepTime;
		isRunning = true;

		while(isRunning) {
			before = System.nanoTime();
			
			engine.update(delta);
			engine.render();
			
			after = System.nanoTime();
			
			sleep = (sleepTime-(after-before))-overSleep;
			
			if(sleep > 0) {
				EngineUtilities.sleepNanos(sleep);
				overSleep = (System.nanoTime()-after)-sleep;
			} else {
//				System.out.println("delay");
				overSleep = 0;
				if(++delays >= delaysPerYield) {
					delays = 0;
					Thread.yield();
//					System.out.println("yield");
				}
			}
			
			delta = System.nanoTime()-before;
			
			fpsCounter++;
			fpsDelta += delta;
			
			while(fpsDelta >= fpsUpdateTime) {
				fpsDelta -= fpsUpdateTime;
				fps = fpsCounter*(1e9f/fpsUpdateTime);
				fpsCounter = 0;
			}
		}
	}
}