package fwk;

import controller.*;
import model.*;

/**
 * Ñlass for creating controller object
 * 
 * @author Yuliya
 */
public class ControllerFactory {
	// using pattern Singleton
	private static ControllerFactory factory;
	// we use references to model to pass them to controller's constructor
	private MainModel model;
	private TextFieldModel textmodel;
	private Controller controller;

	/**
	 * Private constructor for creating Singleton object
	 */
	private ControllerFactory() {
		controller = null;
	}

	/**
	 * Static method that returns single object of this class
	 * 
	 * @return single object of the factory
	 */
	public static ControllerFactory getFactory() {
		if (factory == null) {
			synchronized (ControllerFactory.class) {
				if (factory == null) {
					factory = new ControllerFactory();
				}
			}
		}
		return factory;
	}

	/**
	 * Method sets model to factory object that will be used for creating
	 * controller object
	 * 
	 * @param a_model
	 *            - the model
	 * @param a_textmodel
	 *            - model of the text field of the view
	 */
	public void setModel(MainModel a_model, TextFieldModel a_textmodel) {
		this.model = a_model;
		this.textmodel = a_textmodel;
	}

	/**
	 * If object of controller still not exists, creates it using reflection If
	 * object of controller is already exists, just returns it
	 * 
	 * @param controller_class
	 *            - controller class
	 * @return object of controller
	 */
	public Object getControllerObject(Class<?> controller_class) {
		// if object of controller still not exists, creates it using reflection
		if (controller == null) {
			try {
				// creating object using reflection
				controller = (Controller) controller_class.newInstance();
				// using setters to set models
				controller.setMainModel(model);
				controller.setComponentModel(textmodel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return controller;
		} else
			return controller;
		// if object of controller is already exists, just returns it
	}

}
