package Model.Enums;

public enum MovieType {
	MOVIE3D("MOVIE3D"), DIGITAL("DIGITAL");
	
	private String string;
	MovieType(String string)
	{
		this.string = string;
	}

	public static MovieType getValue(String value)
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
