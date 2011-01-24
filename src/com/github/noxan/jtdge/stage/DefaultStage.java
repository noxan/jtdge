package com.github.noxan.jtdge.stage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.github.noxan.jtdge.core.AbstractEngineObject;
import com.github.noxan.jtdge.core.Engine;
import com.github.noxan.jtdge.entity.Entity;
import com.github.noxan.jtdge.ewt.comp.EComponent;
import com.github.noxan.jtdge.input.event.EngineKeyListener;
import com.github.noxan.jtdge.input.event.EngineMouseListener;
import com.github.noxan.jtdge.logic.Logical;
import com.github.noxan.jtdge.render.Camera;
import com.github.noxan.jtdge.render.DefaultCamera;
import com.github.noxan.jtdge.render.Renderable;
import com.github.noxan.jtdge.stage.background.ColorStageBackground;
import com.github.noxan.jtdge.stage.background.StageBackground;
import com.github.noxan.jtdge.stage.layer.DefaultLayer;
import com.github.noxan.jtdge.stage.layer.Layer;
import com.github.noxan.jtdge.util.Tuple;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class DefaultStage extends AbstractEngineObject<Engine> implements Stage {
	/**
	 * @uml.property  name="engine"
	 * @uml.associationEnd  
	 */
	private Engine engine;
	
	/**
	 * @uml.property  name="camera"
	 * @uml.associationEnd  
	 */
	private Camera camera;
	/**
	 * @uml.property  name="background"
	 * @uml.associationEnd  
	 */
	private StageBackground background;
	
	/**
	 * @uml.property  name="width"
	 */
	private int width;
	/**
	 * @uml.property  name="height"
	 */
	private int height;
	
	/**
	 * @uml.property  name="active"
	 */
	private boolean active;
	
	/**
	 * @uml.property  name="components"
	 */
	private Set<EComponent> components;
	/**
	 * @uml.property  name="componentsToChange"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.util.Tuple"
	 */
	private Queue<Tuple<EComponent, Boolean>> componentsToChange;
	
	/**
	 * @uml.property  name="logicables"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.logic.Logical"
	 */
	private Set<Logical> logicables;
	/**
	 * @uml.property  name="immutableLogicables"
	 */
	private Set<Logical> immutableLogicables;
	/**
	 * @uml.property  name="logicablesToChange"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.util.Tuple"
	 */
	private Queue<Tuple<Logical, Boolean>> logicablesToChange;
	
	/**
	 * @uml.property  name="layers"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer com.beanstalkapp.noxan.jtdge.stage.layer.Layer"
	 */
	private Map<Integer, Layer> layers;
	/**
	 * @uml.property  name="immutableLayers"
	 */
	private Map<Integer, Layer> immutableLayers;
	
	/**
	 * @uml.property  name="keyListeners"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.input.event.EngineKeyListener"
	 */
	private List<EngineKeyListener> keyListeners;
	/**
	 * @uml.property  name="mouseListeners"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.input.event.EngineMouseListener"
	 */
	private List<EngineMouseListener> mouseListeners;
	
	public DefaultStage(int width, int height) {
		this(width, height, new DefaultCamera(0, 0));
	}
	public DefaultStage(int width, int height, Camera camera) {
		this(width, height, camera, new ColorStageBackground(Color.BLACK));
	}
	public DefaultStage(int width, int height, Camera camera, StageBackground background) {
		this(width, height, true, camera, background, new DefaultLayer());
	}
	public DefaultStage(int width, int height, boolean active, Camera camera, StageBackground background, Layer defaultLayer) {
		engine = Engine.getDefaultEngine();
		setWidth(width);
		setHeight(height);
		components = new HashSet<EComponent>();
		componentsToChange = new LinkedList<Tuple<EComponent,Boolean>>();
		logicables = new HashSet<Logical>();
		immutableLogicables = Collections.unmodifiableSet(logicables);
		logicablesToChange = new LinkedList<Tuple<Logical,Boolean>>();
		layers = new TreeMap<Integer, Layer>();
		immutableLayers = Collections.unmodifiableMap(layers);
		keyListeners = new LinkedList<EngineKeyListener>();
		mouseListeners = new LinkedList<EngineMouseListener>();
		setActive(active);
		setCamera(camera);
		setBackground(background);
		setLayer(Layer.DEFAULT_LAYER, defaultLayer);
	}
	
	/**
	 * @return
	 * @uml.property  name="engine"
	 */
	@Override
	public Engine getEngine() {
		return engine;
	}
	
	/**
	 * @param background
	 * @uml.property  name="background"
	 */
	@Override
	public void setBackground(StageBackground background) {
		if(background == null) {
			throw new IllegalArgumentException("background must not be null");
		}
		if(this.background != null) {
			this.background.setStage(null);
		}
		background.setStage(this);
		this.background = background;
	}
	
	/**
	 * @return
	 * @uml.property  name="background"
	 */
	@Override
	public StageBackground getBackground() {
		return background;
	}
	
	/**
	 * @param width
	 * @uml.property  name="width"
	 */
	@Override
	public void setWidth(int width) {
		if(width < 0) {
			throw new IllegalArgumentException("width must not be less zero: " + width);
		}
		this.width = width;
	}
	
	/**
	 * @return
	 * @uml.property  name="width"
	 */
	@Override
	public int getWidth() {
		return width;
	}
	
	/**
	 * @param height
	 * @uml.property  name="height"
	 */
	@Override
	public void setHeight(int height) {
		if(height < 0) {
			throw new IllegalArgumentException("height must not be less zero: " + height);
		}
		this.height = height;
	}
	
	/**
	 * @return
	 * @uml.property  name="height"
	 */
	@Override
	public int getHeight() {
		return height;
	}
	
	/**
	 * @param camera
	 * @uml.property  name="camera"
	 */
	@Override
	public void setCamera(Camera camera) {
		if(camera == null) {
			throw new IllegalArgumentException("camera must not be null");
		}
		this.camera = camera;
	}
	
	/**
	 * @return
	 * @uml.property  name="camera"
	 */
	@Override
	public Camera getCamera() {
		return camera;
	}
	
	
	/**
	 * @return
	 * @uml.property  name="active"
	 */
	@Override
	public boolean isActive() {
		return active;
	}
	
	/**
	 * @param active
	 * @uml.property  name="active"
	 */
	@Override
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	@Override
	public boolean addComponent(EComponent component) {
		if(component!=null) {
			return componentsToChange.add(new Tuple<EComponent, Boolean>(component, true));
		}
		return false;
	}
	@Override
	public boolean removeComponent(EComponent component) {
		if(component!=null) {
			return componentsToChange.add(new Tuple<EComponent, Boolean>(component, false));
		}
		return false;
	}
	
	public void addEngineKeyListener(EngineKeyListener listener) {
		if(listener!=null) {
			keyListeners.add(listener);
		}
	}
	public void removeEngineKeyListener(EngineKeyListener listener) {
		if(listener!=null) {
			keyListeners.remove(listener);
		}
	}
	
	public void addEngineMouseListener(EngineMouseListener listener) {
		if(listener!=null) {
			mouseListeners.add(listener);
		}
	}
	public void removeEngineMouseListener(EngineMouseListener listener) {
		if(listener!=null) {
			mouseListeners.remove(listener);
		}
	}
	
	
	@Override
	public boolean addEntity(Entity<? extends Engine> entity) {
		return addEntity(Layer.DEFAULT_LAYER, entity);
	}
	
	@Override
	public boolean addEntity(int level, Entity<? extends Engine> entity) {
		if(entity != null) {
			addRenderable(level, entity);
			addLogicable(entity);
			entity.setStage(this);
//			entity.init();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean removeEntity(Entity<? extends Engine> entity) {
		return removeEntity(Layer.DEFAULT_LAYER, entity);
	}
	
	@Override
	public boolean removeEntity(int level, Entity<? extends Engine> entity) {
		if(entity != null) {
			if(removeRenderable(level, entity)) {
				removeLogicable(entity);
				//setStage(null); //TODO: nullpointer exception!
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean addLogicable(Logical logicable) {
		if(logicable != null) {
			return logicablesToChange.add(new Tuple<Logical, Boolean>(logicable, true));
		}
		return false;
	}
	
	@Override
	public boolean removeLogicable(Logical logicable) {
		if(logicable != null) {
			return logicablesToChange.add(new Tuple<Logical, Boolean>(logicable, false));
		}
		return false;
	}
	
	@Override
	public Set<Logical> getLogicables() {
		return immutableLogicables;
	}
	
	@Override
	public int getLogicableCount() {
		return immutableLogicables.size();
	}
	
	@Override
	public boolean addRenderable(Renderable renderable) {
		return addRenderable(Layer.DEFAULT_LAYER, renderable);
	}
	
	@Override
	public boolean addRenderable(int level, Renderable renderable) {
		if(renderable != null) {
			Layer layer = layers.get(level);
			if(layer == null) {
				layer = new DefaultLayer();
				layers.put(level, layer);
			}
			return layer.addRenderable(renderable);
		}
		return false;
	}
	
	@Override
	public boolean removeRenderable(Renderable renderable) {
		return removeRenderable(Layer.DEFAULT_LAYER, renderable);
	}
	
	@Override
	public boolean removeRenderable(int level, Renderable renderable) {
		if(renderable != null) {
			Layer layer = layers.get(level);
			if(layer != null) {
				boolean result = layer.removeRenderable(renderable);
				if(layer.getRenderableCount() == 0) {
					layers.remove(level);
				}
				return result;
			}
		}
		return false;
	}
	
	@Override
	public Layer setLayer(int level, Layer layer) {
		if(layer == null) {
			throw new IllegalArgumentException("layer must not be null");
		}
		return layers.put(level, layer);
	}
	
	@Override
	public Layer getLayer(int level) {
		return layers.get(level);
	}
	
	@Override
	public boolean removeLayer(Layer layer) {
		for(Entry<Integer, Layer> entry : layers.entrySet()) {
			if(entry.getValue() == layer && entry.getKey() != Layer.DEFAULT_LAYER) {
				layers.remove(entry.getKey());
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Layer removeLayer(int level) {
		if(level != Layer.DEFAULT_LAYER) {
			return layers.remove(level);
		}
		return null;
	}
	
	@Override
	public Map<Integer, Layer> getLayers() {
		return immutableLayers;
	}
	
	@Override
	public int getLayerCount() {
		return immutableLayers.size();
	}
	
	@Override
	public void doLogic(long delta) {
		while(!logicablesToChange.isEmpty()) {
			Tuple<Logical, Boolean> logicable = logicablesToChange.poll();
			if(logicable.getSecond()) {
				logicables.add(logicable.getFirst());
			} else {
				logicables.remove(logicable.getFirst());
			}
		}
		
		while(!componentsToChange.isEmpty()) {
			Tuple<EComponent, Boolean> component = componentsToChange.poll();
			if(component.getSecond()) {
				components.add(component.getFirst());
				mouseListeners.add(component.getFirst());
			} else {
				components.remove(component.getFirst());
				mouseListeners.remove(component.getFirst());
			}
		}
		handleInput();
		Iterator<Logical> it = logicables.iterator();
		while(it.hasNext()) {
			it.next().doLogic(delta);
		}
	}
	
	private void handleInput() {
		getEngine().getEngineInput().notifyKeyListeners(keyListeners);
		getEngine().getEngineInput().notifyMouseListeners(mouseListeners);
	}
	
	@Override
	public void render(Graphics2D g2) {
		camera.prepare(g2);
		Shape clip = g2.getClip();
		g2.setClip(0, 0, width, height);
		background.render(g2);
		for(Layer layer : layers.values()) {
			layer.render(g2);
		}
		g2.setClip(clip);
		camera.restore(g2);
		for(EComponent c:components) {//TODO: render components
			c.render(g2);
		}
	}
}
