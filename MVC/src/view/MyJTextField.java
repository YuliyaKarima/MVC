package view;

import javax.swing.JTextField;

import fwk.TextFieldModel;

/**
 * Class extends JTextField for creating component with it's own model
 * 
 * @author Yuliya
 *
 */
public class MyJTextField extends JTextField {
	// component's model
	TextFieldModel model;

	/**
	 * Constructor sets component's model
	 * 
	 * @param model
	 *            component's model
	 */
	public MyJTextField(TextFieldModel model) {
		this.model = model;
	}

	/**
	 * Method sets data to component's model
	 */
	public void setDataToModel() {
		model.setData(this.getText());
		// System.out.println(model.getData());
	}

}
