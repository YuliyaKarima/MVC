package fwk;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores Map object for pair view - controller
 * 
 * @author Yuliya
 *
 */
public class ViewControllerMapping {
	// Stores pair view - controller
	private Map<String, String> mapping = new HashMap<String, String>();

	/**
	 * Method for retrieving Map from an object of this class
	 * 
	 * @return Map object
	 */
	public Map<String, String> getMapping() {
		return mapping;
	}

	/**
	 * Method sets value for mapping
	 * 
	 * @param a_mapping
	 *            - Map object of pair view - controller
	 */
	public void setMapping(Map<String, String> a_mapping) {
		mapping = a_mapping;
	}
}
