package com.github.noxan.jtdge.entity;

import com.github.noxan.jtdge.core.Engine;
import com.github.noxan.jtdge.core.EngineObject;
import com.github.noxan.jtdge.entity.graphics.Appearance;
import com.github.noxan.jtdge.geom.Point2D;
import com.github.noxan.jtdge.logic.Logical;
import com.github.noxan.jtdge.render.Renderable;
import com.github.noxan.jtdge.stage.StageObject;

/**
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b1(r9)
 * @param <E >
 */
public interface Entity<E extends Engine> extends EngineObject<E>, Renderable, Logical, StageObject {
	public void setX(float x);
	public float getX();
	
	public void setY(float y);
	public float getY();
	
	/**
	 * @param p
	 * @uml.property  name="location"
	 */
	public void setLocation(Point2D.Float p);
	public void setLocation(float x, float y);
	/**
	 * @uml.property  name="location"
	 * @uml.associationEnd  
	 */
	public Point2D.Float getLocation();
	
	public float getWidth();
	public float getHeight();
	/**
	 * @uml.property  name="size"
	 * @uml.associationEnd  
	 */
	public Point2D.Float getSize();
	
	/**
	 * @param appearance
	 * @uml.property  name="appearance"
	 */
	public void setAppearance(Appearance appearance);
	/**
	 * @uml.property  name="appearance"
	 * @uml.associationEnd  
	 */
	public Appearance getAppearance();
	
	public void setVisible(boolean b);
	public boolean isVisible();
}
