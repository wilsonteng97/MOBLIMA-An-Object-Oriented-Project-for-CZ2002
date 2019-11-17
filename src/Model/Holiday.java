package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class Holiday.
 * This class contains the information on the holiday.
 * @version 1.0
 */
public class Holiday implements Serializable {
    
    /** The name of the holiday. */
    private String name;
    /** The date. */
    private Date date;
    /** The rate to charge the ticket price due to the holiday. */
    private double rate;

    /**
     * Instantiates a new holiday.
     *
     * @param name the name of holiday
     * @param date the date of holiday
     * @param rate the rate to charge
     */
    public Holiday(String name, Date date, double rate) {
        this.name = name;
        this.date = date;
        this.rate = rate;
    }

    /**
     * Gets the name of holiday.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
	 * Sets the name of holiday.
	 *
	 * @param name the name
	 */
	public void setName (String name) {
		this.name = name;
	}

    /**
     * Gets the date of holiday.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    
    /**
	 * Sets the date of holiday.
	 *
	 * @param date the date
	 */
	public void setDate (Date date) {
		this.date = date;
	}

    /**
     * Gets the rate to charge.
     *
     * @return the rate
     */
    public double getRate() {
        return rate;
    }
    
    /**
	 * Sets the rate to charge.
	 *
	 * @param rate the rate
	 */
	public void setRate (double rate) {
		this.rate = rate;
	}

    /**
     * Prints the detail of the charge price.
     *
     * @return the string
     */
    public String printDetail() {
        return ("Date      : " + formatTimeMMdd(date) + "\n" +
               "Price rate: " + rate);
    }

    /**
     * Prints the date.
     *
     * @return the string
     */
    public String toString() {
        return (name + " (" + formatTimeMMdd(date) + ")");
    }
    
    /**
     * Format the date object to string.
     *
     * @param date the date
     * @return the string
     */
    private String formatTimeMMdd(Date date) {
    	return new SimpleDateFormat("MMMM, dd").format(date);
    }
}
