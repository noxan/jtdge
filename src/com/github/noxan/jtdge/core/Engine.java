package com.github.noxan.jtdge.core;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import com.github.noxan.jtdge.core.factory.DefaultEngineFactory;
import com.github.noxan.jtdge.core.factory.EngineFactory;
import com.github.noxan.jtdge.display.EngineDisplay;
import com.github.noxan.jtdge.display.event.EngineWindowListener;
import com.github.noxan.jtdge.graphics.EngineGraphics;
import com.github.noxan.jtdge.graphics.factory.DefaultEngineGraphicsFactory;
import com.github.noxan.jtdge.graphics.factory.EngineGraphicsFactory;
import com.github.noxan.jtdge.input.EngineInput;
import com.github.noxan.jtdge.stage.DefaultStage;
import com.github.noxan.jtdge.stage.Stage;
import com.github.noxan.jtdge.thread.EngineThread;

/**
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.1.2
 */
public abstract class Engine {
	/**
	 * @uml.property  name="defaultEngine"
	 * @uml.associationEnd  
	 */
	private static Engine defaultEngine = null;
	
	/**
	 * @param defaultEngine
	 * @return
	 * @uml.property  name="defaultEngine"
	 */
	public static Engine setDefaultEngine(Engine defaultEngine) {
		Engine oldEngine = Engine.defaultEngine;
		Engine.defaultEngine = defaultEngine;
		return oldEngine;
	}
	
	/**
	 * @return
	 * @uml.property  name="defaultEngine"
	 */
	public static Engine getDefaultEngine() {
		return defaultEngine;
	}
	
	/**
	 * @uml.property  name="graphics"
	 * @uml.associationEnd  
	 */
	protected EngineGraphics graphics;
	/**
	 * @uml.property  name="thread"
	 * @uml.associationEnd  
	 */
	protected EngineThread thread;
	/**
	 * @uml.property  name="display"
	 * @uml.associationEnd  
	 */
	protected EngineDisplay display;
	/**
	 * @uml.property  name="input"
	 * @uml.associationEnd  
	 */
	protected EngineInput input;
	
	/**
	 * @uml.property  name="windowListeners"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.display.event.EngineWindowListener"
	 */
	private List<EngineWindowListener> windowListeners;
	
	/**
	 * @uml.property  name="stages"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.stage.Stage"
	 */
	private List<Stage> stages;
	
	public Engine(String title, int width, int height, float fps) {
		this(new DefaultEngineFactory((long)(1e9f/fps), title, 100, 50, width, height), new DefaultEngineGraphicsFactory());
	}
	
	public Engine(String title, int x, int y, int width, int height, float fps) {
		this(new DefaultEngineFactory((long)(1e9f/fps), title, x, y, width, height), new DefaultEngineGraphicsFactory());
	}
	
	public Engine(EngineFactory engineFactory) {
		this(engineFactory, new DefaultEngineGraphicsFactory());
	}
	
	public Engine(EngineFactory engineFactory, EngineGraphicsFactory engineGraphicsFactory) {
		if(engineFactory==null) {
			throw new IllegalArgumentException("engineFactory must not be null");
		}
		if(engineGraphicsFactory==null) {
			throw new IllegalArgumentException("engineGraphicsFactory must not be null");
		}
		Engine.defaultEngine = this;
		
		graphics = engineGraphicsFactory.createEngineGraphics();
		thread = engineFactory.createEngineThread();
		display = engineFactory.createEngineDisplay();
		input = engineFactory.createEngineInput();
		
		//TODO: stage ...
		stages = new LinkedList<Stage>();
		stages.add(new DefaultStage(getEngineDisplay().getWidth(), getEngineDisplay().getHeight()));
		input.setStage(stages.get(0));
		
		windowListeners = new LinkedList<EngineWindowListener>();
		
		display.getCanvas().addKeyListener(input);
		display.getCanvas().addMouseListener(input);
		display.getCanvas().addMouseMotionListener(input);
		display.getCanvas().addMouseWheelListener(input);
		display.getFrame().addWindowListener(input);
	}
	
	public EngineDisplay getEngineDisplay() {
		return display;
	}
	
	public EngineGraphics getEngineGraphics() {
		return graphics;
	}
	
	public EngineThread getEngineThread() {
		return thread;
	}
	
	public EngineInput getEngineInput() {
		return input;
	}
	
	public void addEngineWindowListener(EngineWindowListener listener) {
		if(listener!=null) {
			windowListeners.add(listener);
		}
	}
	
	public void removeEngineWindowListener(EngineWindowListener listener) {
		if(listener!=null) {
			windowListeners.remove(listener);
		}
	}
	
	public void render() {
		if(display.isVisible()) {
			Graphics2D g2 = display.getDrawGraphics2D();
			for(int index=0;index<stages.size();index++) {
				Stage stage = getStage(index);
				if(stage!=null && stage.isActive()) {
					stage.render(g2);
				}
			}
			display.repaint();
			g2.dispose();
		}
	}
	
	public void update(long delta) {
		input.notifyWindowListeners(windowListeners);
		for(int index=0;index<stages.size();index++) {
			Stage stage = getStage(index);
			if(stage!=null && stage.isActive()) {
				stage.doLogic(delta);
			}
		}
	}
	
	public boolean addStage(Stage stage) {
		return stages.add(stage);
	}
	public void addStage(int index, Stage stage) {
		stages.add(index, stage);
	}
	public Stage getStage() {
		return getStage(0);
	}
	public Stage getStage(int index) {
		return stages.get(index);
	}
	public Stage removeStage(int index) {
		return stages.remove(index);
	}
	public boolean removeStage(Stage stage) {
		return stages.remove(stage);
	}
	
	public void start() {
		thread.start();
		display.setVisible(true);
	}
	
	public void stop() {
		thread.stop();
		display.setVisible(false);
		display.dispose();
	}
}