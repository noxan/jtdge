package com.github.noxan.jtdge.input.event;

/**
 * 
 * @author andre, richard
 * @version 0.6b2(r10)
 * @since 0.6b2(r10)
 */
public abstract class EngineMouseAdapter implements EngineMouseListener{
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
