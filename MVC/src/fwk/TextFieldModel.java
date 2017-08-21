package fwk;

import model.IModel;

/**
 * Implementation of IModel for main model of this application
 * 
 * @author Yuliya
 *
 */
public class TextFieldModel implements IModel {
	// data of the model
	private String data;

	/**
	 * Constructor
	 */
	public TextFieldModel() {
		data = null;
	}

	/**
	 * Returns model's data
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets model's data
	 */
	public void setData(String a_data) {
		data = a_data;
		// System.out.println(data);
	}
}
