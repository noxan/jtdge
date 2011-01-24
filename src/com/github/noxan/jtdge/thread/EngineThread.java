package com.github.noxan.jtdge.thread;

/**
 * 
 * @author andre, richard
 * @version 0.6b2(r10)
 * @since 0.2.4
 */
public interface EngineThread {
	public void start();
	public void stop();
	public void restart();
	public boolean isRunning();
	public float getFps();
	public void setFpsUpdateTime(long time);
	public long getFpsUpdateTime();
	public void setSleepTime(long sleep);
	public long getSleepTime();
}
