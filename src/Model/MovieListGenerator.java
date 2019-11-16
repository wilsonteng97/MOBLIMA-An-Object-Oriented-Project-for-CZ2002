package Model;

import java.io.IOException;
import java.util.ArrayList;
import Presenter.DataManager;


import Model.Movie;
import Model.Enums.AgeRestriction;
import Model.Enums.MovieType;
import Model.Enums.ShowingStatus;
import static Presenter.CinemaOperatorManager.*;
import static Presenter.DataManager.*;

public class MovieListGenerator extends DataManager {
	
	public static void MovieList() throws IOException {
		
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
		addMovie(m2);
		
		ArrayList<String> m3_cast = new ArrayList<String>();
		m3_cast.add("\r\n" + 
				"Kristen Stewart, Naomi Scott, Ella Balinska, Elizabeth Banks, Djimon Hounsou, Noah Centineo, Sam Claflin, Patrick Stewart");
		Movie m3 = new Movie("Charlie's Angels", Model.Enums.AgeRestriction.PG13, Model.Enums.MovieType.MOVIE3D, Model.Enums.ShowingStatus.NOW_SHOWING,
				"14-11-2019", "Elizabeth Banks", "119 minutes",
				"Director Elizabeth Banks takes the helm as the next generation of fearless Charlie Angels take flight. In Banks, Kristen Stewart, Naomi Scott, and Ella Balinska are working for the mysterious Charles Townsend, whose security and investigative agency has expanded internationally. With the world锟絪 smartest, bravest, and most highly trained women all over the globe, there are now teams of Angels guided by multiple Bosleys taking on the toughest jobs everywhere. The screenplay is by Elizabeth Banks from a story by Evan Spiliotopoulos and David Auburn.",
				false, m3_cast);
		list.add(m3);
		
		ArrayList<String> m4_cast = new ArrayList<String>();
		m4_cast.add("\r\n" + 
				"Tom Holland, Samuel L. Jackson, Jake Gyllenhaal, Marisa Tomei, Jon Favreau, Zendaya , Jacob Batalon, Tony Revolori");
		Movie m4 = new Movie("Spider-Man: Far From Home", Model.Enums.AgeRestriction.PG13, Model.Enums.MovieType.MOVIE3D, Model.Enums.ShowingStatus.NO_LONGER_AVAILABLE,
				"02-07-2019", "Jon Watts", "129 minutes",
				"Peter Parker's relaxing European vacation takes an unexpected turn when Nick Fury shows up in his hotel room to recruit him for a mission. The world is in danger as four massive elemental creatures -- each representing Earth, air, water and fire -- emerge from a hole torn in the universe. Parker soon finds himself donning the Spider-Man suit to help Fury and fellow superhero Mysterio stop the evil entities from wreaking havoc across the continent.",
				false, m4_cast);
		list.add(m4);
		
		ArrayList<String> m5_cast = new ArrayList<String>();
		m5_cast.add("\r\n" + 
				"Chloe Bennet, TenzNorgay Trainor, Albert Tsai, Eddie Izzard, Sarah Paulson, Tsai Chin, Michelle Wong");
		Movie m5 = new Movie("Abominable", Model.Enums.AgeRestriction.PG, Model.Enums.MovieType.DIGITAL, Model.Enums.ShowingStatus.NOW_SHOWING,
				"07-11-2019", "Jill Culton", "98 minutes",
				"Abominable” takes audiences on an epic 2,000-mile adventure from the streets of a Chinese city to the breathtaking Himalayan snowscapes. When teenage Yi (Chloe Bennet) encounters a young Yeti on the roof of her apartment building, she and her friends, Jin (Tenzing Norgay Trainor) and Peng (Albert Tsai), name him “Everest” and embark on an epic quest to reunite the magical creature with his family at the highest point on Earth.",
				false, m5_cast);
		list.add(m5);
		
		ArrayList<String> m6_cast = new ArrayList<String>();
		m6_cast.add("\r\n" + 
				"Chloe Bennet, TenzNorgay Trainor, Albert Tsai, Eddie Izzard, Sarah Paulson, Tsai Chin, Michelle Wong");
		Movie m6 = new Movie("Abominable", Model.Enums.AgeRestriction.PG, Model.Enums.MovieType.DIGITAL, Model.Enums.ShowingStatus.NOW_SHOWING,
				"07-11-2019", "Jill Culton", "98 minutes",
				"Abominable” takes audiences on an epic 2,000-mile adventure from the streets of a Chinese city to the breathtaking Himalayan snowscapes. When teenage Yi (Chloe Bennet) encounters a young Yeti on the roof of her apartment building, she and her friends, Jin (Tenzing Norgay Trainor) and Peng (Albert Tsai), name him “Everest” and embark on an epic quest to reunite the magical creature with his family at the highest point on Earth.",
				false, m6_cast);
		list.add(m6);
		
    String fileName = "datafiles\\movieListFile.txt";
		writeDataFile(list, fileName);
	}

}
