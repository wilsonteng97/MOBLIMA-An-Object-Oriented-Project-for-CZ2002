package Model;

import java.util.ArrayList;

import Model.Movie;
import Model.Enums.AgeRestriction;
import Model.Enums.MovieType;
import Model.Enums.ShowingStatus;

public class MovieListGenerator {
	
	public static ArrayList<Movie> MovieList() {
		
		ArrayList<Movie> list = new ArrayList<Movie>();
		
//		Movie(String title, AgeRestriction ageRestriction, MovieType type, ShowingStatus status, 
//		String opening, String director, String runtime, String synopsis, Boolean blockBuster, ArrayList<String> cast)
		
		ArrayList<String> m1_cast = new ArrayList<String>();
		m1_cast.add("Joaquin Phoenix, Robert De Niro, Zazie Beetz, Bill Camp, Frances Conroy, Brett Cullen, Glenn Fleshler, Douglas Hodge");
		Movie m1 = new Movie("Joker", Model.Enums.AgeRestriction.NC16, Model.Enums.MovieType.DIGITAL, Model.Enums.ShowingStatus.NOW_SHOWING,
				"03-10-2019", "Todd Phillips", "122 minutes",
				"A failed stand-up comedian is driven insane and becomes a psychopathic murderer.",
				true, m1_cast);
		list.add(m1);
		
		ArrayList<String> m2_cast = new ArrayList<String>();
		m2_cast.add("Yann Yann Yeo, Koh Jia Ler, Christopher Lee, Yang Shi Bin");
		Movie m2 = new Movie("Wet Season", Model.Enums.AgeRestriction.M18, Model.Enums.MovieType.DIGITAL, Model.Enums.ShowingStatus.COMING_SOON,
				"28-11-2019", "Anthony Chen", "103 minutes",
				"In the film, a teacher and a student in a Singapore secondary school form a special, self-affirming relationship.",
				true, m2_cast);
		list.add(m2);
		
		ArrayList<String> m3_cast = new ArrayList<String>();
		m3_cast.add("\r\n" + 
				"Kristen Stewart, Naomi Scott, Ella Balinska, Elizabeth Banks, Djimon Hounsou, Noah Centineo, Sam Claflin, Patrick Stewart");
		Movie m3 = new Movie("Charlie's Angels", Model.Enums.AgeRestriction.PG13, Model.Enums.MovieType.MOVIE3D, Model.Enums.ShowingStatus.NOW_SHOWING,
				"14-11-2019", "Elizabeth Banks", "119 minutes",
				"Director Elizabeth Banks takes the helm as the next generation of fearless Charlie’s Angels take flight. In Banks’ bold vision, Kristen Stewart, Naomi Scott, and Ella Balinska are working for the mysterious Charles Townsend, whose security and investigative agency has expanded internationally. With the world’s smartest, bravest, and most highly trained women all over the globe, there are now teams of Angels guided by multiple Bosleys taking on the toughest jobs everywhere. The screenplay is by Elizabeth Banks from a story by Evan Spiliotopoulos and David Auburn.",
				false, m3_cast);
		list.add(m3);
		
		return list;
	}

}
