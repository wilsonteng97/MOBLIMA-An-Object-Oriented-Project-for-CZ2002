package Presenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Presenter is used to perform menu related operations and converting string inputs to date.
 */
public class Presenter
{
    
    /**
     * Verify choice number.
     *
     * @param choice the choice
     * @param min the min
     * @param max the max
     * @return true, if successful
     */
    public static boolean verifyChoiceNumber(int choice, int min, int max)
    {
        if(choice < min || choice > max)
        {
            System.out.println("Incorrect input, please try again\n");
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * Pass choice string.
     *
     * @param string the string
     * @return the string
     */
    public static String passChoiceString(String... string)
    {
        for(String s: string)
        {
            System.out.println(s);
        }
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        return choice;
    }

    /**
     * Pass choice int.
     *
     * @param string the string
     * @return the int
     */
    public static int passChoiceInt(String... string)
    {
        for(String s: string)
        {
            System.out.println(s);
        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }

    /**
     * Prints the current menu.
     *
     * @param menu the menu
     */
    public static void printCurrentMenu(String... menu)
    {
        for(String m: menu)
        {
            System.out.println(m);
            
        }
    }

    /**
     * Format time date.
     *
     * @param date the date
     * @return the string
     */
    public static String formatTimeDate(Date date)
    {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(date);
    }

    /**
     * Parses the string to date.
     *
     * @param inputString the input string
     * @return the date
     */
    public static Date parseStringToDate(String... inputString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String stringDate = passChoiceString(inputString);
		try {
			Date showtimeIn = formatter.parse(stringDate);
			System.out.println(showtimeIn);
			return showtimeIn;
		} catch (ParseException e) {
			System.out.println("You input wrong format!");
		}
		return null;
	}
    
    /**
     * Parses the string to date DDMMYYYY format.
     *
     * @param inputString the input string
     * @return the date
     */
    public static Date parseStringToDate_ddMMyyyy(String... inputString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate = passChoiceString(inputString);
		try {
			Date showtimeIn = formatter.parse(stringDate);
			System.out.println(showtimeIn);
			return showtimeIn;
		} catch (ParseException e) {
			System.out.println("You input wrong format!");
		}
		return null;
	}
}