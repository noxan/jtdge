package com.github.noxan.jtdge.stage.layer;

import java.awt.Graphics2D;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.github.noxan.jtdge.render.Renderable;


/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r12)
 */
public class DefaultLayer implements Layer {
	/**
	 * @uml.property  name="renderables"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.render.Renderable"
	 */
	private Set<Renderable> renderables;
	/**
	 * @uml.property  name="immutableRenderables"
	 */
	private Set<Renderable> immutableRenderables;
	
	public DefaultLayer() {
		renderables = new HashSet<Renderable>();
		immutableRenderables = Collections.unmodifiableSet(renderables);
	}
	
	@Override
	public boolean addRenderable(Renderable renderable) {
		if(renderable==null) {
			throw new IllegalArgumentException("renderable must not be null");
		}
		synchronized(renderables) {
			return renderables.add(renderable);
		}
	}
	
	@Override
	public boolean removeRenderable(Renderable renderable) {
		if(renderable!=null) {
			synchronized(renderables) {
				return renderables.remove(renderable);
			}
		}
		return false;
	}
	
	@Override
	public Set<Renderable> getRenderables() {
		return immutableRenderables;
	}
	
	@Override
	public int getRenderableCount() {
		return immutableRenderables.size();
	}
	
	@Override
	public void render(Graphics2D g2D) {
		synchronized(renderables) {
			for(Renderable renderable:renderables) {
				renderable.render(g2D);
			}
		}
	}
}
