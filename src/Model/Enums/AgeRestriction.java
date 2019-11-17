package Model.Enums;

// TODO: Auto-generated Javadoc
/**
 * @version 1.0
 */
// The censorship rating below are taken from IMDA's web-site:
// https://imdaonline.imda.gov.sg/classification/Search/Film/

// G (General) Suitable for all ages.
// PG (Parental Guidance) Suitable for all, but parents should guide their young.
// PG13 (Parental Guidance 13) Suitable for persons aged 13 and above but parental guidance is advised for children below 13.
// NC16 (No Children under 16) Suitable for persons aged 16 and above.
// M18 (Mature 18) Suitable for persons aged 18 and above.
// R21 (Restricted 21) Restricted to persons aged 21 and above
// NAR (not allowed for all ratings) In exceptional cases, a film may not be allowed for all ratings (NAR) when the content of the film undermines national interest or erodes the moral fabric of society. This includes themes that promote issues that denigrate any race or religion, or undermine national interest, language that denigrates religion or is religiously profane, real sexual activities (e.g. actual penetration, actual ejaculation), content deemed to be pornographic or obscene in nature, explicit promotion and normalisation of homosexual lifestyle, explicit homosexual activity, materials glorifying or encouraging drug and substance abuse and detailed or gratuitous depictions of extreme violence or cruelty. Films classified as 'NAR' in Singapore are banned and cannot be legally sold, rented, possessed, imported or made public in any format in Singapore, punishable by fines and/or imprisonment.

/**
 * The Enum AgeRestriction is based on IMDA's movie classification based on viewer's age.
 */
public enum AgeRestriction {
	
	 /** The g rating. */
	 G("G"), 
	 /** The pg rating. */
	 PG("PG"), 
	 /** The pg13 rating. */
	 PG13("PG13"), 
	 /** The nc16 rating. */
	 NC16("NC16"), 
	 /** The m18 rating. */
	 M18("M18"), 
	 /** The r21 rating. */
	 R21("R21"), 
	 /** The nar rating. */
	 NAR("NAR");

	/** The string to identify the classification in string. */
	private String string;
	
	/**
	 * Instantiates a new age restriction classification in string.
	 *
	 * @param string the string
	 */
	AgeRestriction(String string)
	{
		this.string = string;
	}

	/**
	 * Gets the age restriction value based on the string parameter.
	 * @param value the value
	 * @return the value age restriction
	 */
	public static AgeRestriction getValueAgeRestriction(String value)
	{
		value = value.toUpperCase();
		if(value.equals("G"))
		{
			return G;
		}
		else if(value.equals("PG"))
        {
            return PG13;
        }
        else if(value.equals("NC16"))
        {
            return NC16;
        }
        else if(value.equals("M18"))
        {
            return M18;
        }
        else if(value.equals("R21"))
        {
            return R21;
        }
        else if(value.equals("NAR"))
        {
            return NAR;
        }
        else 
        {
            return null;
        }
	}
	
}