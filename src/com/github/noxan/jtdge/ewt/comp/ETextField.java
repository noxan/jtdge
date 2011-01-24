package com.github.noxan.jtdge.ewt.comp;


/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r15)
 */
public class ETextField extends EComponent {
	/**
	 * @uml.property  name="text"
	 */
	private String text;
	
	public ETextField(String text, int x, int y) {
		this(text, x, y, 100, 25);
	}
	
	public ETextField(String text, int x, int y, int width, int height) {
		super();
		setText(text);
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
	public String getViewID() {
		return "TextFieldView";
	}
}
