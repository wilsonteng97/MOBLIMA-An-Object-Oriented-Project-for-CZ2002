package Data_Initializer;

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
//		m1.addTotalSales(1500);
		list.add(m1);
		addMovie(m1);

		ArrayList<String> m2_cast = new ArrayList<String>();
		m2_cast.add("Yann Yann Yeo, Koh Jia Ler, Christopher Lee, Yang Shi Bin");
		Movie m2 = new Movie("Wet Season", Model.Enums.AgeRestriction.M18, Model.Enums.MovieType.DIGITAL, Model.Enums.ShowingStatus.COMING_SOON,
				"28-11-2019", "Anthony Chen", "103 minutes",
				"In the film, a teacher and a student in a Singapore secondary school form a special, self-affirming relationship.",
				true, m2_cast);
//		m2.addTotalSales(0);
		list.add(m2);
    	addMovie(m2);
		
		ArrayList<String> m3_cast = new ArrayList<String>();
		m3_cast.add("Kristen Stewart, Naomi Scott, Ella Balinska, Elizabeth Banks, Djimon Hounsou, Noah Centineo, Sam Claflin, Patrick Stewart");
		Movie m3 = new Movie("Charlie's Angels", Model.Enums.AgeRestriction.PG13, Model.Enums.MovieType.MOVIE3D, Model.Enums.ShowingStatus.NOW_SHOWING,
				"14-11-2019", "Elizabeth Banks", "119 minutes",
				"Director Elizabeth Banks takes the helm as the next generation of fearless Charlie Angels take flight. In Banks, Kristen Stewart, Naomi Scott, and Ella Balinska are working for the mysterious Charles Townsend, whose security and investigative agency has expanded internationally. With the worldé”Ÿçµª smartest, bravest, and most highly trained women all over the globe, there are now teams of Angels guided by multiple Bosleys taking on the toughest jobs everywhere. The screenplay is by Elizabeth Banks from a story by Evan Spiliotopoulos and David Auburn.",
				false, m3_cast);
//		m3.addTotalSales(1086);
		list.add(m3);
		addMovie(m3);

		ArrayList<String> m4_cast = new ArrayList<String>();
		m4_cast.add("Tom Holland, Samuel L. Jackson, Jake Gyllenhaal, Marisa Tomei, Jon Favreau, Zendaya , Jacob Batalon, Tony Revolori");
		Movie m4 = new Movie("Spider-Man: Far From Home", Model.Enums.AgeRestriction.PG13, Model.Enums.MovieType.MOVIE3D, Model.Enums.ShowingStatus.NO_LONGER_AVAILABLE,
				"02-07-2019", "Jon Watts", "129 minutes",
				"Peter Parker's relaxing European vacation takes an unexpected turn when Nick Fury shows up in his hotel room to recruit him for a mission. The world is in danger as four massive elemental creatures -- each representing Earth, air, water and fire -- emerge from a hole torn in the universe. Parker soon finds himself donning the Spider-Man suit to help Fury and fellow superhero Mysterio stop the evil entities from wreaking havoc across the continent.",
				false, m4_cast);
		m4.addTotalSales(2486);
		list.add(m4);
		addMovie(m4);

		ArrayList<String> m5_cast = new ArrayList<String>();
		m5_cast.add("Chloe Bennet, TenzNorgay Trainor, Albert Tsai, Eddie Izzard, Sarah Paulson, Tsai Chin, Michelle Wong");
		Movie m5 = new Movie("Abominable", Model.Enums.AgeRestriction.PG, Model.Enums.MovieType.DIGITAL, Model.Enums.ShowingStatus.NOW_SHOWING,
				"07-11-2019", "Jill Culton", "98 minutes",
				"Abominable takes audiences on an epic 2,000-mile adventure from the streets of a Chinese city to the breathtaking Himalayan snowscapes. When teenage Yi (Chloe Bennet) encounters a young Yeti on the roof of her apartment building, she and her friends, Jin (Tenzing Norgay Trainor) and Peng (Albert Tsai), name him â€œEverestâ€� and embark on an epic quest to reunite the magical creature with his family at the highest point on Earth.",
				false, m5_cast);
		m5.addTotalSales(1026);
		list.add(m5);
		addMovie(m5);

		ArrayList<String> m6_cast = new ArrayList<String>();
		m6_cast.add("Hairul Azreen, Fify Azmi, Hilal Azman, Ismi Melinda, Henley Hii, Dain Iskandar Said, Josiah Hogan, Yayan Ruhian");
		Movie m6 = new Movie("Wira", Model.Enums.AgeRestriction.PG13, Model.Enums.MovieType.DIGITAL, Model.Enums.ShowingStatus.COMING_SOON,
				"21-11-2019", "Adrian Teh", "109 minutes",
				"Hassan (Hairul Azreen) left his family since he was younger. He became military man to overcome his demon and to get away from the injustice towards his family and community committed by Raja (Dain Iskandar). After his stint in the army Hassan returns to help his family with a debt owed by his sister Zain (Fify Azmi) by fighting in a MMA match. Hassan and Zain had to go against Vee (Ismi Melinda) and Rayyan (Josiah Hogan) who are Rajaâ€™s children. Can they go against all odds to win the fight and would Hassan be able to save his family and community?",

				false, m6_cast);
		m5.addTotalSales(0);
		list.add(m6);
		addMovie(m6);

   // String fileName = "datafiles\\movieListFile.txt";

   // String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\movieListFile.txt";
		
	//	writeDataFile(list, fileName);
	}

}
