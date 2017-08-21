package controller;

import model.IModel;

/**
 * controller interface
 * 
 * @author Yuliya
 *
 */
public interface Controller {
	/**
	 * method for button pressure processing
	 * 
	 */
	public void OK();

	/**
	 * method for setting main model
	 * 
	 * @param mainModel
	 *            Main model
	 */
	public void setMainModel(IModel mainModel);

	/**
	 * method for setting component model
	 * 
	 * @param componentModel
	 *            component's model
	 */
	public void setComponentModel(IModel componentModel);

}
