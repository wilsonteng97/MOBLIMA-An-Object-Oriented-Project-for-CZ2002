package Model.Enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum BookingStatus is based on whether the booking made by the customer is accepted, rejected or on pending.
 */
public enum BookingStatus {

	/** The booking has been accepted. */
	ACCEPTED("ACCEPTED"), 
	/** The booking has been rejected. */
	REJECTED("REJECTED"), 
	/** The booking is pending. */
	PENDING("PENDING");
	
	/** The string to identify the booking status. */
	private String string;
	
	/**
	 * Instantiates a new booking status in string.
	 *
	 * @param string the string
	 */
	BookingStatus(String string)
	{
		this.string = string;
	}

	/**
	 * Gets the booking status based on the string parameter.
	 *
	 * @param value the value
	 * @return the value booking status
	 */
	public static BookingStatus getValueBookingStatus(String value)
	{
		value = value.toUpperCase();
		if(value.equals("ACCEPTED"))
		{
			return ACCEPTED;
		}
		else if(value.equals("REJECTED"))
		{
			return REJECTED;
		}
		else if(value.equals("PENDING"))
		{
			return PENDING;
		}
		else 
		{
			return null;
		}
	}
}