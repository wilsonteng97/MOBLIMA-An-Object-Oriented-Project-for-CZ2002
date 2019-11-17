package Model.Enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum TicketType classifies the ticket price to be charged on the customer based on their age group.
 */
public enum TicketType {
	
	 /** The normal ticket price for adults. */
	 NORMAL("NORMAL"), 
	 /** The student ticket price. */
	 STUDENT("STUDENT"), 
	 /** The senior citizen ticket price. */
	 SENIOR_CITIZEN("SENIOR_CITIZEN");

	/** The string to identify the ticket type. */
	private String string;
	
	/**
	 * Instantiates a new ticket type in string.
	 *
	 * @param string the string
	 */
	TicketType(String string)
	{
		this.string = string;
	}

	/**
	 * Gets the ticket type based on the string parameter.
	 *
	 * @param value the value
	 * @return the value ticket type
	 */
	public static TicketType getValueTicketType(String value)
	{
		value = value.toUpperCase();
		if(value.equals("NORMAL"))
		{
			return NORMAL;
		}
		else if(value.equals("STUDENT"))
		{
			return STUDENT;
		}
		else if(value.equals("SENIOR_CITIZEN"))
		{
			return SENIOR_CITIZEN;
		}
		else 
		{
			return null;
		}
	}
}
