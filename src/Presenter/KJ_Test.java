package Presenter;

import java.io.*;
import java.util.ArrayList;

import Model.Movie;
import Model.Enums.*;
import Presenter.DataManager;

public class KJ_Test {
    public static void main(String [] arg) throws IOException{
//        ArrayList<String> m1_cast = new ArrayList<String>();
//        m1_cast.add("Joaquin Phoenix, Robert De Niro, Zazie Beetz, Bill Camp, Frances Conroy, Brett Cullen, Glenn Fleshler, Douglas Hodge");

//        ArrayList<Movie> lister = new ArrayList<Movie>();
//        Movie m1 = new Movie("Joker", Model.Enums.AgeRestriction.NC16, Model.Enums.MovieType.DIGITAL, Model.Enums.ShowingStatus.NOW_SHOWING, "03-10-2019", "Todd Phillips", "122 minutes",
//        "Forever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City. He becomes a psychopathic murderer.",
//        true, m1_cast);
//        
//        lister.add(m1);
//        DataManager.writeMovieFile(lister);
        DataManager.readMovieFile();
    }
}