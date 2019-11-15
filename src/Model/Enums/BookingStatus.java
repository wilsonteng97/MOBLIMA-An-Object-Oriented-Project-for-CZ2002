package Model.Enums;

public enum BookingStatus {

	ACCEPTED("ACCEPTED"), REJECTED("REJECTED"), PENDING("PENDING");
	private String string;
	BookingStatus(String string)
	{
		this.string = string;
	}

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