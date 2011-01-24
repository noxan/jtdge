package com.github.noxan.jtdge.display.event;

import java.awt.event.WindowEvent;


/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b1(r17)
 */
public interface EngineWindowListener {

	public void windowOpened(WindowEvent event);

	public void windowClosing(WindowEvent event);

	public void windowClosed(WindowEvent event);

	public void windowIconified(WindowEvent event);

	public void windowDeiconified(WindowEvent event);

	public void windowActivated(WindowEvent event);

	public void windowDeactivated(WindowEvent event);
	
}
