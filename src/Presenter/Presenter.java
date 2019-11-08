import java.text.SimpleDateFormat;
import java.util.Scanner;
package Presenter;

public class Presenter
{
    public static int passChoiceNumber(int min, int max)
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        choice = sc.nextInt();
        if(choice < min || choice > max)
        {
            System.out.println("Incorrect input, please try again");
            return passChoice(min, max);
        }
        else
        {
            return choice;
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
}