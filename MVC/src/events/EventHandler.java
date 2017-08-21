package events;

import java.lang.reflect.Method;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import fwk.ControllerFactory;
import fwk.XMLMappingLoader;

/**
 * Processing events from button of the view
 * 
 * @author Yuliya
 */
public class EventHandler implements ActionListener {
	// object of ControllerFactory for creating controller object
	ControllerFactory factory;
	// loads mapping of pair view - controller from xml file
	XMLMappingLoader loader = XMLMappingLoader.getLoader();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		factory = ControllerFactory.getFactory();
		// getting component that generated the event
		JButton comp = (JButton) e.getSource();
		// retrieve class of the view from object that generated the event
		Class<?> view_class = comp.getParent().getParent().getParent().getParent().getClass();
		String button_name = e.getActionCommand();
		// using reflection for getting controller class
		try {
			// getting controller class from manager by the view class
			Class<?> controller_class = loader.getControllerClass(view_class);
			Method method = controller_class.getMethod(button_name);
			// getting controller object from controller factory
			Object object = factory.getControllerObject(controller_class);
			// invoking controller method through reflection
			method.invoke(object);
		} catch (Exception ex2) {
			ex2.printStackTrace();
		}
	}
}
