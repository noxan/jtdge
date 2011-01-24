package com.github.noxan.jtdge.ewt.comp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import com.github.noxan.jtdge.ewt.EWTManager;
import com.github.noxan.jtdge.ewt.focus.EngineFocusListener;
import com.github.noxan.jtdge.ewt.focus.Focusable;
import com.github.noxan.jtdge.geom.Point2D;
import com.github.noxan.jtdge.input.event.EngineMouseClickEvent;
import com.github.noxan.jtdge.input.event.EngineMouseListener;
import com.github.noxan.jtdge.input.event.EngineMouseMoveEvent;
import com.github.noxan.jtdge.input.event.EngineMouseWheelEvent;
import com.github.noxan.jtdge.render.Renderable;
import com.github.noxan.jtdge.stage.Stage;

/**
 * EngineWidgetsToolkit (ewt)
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public class EComponent implements Renderable, Focusable, EngineMouseListener {
	/**
	 * @uml.property  name="stage"
	 * @uml.associationEnd  readOnly="true"
	 */
	@SuppressWarnings("unused")
	private Stage stage;
	/**
	 * @uml.property  name="parent"
	 * @uml.associationEnd  readOnly="true"
	 */
	private EComponent parent;
	
	/**
	 * @uml.property  name="x"
	 */
	private int x;
	/**
	 * @uml.property  name="y"
	 */
	private int y;
	
	/**
	 * @uml.property  name="width"
	 */
	private int width;
	/**
	 * @uml.property  name="height"
	 */
	private int height;
	
	/**
	 * @uml.property  name="foreground"
	 */
	private Color foreground = EWTManager.getStyle().getForeground();
	/**
	 * @uml.property  name="background"
	 */
	private Color background = EWTManager.getStyle().getBackground();
	
	/**
	 * @uml.property  name="font"
	 */
	private Font font = EWTManager.getStyle().getFont();
	//focus
	/**
	 * @uml.property  name="focusListeners"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.beanstalkapp.noxan.jtdge.ewt.focus.EngineFocusListener"
	 */
	private List<EngineFocusListener> focusListeners;
	/**
	 * @uml.property  name="nextFocus"
	 * @uml.associationEnd  
	 */
	@SuppressWarnings("unused")
	private Focusable nextFocus;
	/**
	 * @uml.property  name="prevFocus"
	 * @uml.associationEnd  
	 */
	@SuppressWarnings("unused")
	private Focusable prevFocus;
	/**
	 * @uml.property  name="focus"
	 */
	private boolean focus;
	/**
	 * @uml.property  name="focusable"
	 */
	private boolean focusable;
	
	/**
	 * @uml.property  name="visible"
	 */
	private boolean visible;
	/**
	 * @uml.property  name="click"
	 */
	private boolean click;
	/**
	 * @uml.property  name="clicked"
	 */
	private boolean clicked;
	/**
	 * @uml.property  name="enabled"
	 */
	private boolean enabled;
	
	protected EComponent() {
		focusListeners = new LinkedList<EngineFocusListener>();
		setEnabled(true);
		setVisible(true);
		setX(0);
		setY(0);
		setWidth(0);
		setHeight(0);
	}
	
	/**
	 * @return
	 * @uml.property  name="x"
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x
	 * @uml.property  name="x"
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return
	 * @uml.property  name="y"
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y
	 * @uml.property  name="y"
	 */
	public void setY(int y) {
		this.y = y;
	}
	public Point2D.Integer getLocation() {
		return new Point2D.Integer(x, y);
	}
	public void setLocation(int x, int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * @return
	 * @uml.property  name="width"
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width
	 * @uml.property  name="width"
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return
	 * @uml.property  name="height"
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height
	 * @uml.property  name="height"
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	public Point2D.Integer getSize() {
		return new Point2D.Integer(width, height);
	}
	public boolean contains(Point2D.Integer p) {
		return p.x>getX()&&p.x<getX()+getWidth()&&p.y>getY()&&p.y<getY()+getHeight();
	}
	
	/**
	 * @return
	 * @uml.property  name="foreground"
	 */
	public Color getForeground() {
		return foreground;
	}
	/**
	 * @param foreground
	 * @uml.property  name="foreground"
	 */
	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}
	/**
	 * @return
	 * @uml.property  name="background"
	 */
	public Color getBackground() {
		return background;
	}
	/**
	 * @param background
	 * @uml.property  name="background"
	 */
	public void setBackground(Color background) {
		this.background = background;
	}
	
	/**
	 * @return
	 * @uml.property  name="font"
	 */
	public Font getFont() {
		return font;
	}
	/**
	 * @param font
	 * @uml.property  name="font"
	 */
	public void setFont(Font font) {
		this.font = font;
	}
	
	/**
	 * @return
	 * @uml.property  name="parent"
	 */
	public EComponent getParent() {
		return parent;
	}
	
	/**
	 * @param enabled
	 * @uml.property  name="enabled"
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return
	 * @uml.property  name="enabled"
	 */
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * @param visible
	 * @uml.property  name="visible"
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	/**
	 * @return
	 * @uml.property  name="visible"
	 */
	public boolean isVisible() {
		return visible;
	}
	
	@Override
	public void addFocusListener(EngineFocusListener l) {
		focusListeners.add(l);
	}
	@Override
	public void removeFocusListener(EngineFocusListener l) {
		focusListeners.remove(l);
	}
	/**
	 * @param focusable
	 * @uml.property  name="focusable"
	 */
	@Override
	public void setFocusable(boolean focusable) {
		this.focusable = focusable;
	}
	/**
	 * @return
	 * @uml.property  name="focusable"
	 */
	@Override
	public boolean isFocusable() {
		return focusable;
	}
	/**
	 * @param next
	 * @uml.property  name="nextFocus"
	 */
	@Override
	public void setNextFocus(Focusable next) {
		this.nextFocus = next;
	}
	/**
	 * @param prev
	 * @uml.property  name="prevFocus"
	 */
	@Override
	public void setPrevFocus(Focusable prev) {
		this.prevFocus = prev;
	}
	@Override
	public void requestFocus() {
		//TODO:
	}
	@Override
	public void requestFocusNext() {
		//TODO:
	}
	@Override
	public void requestFocusPrev() {
		//TODO:
	}
	/**
	 * @param focus
	 * @uml.property  name="focus"
	 */
	@Override
	public void setFocus(boolean focus) {
		this.focus = focus;
	}
	@Override
	public boolean hasFocus() {
		return focus;
	}
	/**
	 * @param click
	 * @uml.property  name="click"
	 */
	public void setClick(boolean click) {
		this.click = click;
	}
	/**
	 * @return
	 * @uml.property  name="click"
	 */
	public boolean isClick() {
		return click;
	}
	/**
	 * @param clicked
	 * @uml.property  name="clicked"
	 */
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	/**
	 * @return
	 * @uml.property  name="clicked"
	 */
	public boolean isClicked() {
		return clicked;
	}

	public String getViewID() {
		return "EComponentView";
	}
	
	@Override
	public void render(Graphics2D g2) {
		if(isVisible()) {
			EWTManager.getView(this).renderComponent(g2, this);
		}
	}

	@Override
	public void mouseDoubleClicked(EngineMouseClickEvent event) {}
	@Override
	public void mouseEntered(EngineMouseMoveEvent event) {}
	@Override
	public void mouseExited(EngineMouseMoveEvent event) {}
	@Override
	public void mouseMoved(EngineMouseMoveEvent event) {}
	@Override
	public void mousePressed(EngineMouseClickEvent event) {}
	@Override
	public void mouseReleased(EngineMouseClickEvent event) {}
	@Override
	public void mouseWheelMoved(EngineMouseWheelEvent event) {}
}
