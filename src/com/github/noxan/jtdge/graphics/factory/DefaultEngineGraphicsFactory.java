package com.github.noxan.jtdge.graphics.factory;

import com.github.noxan.jtdge.graphics.EngineGraphics;


/**
 * @author andre
 * @version 0.5.8
 * @since 0.5.8
 */
public class DefaultEngineGraphicsFactory implements EngineGraphicsFactory {
	@Override
	public EngineGraphics createEngineGraphics() {
		return new EngineGraphics();
	}
}
