package Model.Enums;

public enum CinemaClass {
	NORMAL("NORMAL"), PLATINUM("PLATINUM");

	private String string;
	CinemaClass(String string)
	{
		this.string = string;
	}

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
