package Model.Enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum MovieTyp which classifies the screening type of the film, whether it is in 3 dimensional or digital format.
 */
public enum MovieType {
	
	 /** The 3D movie screening type. */
	 MOVIE3D("MOVIE3D"), 
	 /** The digital screening type. */
	 DIGITAL("DIGITAL");
	
	/** The string to identify the movie type. */
	private String string;
	
	/**
	 * Instantiates a new movie type in string.
	 *
	 * @param string the string
	 */
	MovieType(String string)
	{
		this.string = string;
	}

	/**
	 * Gets the movie type based on the string parameter.
	 *
	 * @param value the value
	 * @return the value movie type
	 */
	public static MovieType getValueMovieType(String value)
	{
		value = value.toUpperCase();
		if(value.equals("MOVIE3D"))
		{
			return MOVIE3D;
		}
		else if(value.equals("DIGITAL"))
		{
			return DIGITAL;
		}
		else 
		{
			return null;
		}
	}
}
