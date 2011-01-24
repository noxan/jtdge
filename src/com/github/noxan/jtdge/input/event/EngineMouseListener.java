package com.github.noxan.jtdge.input.event;

/**
 * 
 * @author andre, richard
 * @version 0.6b2(r10)
 * @since 0.6b2(r10)
 */
public interface EngineMouseListener {
	public void mousePressed(EngineMouseClickEvent event);
	public void mouseReleased(EngineMouseClickEvent event);
	public void mouseDoubleClicked(EngineMouseClickEvent event);
	public void mouseMoved(EngineMouseMoveEvent event);
	public void mouseEntered(EngineMouseMoveEvent event);
	public void mouseExited(EngineMouseMoveEvent event);
	public void mouseWheelMoved(EngineMouseWheelEvent event);
}
