package com.github.noxan.jtdge.stage;

import java.util.Map;
import java.util.Set;

import com.github.noxan.jtdge.core.Engine;
import com.github.noxan.jtdge.core.EngineObject;
import com.github.noxan.jtdge.entity.Entity;
import com.github.noxan.jtdge.ewt.comp.EComponent;
import com.github.noxan.jtdge.input.event.EngineKeyListener;
import com.github.noxan.jtdge.input.event.EngineMouseListener;
import com.github.noxan.jtdge.logic.Logical;
import com.github.noxan.jtdge.render.Camera;
import com.github.noxan.jtdge.render.Renderable;
import com.github.noxan.jtdge.stage.background.StageBackground;
import com.github.noxan.jtdge.stage.layer.Layer;

/**
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public interface Stage extends EngineObject<Engine>, Renderable, Logical {
	public int getWidth();
	public void setWidth(int width);
	public int getHeight();
	public void setHeight(int height);
	
	/**
	 * @param background
	 * @uml.property  name="background"
	 */
	public void setBackground(StageBackground background);
	/**
	 * @uml.property  name="background"
	 * @uml.associationEnd  
	 */
	public StageBackground getBackground();
	
	/**
	 * @param camera
	 * @uml.property  name="camera"
	 */
	public void setCamera(Camera camera);
	/**
	 * @uml.property  name="camera"
	 * @uml.associationEnd  
	 */
	public Camera getCamera();
	
	//TODO: active/passive?
	public void setActive(boolean active);
	public boolean isActive();
	
	//TODO: component-manager?
	public boolean addComponent(EComponent component);
	public boolean removeComponent(EComponent component);
	
	public void addEngineKeyListener(EngineKeyListener listener);
	public void removeEngineKeyListener(EngineKeyListener listener);
	
	public void addEngineMouseListener(EngineMouseListener listener);
	public void removeEngineMouseListener(EngineMouseListener listener);
	
	public boolean addEntity(Entity<? extends Engine> entity);
	public boolean addEntity(int level, Entity<? extends Engine> entity);
	public boolean removeEntity(Entity<? extends Engine> entity);
	public boolean removeEntity(int level, Entity<? extends Engine> entity);
	
	public boolean addLogicable(Logical logicable);
	public boolean removeLogicable(Logical logicable);
	public Set<Logical> getLogicables();
	public int getLogicableCount();
	
	public boolean addRenderable(Renderable renderable);
	public boolean addRenderable(int level, Renderable renderable);
	public boolean removeRenderable(Renderable renderable);
	public boolean removeRenderable(int level, Renderable renderable);
	
	public Layer setLayer(int level, Layer layer);
	public Layer getLayer(int level);
	public boolean removeLayer(Layer layer);
	public Layer removeLayer(int level);
	public Map<Integer, Layer> getLayers();
	public int getLayerCount();
}
