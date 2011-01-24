package com.github.noxan.jtdge.core.factory;


import com.github.noxan.jtdge.display.DefaultEngineDisplay;
import com.github.noxan.jtdge.display.EngineDisplay;
import com.github.noxan.jtdge.input.DefaultEngineInput;
import com.github.noxan.jtdge.input.EngineInput;
import com.github.noxan.jtdge.thread.DefaultEngineThread;
import com.github.noxan.jtdge.thread.EngineThread;


/**
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.5.8
 */
public class DefaultEngineFactory implements EngineFactory {
	/**
	 * @uml.property  name="sleepTime"
	 */
	private long sleepTime;
	/**
	 * @uml.property  name="fpsUpdateTime"
	 */
	private long fpsUpdateTime;
	/**
	 * @uml.property  name="delaysPerYield"
	 */
	private int delaysPerYield;
	
	/**
	 * @uml.property  name="title"
	 */
	private String title;
	/**
	 * @uml.property  name="x"
	 */
	private int x;
	/**
	 * @uml.property  name="y"
	 */
	private int y;
	/**
	 * @uml.property  name="width"
	 */
	private int width;
	/**
	 * @uml.property  name="height"
	 */
	private int height;
	
	public DefaultEngineFactory(long sleepTime, String title, int x, int y, int width, int height) {
		this(sleepTime, DefaultEngineThread.DEFAULT_FPS_UPDATE_TIME, DefaultEngineThread.DEFAULT_DELAYS_PER_YIELD, title, x, y, width, height);
	}
	
	public DefaultEngineFactory(long sleepTime, long fpsUpdateTime, int delaysPerYield, String title, int x, int y, int width, int height) {
		this.sleepTime = sleepTime;
		this.fpsUpdateTime = fpsUpdateTime;
		this.delaysPerYield = delaysPerYield;
		this.title = title;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	@Override
	public EngineThread createEngineThread() {
		return new DefaultEngineThread(sleepTime, fpsUpdateTime, delaysPerYield);
	}
	
	@Override
	public EngineDisplay createEngineDisplay() {
		return new DefaultEngineDisplay(title, x, y, width, height);
	}
	
	@Override
	public EngineInput createEngineInput() {
		return new DefaultEngineInput();
	}
}
