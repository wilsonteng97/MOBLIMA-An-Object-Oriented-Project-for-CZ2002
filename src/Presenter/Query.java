package Presenter;

import java.text.ParseException;

import javax.lang.model.util.ElementScanner6;

import Model.Enums.ShowingStatus;

public class Query
{
    public String passSearchMovieTime(String string)
    {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try
        {
            String input = passChoiceString(string);
            Date date = sim.parse(input);
            return date;
        }
        catch(ParseException e)
        {
            System.out.println("Error, incorrect format");
            return passSearchMovieTime(string);
        }
    }
    public static ShowingStatus passShowingStatus(String status)
    {
        status = status.toUpperCase();
        if(status == "COMING_SOON")
            return ShowingStatus.COMING_SOON;
        else if(status == "PREVIEW")
            return ShowingStatus.PREVIEW;
        else if(status == "NOW_SHOWING")
            return ShowingStatus.NOW_SHOWING;
        else if(status == "NO_LONGER_AVAILABLE")
            return ShowingStatus.NO_LONGER_AVAILABLE;
        else 
            return "Incorrect showing status";
    }

    public static AgeRestriction passAgeRestriction(String ageRestriction)
    {
        if(ageRestriction == "G")
            return G;
        else if(ageRestriction == "PG")
            return PG;
        else if(ageRestriction == "PG13")
            return PG13;
        else if(ageRestriction == "NC16")
            return NC16;
        else if(ageRestriction == "M18")
            return M18;
        else if(ageRestriction == "R21")
            return R21;
        else if(ageRestriction == "NAR")
            return NAR;
        else 
            return "Incorrect age restriction";
    }
}