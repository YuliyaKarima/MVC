package view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import events.EventHandler;
import events.FocusHandler;
import fwk.TextFieldModel;
import model.*;

/**
 * View class Extends JFrame
 * 
 * @author Yuliya
 *
 */
public class GUI extends JFrame {
	// view's components
	private JTextField text;
	private JButton button;
	// view's model
	private IModel model;
	// component's model
	private TextFieldModel textModel;

	/**
	 * Constructor sets main model of the application and component's model
	 * 
	 * @param a_model
	 *            Main model of the application
	 * @param a_textFieldModel
	 *            Component's model
	 */
	public GUI(IModel a_model, TextFieldModel a_textFieldModel) {
		model = a_model;
		textModel = a_textFieldModel;
	}

	/**
	 * Method initializes view's components and add them to view Set view's size
	 * and visible parameter
	 */

	public void printGUI() {
		setLayout(new GridLayout(2, 1));
		text = new MyJTextField(textModel);
		text.addFocusListener(new FocusHandler());
		button = new JButton("OK");
		button.addActionListener(new EventHandler());
		add(text);
		add(button);
		text.setText(model.getData());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100, 100);
		setVisible(true);
	}
}
