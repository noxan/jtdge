package com.github.noxan.jtdge.core.factory;


import com.github.noxan.jtdge.display.EngineDisplay;
import com.github.noxan.jtdge.input.EngineInput;
import com.github.noxan.jtdge.thread.EngineThread;


/**
 * @author andre
 * @version 0.6b2(r10)
 * @since 0.5.8
 */
public interface EngineFactory {
	public EngineThread createEngineThread();
	public EngineDisplay createEngineDisplay();
	public EngineInput createEngineInput();
}
