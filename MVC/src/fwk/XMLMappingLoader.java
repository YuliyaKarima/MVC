package fwk;

import java.util.HashMap;
import java.util.Map;
import org.exolab.castor.xml.*;
import java.io.*;

/**
 * Class for binding view class with controller class
 * 
 * @author Yuliya
 */
public class XMLMappingLoader {

	// map for storing pair "view's class- controller's class"

	private Map<Class<?>, Class<?>> map;

	/**
	 * Private constructor for creating Singleton object
	 */
	private XMLMappingLoader() {
		map = new HashMap<Class<?>, Class<?>>();

	}

	/**
	 * Static method returns singleton object of this class
	 * 
	 * @return Singleton object of this class
	 */
	public static XMLMappingLoader getLoader() {
		return SingletonHolder.instance;
	}

	/**
	 * Internal class for storing Singleton object of class XMLMappingLoader
	 * 
	 * @author Yuliya
	 *
	 */
	private static class SingletonHolder {
		public static final XMLMappingLoader instance = new XMLMappingLoader();
	}

	/**
	 * Return controller's class by matching with view's class. If view's class
	 * is already exists in field map as map's key then retrieve controller's
	 * class from it. Else if view's class is not in the map then loads xml file
	 * on the disk. If even after file loading controller's class not found then
	 * throws exception and terminates the application
	 * 
	 * @param view_class
	 *            class of the view
	 * @return return class of the controller
	 */
	public Class<?> getControllerClass(Class<?> view_class) {
		if (map.containsKey(view_class))
			// return controller's class from HashMap
			return map.get(view_class);
		else
			// if HashMap doesn't contain this pair "view - controller" then
			// look for mapping from file
			try {
				return getControllerClassByMapping(view_class);
			} catch (ControllerNotFoudException e) {
				System.out.println("Controller's class not found in the file " + e.getFileName());
				return null;
			}
	}

	/**
	 * Loads xml file for matching view's class with controller's class using
	 * Castor Framework. Throws ControllerNotFoudException when loaded file
	 * doesn't contains view's class as key
	 * 
	 * @param view_class
	 *            class of the view
	 * @return return class of the controller from a file on a disk
	 */
	public Class<?> getControllerClassByMapping(Class<?> view_class) throws ControllerNotFoudException {
		// using object of class ViewControllerMapping that contains HashMap of
		// pair view's name - controller's name
		ViewControllerMapping mappingUnmarshal;
		String controller_class_name = null;
		Class<?> controller_class = null;
		File file = new File("D:/mapping.xml");
		try {
			FileReader reader = new FileReader(file);
			/// using Castor FWK to load object which contain HashMap for pairs
			// view's name - controller's name
			mappingUnmarshal = (ViewControllerMapping) Unmarshaller.unmarshal(ViewControllerMapping.class, reader);
			Map<String, String> unmarsh = mappingUnmarshal.getMapping();
			controller_class_name = unmarsh.get(view_class.getName());
			if (controller_class_name != null) {
				// creating controller's class by name using reflection
				controller_class = Class.forName(controller_class_name);
				// put this pair of view'class - controller's class in map
				map.put(view_class, controller_class);
			} else
				// if controller's class haven't been found in this file then
				// throws exception
				throw new ControllerNotFoudException(file.getName());
		} catch (FileNotFoundException | MarshalException | ValidationException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return controller_class;

	}

}
