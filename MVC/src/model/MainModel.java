package model;

/**
 * Implementation of IModel
 * 
 * @author Yuliya
 *
 */
public class MainModel implements IModel {
	// model's data
	private String data;

	/**
	 * Constructor sets default data
	 */
	public MainModel() {
		data = "Text";
	}

	/**
	 * Retrieves model's data
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets model's data
	 */
	public void setData(String a_data) {
		data = a_data;
		System.out.println(data);
	}

}
