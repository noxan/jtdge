package com.github.noxan.jtdge.stage;

/**
 * 
 * @author andre, richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public abstract class AbstractStageObject implements StageObject {
	/**
	 * @uml.property  name="stage"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Stage stage;
	
	public AbstractStageObject() {
		this(null);
	}
	
	public AbstractStageObject(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * @param stage
	 * @uml.property  name="stage"
	 */
	@Override
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * @return
	 * @uml.property  name="stage"
	 */
	@Override
	public Stage getStage() {
		return stage;
	}
}