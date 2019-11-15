package Model.Enums;

public enum TicketType {
	NORMAL("NORMAL"), STUDENT("STUDENT"), SENIOR_CITIZEN("SENIOR_CITIZEN");

	private String string;
	TicketType(String string)
	{
		this.string = string;
	}

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
