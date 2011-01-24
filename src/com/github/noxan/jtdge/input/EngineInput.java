package com.github.noxan.jtdge.input;

import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowListener;
import java.util.List;

import com.github.noxan.jtdge.display.event.EngineWindowListener;
import com.github.noxan.jtdge.input.event.EngineKeyListener;
import com.github.noxan.jtdge.input.event.EngineMouseListener;
import com.github.noxan.jtdge.stage.StageObject;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public interface EngineInput extends StageObject, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener, WindowListener {
	public void setMultipleKeyPress(boolean multipleKeyPress);
	public boolean isMultipleKeyPress();
	public boolean getKeyState(int keyCode);
	
	public void notifyKeyListeners(List<EngineKeyListener> listeners);
	public void notifyMouseListeners(List<EngineMouseListener> listeners);
	public void notifyWindowListeners(List<EngineWindowListener> listeners);
}
