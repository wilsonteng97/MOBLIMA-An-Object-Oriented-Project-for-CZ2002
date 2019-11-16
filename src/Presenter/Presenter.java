package Presenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Presenter
{
    public static boolean verifyChoiceNumber(int choice, int min, int max)
    {
        if(choice < min || choice > max)
        {
            System.out.println("Incorrect input, please try again\n");
            //verifyChoiceNumber(choice, min, max);
            return false;
        }
        else
        {
            return true;
        }
    }
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

    public static void printCurrentMenu(String... menu)
    {
        for(String m: menu)
        {
            System.out.println(m);
            
        }
    }

    public static String formatTimeDate(Date date)
    {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(date);
    }

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