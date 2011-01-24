package com.github.noxan.jtdge.ewt.comp;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import com.github.noxan.jtdge.ewt.border.Border;
import com.github.noxan.jtdge.input.event.EngineMouseClickEvent;
import com.github.noxan.jtdge.input.event.EngineMouseMoveEvent;
import com.github.noxan.jtdge.input.event.EngineMouseWheelEvent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r14)
 */
public class EPanel extends EComponent {
	/**
	 * @uml.property  name="fixedSize"
	 */
	private boolean fixedSize;
	/**
	 * @uml.property  name="border"
	 * @uml.associationEnd  
	 */
	private Border border;
	/**
	 * @uml.property  name="components"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.ewt.comp.EComponent"
	 */
	private List<EComponent> components;
	
	public EPanel(int x, int y) {
		this(x, y, -1, -1);
	}
	
	public EPanel(int x, int y, int width, int height) {
		super();
		setX(x);
		setY(y);
		setBackground(new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 0));
		components = new LinkedList<EComponent>();
		if(width>=0&&height>=0) {
			fixedSize = true;
			setWidth(width);
			setHeight(height);
		}
	}
	
	public Border setBorder(Border border) { //TODO: property change?
		Border oldBorder = getBorder();
		if(border!=null) {
			if(!border.equals(oldBorder)) {
				this.border = border;
			}
		}
		return oldBorder;
	}
	
	/**
	 * @return
	 * @uml.property  name="border"
	 */
	public Border getBorder() {
		return border;
	}
	
	public List<EComponent> getComponents() {
		synchronized(components) {
			return components;
		}
	}
	
	public boolean add(EComponent c) {
		synchronized(components) {
			if(!fixedSize) updateSize(c);
			return components.add(c);
		}
	}
	public boolean remove(EComponent c) {
		synchronized(components) {
			return components.remove(c);
		}
	}
	
	private void updateSize(EComponent c) {
		int _width = c.getX()+c.getWidth()+(getBorder()!=null?getBorder().getBorderInsets().left+getBorder().getBorderInsets().right:0);
		int _height = c.getY()+c.getHeight()+(getBorder()!=null?getBorder().getBorderInsets().top+getBorder().getBorderInsets().bottom:0);
		if(getWidth()<_width) {
			setWidth(_width);
		}
		if(getHeight()<_height) {
			setHeight(_height);
		}
	}
	
	@Override
	public void mouseDoubleClicked(EngineMouseClickEvent event) {
		event = changeEngineMouseClickEvent(event);
		synchronized(components) {
			for(EComponent c:components) {
				c.mouseDoubleClicked(event);
			}
		}
	}
	@Override
	public void mouseEntered(EngineMouseMoveEvent event) {
		event = changeEngineMouseMoveEvent(event);
		synchronized(components) {
			for(EComponent c:components) {
				c.mouseEntered(event);
			}
		}
	}
	@Override
	public void mouseExited(EngineMouseMoveEvent event) {
		event = changeEngineMouseMoveEvent(event);
		synchronized(components) {
			for(EComponent c:components) {
				c.mouseExited(event);
			}
		}
	}

	@Override
	public void mouseMoved(EngineMouseMoveEvent event) {
		event = changeEngineMouseMoveEvent(event);
		synchronized(components) {
			for(EComponent c:components) {
				c.mouseMoved(event);
			}
		}
	}
	@Override
	public void mousePressed(EngineMouseClickEvent event) {
		event = changeEngineMouseClickEvent(event);
		synchronized(components) {
			for(EComponent c:components) {
				c.mousePressed(event);
			}
		}
	}
	@Override
	public void mouseReleased(EngineMouseClickEvent event) {
		event = changeEngineMouseClickEvent(event);
		synchronized(components) {
			for(EComponent c:components) {
				c.mouseReleased(event);
			}
		}
	}
	@Override
	public void mouseWheelMoved(EngineMouseWheelEvent event) {
		event = changeMouseWheelEvent(event);
		synchronized(components) {
			for(EComponent c:components) {
				c.mouseWheelMoved(event);
			}
		}
	}

	private EngineMouseClickEvent changeEngineMouseClickEvent(EngineMouseClickEvent event) {
		return new EngineMouseClickEvent(event.getType(), event.getPoint().translate(-getX(), -getY()), event.getLast()!=null?event.getLast().translate(-getX(), -getY()):null, event.getButton());
	}
	private EngineMouseMoveEvent changeEngineMouseMoveEvent(EngineMouseMoveEvent event) {
		return new EngineMouseMoveEvent(event.getType(), event.getPoint().translate(-getX(), -getY()), event.getLast()!=null?event.getLast().translate(-getX(), -getY()):null, event.getButton());
	}
	private EngineMouseWheelEvent changeMouseWheelEvent(EngineMouseWheelEvent event) {
		return new EngineMouseWheelEvent(event.getType(), event.getPoint().translate(-getX(), -getY()), event.getButton(), event.getAmount(), event.getRotation());
	}
	
	@Override
	public String getViewID() {
		return "PanelView";
	}
}
