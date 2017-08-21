package fwk;

import java.lang.reflect.Proxy;

import model.*;
import view.GUI;

/**
 * This client's class initializes objects of models, ControllerFactory and view
 * 
 * @author Yuliya
 *
 */
public class MVC {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creating models
		MainModel model = new MainModel();
		TextFieldModel textModel = new TextFieldModel(); // <- DB поля 1 2 3
		// creating model proxy object to prevent data lost
		IModel modelproxy = (IModel) Proxy.newProxyInstance(MainModel.class.getClassLoader(),
				MainModel.class.getInterfaces(), new ModelInvocationHandler(model));
		System.out.println(modelproxy.getData());
		// creating ControllerFactory object
		ControllerFactory factory = ControllerFactory.getFactory();
		// set models to factory
		factory.setModel(model, textModel);
		// creating view object
		GUI gui = new GUI(modelproxy, textModel);
		// starting view
		gui.printGUI();
	}
}
