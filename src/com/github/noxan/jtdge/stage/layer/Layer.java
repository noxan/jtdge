package com.github.noxan.jtdge.stage.layer;

import java.util.Set;

import com.github.noxan.jtdge.render.Renderable;

/**
 * 
 * @author andre
 * @version 0.6b2(r12)
 * @since 0.6b2(r12)
 */
public interface Layer extends Renderable {
	public static final int DEFAULT_LAYER = 0;
	
	public boolean addRenderable(Renderable renderable);
	
	public boolean removeRenderable(Renderable renderable);
	
	public Set<Renderable> getRenderables();
	
	public int getRenderableCount();
}
