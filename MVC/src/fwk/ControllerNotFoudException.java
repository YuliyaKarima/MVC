package fwk;

/**
 * This exception is being threw when controller's class has not been found
 * 
 * @author Yuliya
 */
public class ControllerNotFoudException extends Exception {
	// this field stores name of the file from which the controller's class name
	// is being loading

	private String fileName;

	public ControllerNotFoudException(String a_fileName) {
		super();
		fileName = a_fileName;
	}

	/**
	 * Method returns name of the file
	 * @return name of the file
	 */
	public String getFileName() {
		return fileName;
	}

}
