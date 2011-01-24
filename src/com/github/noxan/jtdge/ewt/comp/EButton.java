package com.github.noxan.jtdge.ewt.comp;

import java.util.LinkedList;
import java.util.List;

import com.github.noxan.jtdge.ewt.event.ActionEvent;
import com.github.noxan.jtdge.ewt.event.ActionListener;
import com.github.noxan.jtdge.input.event.EngineMouseClickEvent;
import com.github.noxan.jtdge.input.event.EngineMouseMoveEvent;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EButton extends EComponent {
	/**
	 * @uml.property  name="actionListeners"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.ewt.event.ActionListener"
	 */
	private List<ActionListener> actionListeners;
	/**
	 * @uml.property  name="text"
	 */
	private String text;
	/**
	 * @uml.property  name="action"
	 */
	private String action;
	
	public EButton(String text, int x, int y) {
		this(text, "", x, y, 100, 25);
	}
	
	public EButton(String text, String action, int x, int y, int width, int height) {
		actionListeners = new LinkedList<ActionListener>();
		setText(text);
		setAction(action);
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}
	
	
	/**
	 * @param text
	 * @uml.property  name="text"
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return
	 * @uml.property  name="text"
	 */
	public String getText() {
		return text;
	}
	
	@Override
	public void mouseMoved(EngineMouseMoveEvent event) {
		if(isEnabled() && isVisible()) {
			if(contains(event.getPoint())) {
				if(isClicked()) {
					setClick(true);
				} else {
					setFocus(true);
				}
			} else {
				setFocus(false);
				if(isClick()) {
					setClick(false);
					setClicked(true);
				}
			}
		}
	}
	@Override
	public void mousePressed(EngineMouseClickEvent event) {
		if(isEnabled() && isVisible() && event.getButton()==EngineMouseClickEvent.BUTTON_1) {
			setClick(contains(event.getPoint()));
		}
	}
	@Override
	public void mouseReleased(EngineMouseClickEvent event) {
		if(isEnabled() && isVisible()) {
			if(isClick()) {
				fireActionEvent(new ActionEvent(getParent(), getAction()));
			}
			setClick(false);
			setClicked(false);
		}
	}
	
	/**
	 * @param action
	 * @uml.property  name="action"
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return
	 * @uml.property  name="action"
	 */
	public String getAction() {
		return action;
	}
	
	public boolean addActionListener(ActionListener l) {
		if(l!=null) {
			synchronized(actionListeners) {
				return actionListeners.add(l);
			}
		}
		return false;
	}
	public boolean removeActionListener(ActionListener l) {
		if(l!=null) {
			synchronized(actionListeners) {
				return actionListeners.remove(l);
			}
		}
		return false;
	}
	private void fireActionEvent(ActionEvent e) {
		synchronized(actionListeners) {
			for(int index=0;index<actionListeners.size();index++) {
				actionListeners.get(index).actionPerformed(e);
			}
		}
	}
	
	@Override
	public String getViewID() {
		return "ButtonView";
	}
}
