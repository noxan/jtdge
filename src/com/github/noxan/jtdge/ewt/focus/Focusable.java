package com.github.noxan.jtdge.ewt.focus;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b1(r17)
 */
public interface Focusable {
	public void setFocus(boolean focus);
	public boolean hasFocus();
	
	public void addFocusListener(EngineFocusListener l);
	public void removeFocusListener(EngineFocusListener l);
	
	public void requestFocus();
	public void setNextFocus(Focusable next);
	public void requestFocusNext();
	public void setPrevFocus(Focusable prev);
	public void requestFocusPrev();
	
	public void setFocusable(boolean focusable);
	public boolean isFocusable();
}
