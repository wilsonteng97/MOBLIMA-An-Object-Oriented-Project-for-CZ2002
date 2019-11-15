package Model.Enums;

public enum ShowingStatus {
	COMING_SOON("COMING_SOON"), PREVIEW("PREVIEW"), NOW_SHOWING("NOW_SHOWING"), NO_LONGER_AVAILABLE("NO_LONGER_AVAILABLE");

	private String string;
	ShowingStatus(String string)
	{
		this.string = string;
	}

	public static ShowingStatus getValue(String value)
	{
		value = value.toUpperCase();
		if(value.equals("COMING_SOON"))
		{
			return COMING_SOON;
		}
		else if(value.equals("PREVIEW"))
		{
			return PREVIEW;
		}
		else if(value.equals("NOW_SHOWING"))
		{
			return NOW_SHOWING;
		}
		else if(value.equals("NO_LONGER_AVAILABLE"))
		{
			return NO_LONGER_AVAILABLE;
		}
		else 
		{
			return null;
		}
	}
}
