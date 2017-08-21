package controller;

import java.util.*;

import fwk.TextFieldModel;
import model.IModel;
import model.MainModel;

/**
 * implementation of Controller
 */
public class MyController implements Controller {
	private IModel mainModel;
	private IModel textModel;

	/**
	 * default constructor
	 */
	public MyController() {

	}

	/**
	 * constructor for setting models
	 * 
	 * @param a_model
	 *            - model
	 * @param a_textModel
	 *            - model of text field from view
	 */
	public MyController(IModel a_model, TextFieldModel a_textModel) {
		mainModel = a_model;
		textModel = a_textModel;
	}

	/**
	 * sets main model
	 */
	public void setMainModel(IModel a_mainModel) {
		mainModel = a_mainModel;
	}

	/**
	 * set component model
	 */

	public void setComponentModel(IModel componentModel) {
		textModel = componentModel;
	}

	/**
	 * method for button pressure processing
	 */
	public void OK() {
		mainModel.setData(textModel.getData());
	}

}
