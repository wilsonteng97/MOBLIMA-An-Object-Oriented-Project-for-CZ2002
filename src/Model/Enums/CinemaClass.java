package Model.Enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum CinemaClass classifies the type of cinema based on the cinema quality of service provided to the customer.
 * Normal type cinema is lower in service quality than Platinum type cinema.
 */
public enum CinemaClass {
	
	/** The normal type. */
	NORMAL("NORMAL"), 
    /** The platinum type. */
    PLATINUM("PLATINUM");

	/** The string to identify the cienam class. */
	private String string;
	
	/**
	 * Instantiates a new cinema type in string.
	 *
	 * @param string the string
	 */
	CinemaClass(String string)
	{
		this.string = string;
	}

	/**
	 * Gets the cinema class based on the string parameter.
	 *
	 * @param value the value
	 * @return the value cinema class
	 */
	public static CinemaClass getValueCinemaClass(String value)
	{
		value = value.toUpperCase();
		if(value.equals("NORMAL"))
		{
			return NORMAL;
		}
		else if(value.equals("PLATINUM"))
		{
			return PLATINUM;
		}
		else 
		{
			return null;
		}
	}
}
