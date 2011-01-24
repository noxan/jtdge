package com.github.noxan.jtdge.graphics;


import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


/**
 * @author andre
 * @version 0.7b1(r17)
 * @since 0.5.8
 */
public class EngineGraphics {
	/**
	 * @uml.property  name="environment"
	 */
	private GraphicsEnvironment environment;
	/**
	 * @uml.property  name="device"
	 */
	private GraphicsDevice device;
	/**
	 * @uml.property  name="configuration"
	 */
	private GraphicsConfiguration configuration;
	
	
	public EngineGraphics() {
		environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		device = environment.getDefaultScreenDevice();
		configuration = device.getDefaultConfiguration();
	}
	
	public EngineGraphics(GraphicsEnvironment environment, GraphicsDevice device, GraphicsConfiguration configuration) {
		if(environment == null) {
			throw new IllegalArgumentException("environment must not be null");
		}
		if(device == null) {
			throw new IllegalArgumentException("device must not be null");
		}
		if(configuration == null) {
			throw new IllegalArgumentException("configuration must not be null");
		}
		this.environment = environment;
		this.device = device;
		this.configuration = configuration;
	}
	
	
	/**
	 * @return
	 * @uml.property  name="environment"
	 */
	public GraphicsEnvironment getEnvironment() {
		return environment;
	}
	
	/**
	 * @return
	 * @uml.property  name="device"
	 */
	public GraphicsDevice getDevice() {
		return device;
	}
	
	/**
	 * @return
	 * @uml.property  name="configuration"
	 */
	public GraphicsConfiguration getConfiguration() {
		return configuration;
	}
}
