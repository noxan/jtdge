package com.github.noxan.jtdge.input;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.github.noxan.jtdge.display.event.EngineWindowListener;
import com.github.noxan.jtdge.input.event.EngineKeyEvent;
import com.github.noxan.jtdge.input.event.EngineKeyListener;
import com.github.noxan.jtdge.input.event.EngineMouseClickEvent;
import com.github.noxan.jtdge.input.event.EngineMouseEvent;
import com.github.noxan.jtdge.input.event.EngineMouseListener;
import com.github.noxan.jtdge.input.event.EngineMouseMoveEvent;
import com.github.noxan.jtdge.input.event.EngineMouseWheelEvent;
import com.github.noxan.jtdge.render.Camera;
import com.github.noxan.jtdge.stage.AbstractStageObject;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class DefaultEngineInput extends AbstractStageObject implements EngineInput {
	/**
	 * @uml.property  name="keyEvents"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.input.event.EngineKeyEvent"
	 */
	private Queue<EngineKeyEvent> keyEvents;
	/**
	 * @uml.property  name="mouseEvents"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.input.event.EngineMouseEvent"
	 */
	private Queue<EngineMouseEvent> mouseEvents;
	/**
	 * @uml.property  name="windowEvents"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.awt.event.WindowEvent"
	 */
	private Queue<WindowEvent> windowEvents;
	
	/**
	 * @uml.property  name="multipleKeyPress"
	 */
	private boolean multipleKeyPress;
	/**
	 * @uml.property  name="keys" multiplicity="(0 -1)" dimension="1"
	 */
	private int[] keys;
	
	/**
	 * @uml.property  name="mouseInside"
	 */
	private boolean mouseInside;
	/**
	 * @uml.property  name="buttons"
	 */
	private int buttons;
	/**
	 * @uml.property  name="lastMouseAction"
	 */
	private Point lastMouseAction;
	/**
	 * @uml.property  name="lastMouseMove"
	 */
	private Point lastMouseMove;
	
	public DefaultEngineInput() {
		this(false);
	}
	
	public DefaultEngineInput(boolean multipleKeyPress) {
		keyEvents = new ConcurrentLinkedQueue<EngineKeyEvent>();
		mouseEvents = new ConcurrentLinkedQueue<EngineMouseEvent>();
		windowEvents = new ConcurrentLinkedQueue<WindowEvent>();
		
		this.multipleKeyPress = multipleKeyPress;
		keys = new int[8];
		
		mouseInside = true;
		buttons = 0;
		lastMouseAction = new Point(0, 0);
		lastMouseMove = new Point(0, 0);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()>-1&&e.getKeyCode()<256) {
			if(multipleKeyPress||!getKeyState(e.getKeyCode())) {
				keys[e.getKeyCode()/32] |= 1<<(e.getKeyCode()%32);
				keyEvents.offer(new EngineKeyEvent(EngineKeyEvent.KEY_PRESSED, e.getKeyCode()));
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()>-1&&e.getKeyCode()<256) {
			if(multipleKeyPress||getKeyState(e.getKeyCode())) {
				keys[e.getKeyCode()/32] &= ~(1<<(e.getKeyCode()%32));
				keyEvents.offer(new EngineKeyEvent(EngineKeyEvent.KEY_RELEASED, e.getKeyCode()));
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		buttons |= getButtonFor(e.getButton());
		if(getStage()!=null&&mouseInside) {
			Point point = transformPoint(e.getPoint());
			mouseEvents.offer(new EngineMouseClickEvent(EngineMouseClickEvent.MOUSE_PRESSED, point, lastMouseAction, buttons));
			if(e.getClickCount()==2) {
				mouseEvents.offer(new EngineMouseClickEvent(EngineMouseClickEvent.MOUSE_DOUBLECLICKED, point, lastMouseAction, buttons));
			}
			lastMouseAction = point;
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		buttons &= ~getButtonFor(e.getButton());
		if(getStage()!=null&&mouseInside) {
			Point point = transformPoint(e.getPoint());
			mouseEvents.offer(new EngineMouseClickEvent(EngineMouseClickEvent.MOUSE_RELEASED, point, lastMouseAction, buttons));
			lastMouseAction = point;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if(getStage()!=null&&!mouseInside) {
			mouseInside = true;
			Point point = transformPoint(e.getPoint());
			mouseEvents.offer(new EngineMouseMoveEvent(EngineMouseMoveEvent.MOUSE_ENTERED, point, lastMouseMove, buttons));
			lastMouseMove = point;
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if(getStage()!=null&&mouseInside) {
			mouseInside = false;
			Point point = transformPoint(e.getPoint());
			mouseEvents.offer(new EngineMouseMoveEvent(EngineMouseMoveEvent.MOUSE_EXITED, point, lastMouseMove, buttons));
			lastMouseMove = point;
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		onMouseMove(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		onMouseMove(e);
	}
	
	private void onMouseMove(MouseEvent e) {
		if(getStage()!=null) {
			Point point = transformPoint(e.getPoint());
			if(mouseInside||e.getID()==MouseEvent.MOUSE_DRAGGED) {
				mouseEvents.offer(new EngineMouseMoveEvent(
						EngineMouseMoveEvent.MOUSE_MOVED,
						point, lastMouseMove, buttons));
			}
			lastMouseMove = point;
		}
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(getStage()!=null&&mouseInside) {
			mouseEvents.offer(new EngineMouseWheelEvent(getScrollTypeFor(e.getScrollType()),
					transformPoint(e.getPoint()), buttons, e.getScrollAmount(), e.getWheelRotation()));
		}
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		windowEvents.offer(e);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		windowEvents.offer(e);
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		windowEvents.offer(e);
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		windowEvents.offer(e);
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		windowEvents.offer(e);
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		windowEvents.offer(e);
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		windowEvents.offer(e);
	}
	
	/**
	 * @param multipleKeyPress
	 * @uml.property  name="multipleKeyPress"
	 */
	@Override
	public void setMultipleKeyPress(boolean multipleKeyPress) {
		this.multipleKeyPress = multipleKeyPress;
	}
	
	/**
	 * @return
	 * @uml.property  name="multipleKeyPress"
	 */
	@Override
	public boolean isMultipleKeyPress() {
		return multipleKeyPress;
	}
	
	@Override
	public boolean getKeyState(int keyCode) {
		return (keys[keyCode/32]&(1<<(keyCode%32)))!=0;
	}
	
	@Override
	public void notifyKeyListeners(List<EngineKeyListener> listeners) {
		while(!keyEvents.isEmpty()) {
			EngineKeyEvent event = keyEvents.poll();
			switch(event.getType()) {
			case EngineKeyEvent.KEY_PRESSED:
				for(EngineKeyListener listener:listeners) {
					listener.keyPressed(event);
				}
				break;
			case EngineKeyEvent.KEY_RELEASED:
				for(EngineKeyListener listener:listeners) {
					listener.keyReleased(event);
				}
				break;
			}
		}
	}
	
	@Override
	public void notifyMouseListeners(List<EngineMouseListener> listeners) {
		while(!mouseEvents.isEmpty()) {
			EngineMouseEvent event = mouseEvents.poll();
			switch(event.getType()) {
			case EngineMouseEvent.MOUSE_PRESSED:
				for(EngineMouseListener listener:listeners) {
					listener.mousePressed((EngineMouseClickEvent)event);
				}
				break;
			case EngineMouseEvent.MOUSE_RELEASED:
				for(EngineMouseListener listener:listeners) {
					listener.mouseReleased((EngineMouseClickEvent)event);
				}
				break;
			case EngineMouseEvent.MOUSE_DOUBLECLICKED:
				for(EngineMouseListener listener:listeners) {
					listener.mouseDoubleClicked((EngineMouseClickEvent)event);
				}
				break;
			case EngineMouseMoveEvent.MOUSE_MOVED:
				for(EngineMouseListener listener:listeners) {
					listener.mouseMoved((EngineMouseMoveEvent)event);
				}
				break;
			case EngineMouseMoveEvent.MOUSE_ENTERED:
				for(EngineMouseListener listener:listeners) {
					listener.mouseEntered((EngineMouseMoveEvent)event);
				}
				break;
			case EngineMouseMoveEvent.MOUSE_EXITED:
				for(EngineMouseListener listener:listeners) {
					listener.mouseExited((EngineMouseMoveEvent)event);
				}
				break;
			case EngineMouseWheelEvent.MOUSE_WHEEL_BLOCK_SCROLL:
			case EngineMouseWheelEvent.MOUSE_WHEEL_UNIT_SCROLL:
				for(EngineMouseListener listener:listeners) {
					listener.mouseWheelMoved((EngineMouseWheelEvent)event);
				}
				break;
			}
		}
	}
	
	public void notifyWindowListeners(List<EngineWindowListener> listeners) {
		while(!windowEvents.isEmpty()) {
			WindowEvent event = windowEvents.poll();
			switch(event.getID()) {
			case WindowEvent.WINDOW_OPENED:
				for(EngineWindowListener listener:listeners) {
					listener.windowOpened(event);
				}
				break;
			case WindowEvent.WINDOW_CLOSING:
				for(EngineWindowListener listener:listeners) {
					listener.windowClosing(event);
				}
				break;
			case WindowEvent.WINDOW_CLOSED:
				for(EngineWindowListener listener:listeners) {
					listener.windowClosed(event);
				}
				break;
			case WindowEvent.WINDOW_ICONIFIED:
				for(EngineWindowListener listener:listeners) {
					listener.windowIconified(event);
				}
				break;
			case WindowEvent.WINDOW_DEICONIFIED:
				for(EngineWindowListener listener:listeners) {
					listener.windowDeiconified(event);
				}
				break;
			case WindowEvent.WINDOW_ACTIVATED:
				for(EngineWindowListener listener:listeners) {
					listener.windowActivated(event);
				}
				break;
			case WindowEvent.WINDOW_DEACTIVATED:
				for(EngineWindowListener listener:listeners) {
					listener.windowDeactivated(event);
				}
				break;
			}
		}
	}
	
	private int getButtonFor(int button) {
		switch(button) {
		case MouseEvent.NOBUTTON:
			return EngineMouseEvent.BUTTON_NO;
		case MouseEvent.BUTTON1:
			return EngineMouseEvent.BUTTON_1;
		case MouseEvent.BUTTON2:
			return EngineMouseEvent.BUTTON_2;
		case MouseEvent.BUTTON3:
			return EngineMouseEvent.BUTTON_3;
		default:
			throw new IllegalArgumentException("button has no valid value: "+button);
		}
	}
	
	private int getScrollTypeFor(int scrollType) {
		switch(scrollType) {
		case java.awt.event.MouseWheelEvent.WHEEL_UNIT_SCROLL:
			return EngineMouseEvent.MOUSE_WHEEL_UNIT_SCROLL;
		case java.awt.event.MouseWheelEvent.WHEEL_BLOCK_SCROLL:
			return EngineMouseEvent.MOUSE_WHEEL_BLOCK_SCROLL;
		default:
			throw new IllegalArgumentException("scrollType has no valid value:"+scrollType);
		}
	}
	
	private Point transformPoint(Point point) {
		Camera camera = getStage().getCamera();
		return new Point(camera.getX()+(int)(point.x/camera.getZoomX()),
							camera.getY()+(int)(point.y/camera.getZoomY()));
	}
}
