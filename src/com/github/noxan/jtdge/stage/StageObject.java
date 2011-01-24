package com.github.noxan.jtdge.stage;

/**
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public interface StageObject {
	/**
	 * @param stage
	 * @uml.property  name="stage"
	 */
	public void setStage(Stage stage);
	/**
	 * @uml.property  name="stage"
	 * @uml.associationEnd  
	 */
	public Stage getStage();
}