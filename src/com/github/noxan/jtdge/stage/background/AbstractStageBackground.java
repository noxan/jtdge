package com.github.noxan.jtdge.stage.background;

import com.github.noxan.jtdge.stage.Stage;

/**
 * 
 * @author andre
 * @version 0.7b1(r17)
 * @since 0.6b2(r12)
 */
public abstract class AbstractStageBackground implements StageBackground {
	/**
	 * @uml.property  name="stage"
	 * @uml.associationEnd  
	 */
	private Stage stage;
	
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
