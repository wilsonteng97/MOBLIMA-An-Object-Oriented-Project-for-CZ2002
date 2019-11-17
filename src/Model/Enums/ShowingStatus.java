package Model.Enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum ShowingStatus classifies the movie based on its current availability in the cineplex.
 */
public enum ShowingStatus {
	
	 /** The movie is coming soon. */
	 COMING_SOON("COMING_SOON"), 
	 /** The movie is on preview. */
	 PREVIEW("PREVIEW"), 
	 /** The movie is now showing. */
	 NOW_SHOWING("NOW_SHOWING"), 
	 /** The movie is no longer available. */
	 NO_LONGER_AVAILABLE("NO_LONGER_AVAILABLE");

	/** The string to identify the showing status. */
	private String string;
	
	/**
	 * Instantiates a new showing status in string.
	 *
	 * @param string the string
	 */
	ShowingStatus(String string)
	{
		this.string = string;
	}

	/**
	 * Gets the showing status based on the string parameter.
	 *
	 * @param value the value
	 * @return the value showing status
	 */
	public static ShowingStatus getValueShowingStatus(String value)
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
