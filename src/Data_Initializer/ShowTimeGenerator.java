package Data_Initializer;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Model.Cinema;
import Model.CinemaOperator;
import Model.Movie;
import Model.ShowTime;
import Model.Enums.CinemaClass;
import Presenter.CinemaOperatorManager;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowTimeGenerator implements dummy records of reviews to the system.
 */
public class ShowTimeGenerator {
	
	/**
	 * Showtimes to be generated. The object is created based on the attributes in the constructor.
	 * The showtimes are created for use in the system.
	 * As the showtime object require the movie and cinema objects, getMovieFromGenerator() and getCinemaFromGenerator() are called to fulfill the objects.
	 * @throws ParseException the parse exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void Showtimes() throws ParseException, IOException {
		ArrayList<ShowTime> showtimeList = new ArrayList<ShowTime>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
//		ShowTime(Cinema cinema, Movie movie, Date time)
		
		Movie m1 = MovieListGenerator.getMovieFromGenerator(0);
        Cinema c1 = CinemaListGenerator.getCinemaFromGenerator(0);
		String s1_time = "19/11/2019 08:00";
		java.util.Date s1_time_final = formatter.parse(s1_time);
		ShowTime s1 = new ShowTime(c1, m1, s1_time_final);
		showtimeList.add(s1);
		CinemaOperatorManager.addShowtime(s1);
		
		String s2_time = "19/11/2019 12:00";
		java.util.Date s2_time_final = formatter.parse(s2_time);
		ShowTime s2 = new ShowTime(c1, m1, s2_time_final);
		showtimeList.add(s2);
		CinemaOperatorManager.addShowtime(s2);
		
		String s3_time = "19/11/2019 16:00";
		java.util.Date s3_time_final = formatter.parse(s3_time);
		ShowTime s3 = new ShowTime(c1, m1, s3_time_final);
		showtimeList.add(s3);
		CinemaOperatorManager.addShowtime(s3);
		
		Movie m2 = MovieListGenerator.getMovieFromGenerator(1);
		Cinema c2 = CinemaListGenerator.getCinemaFromGenerator(1);
		String s4_time = "19/11/2019 09:00";
		java.util.Date s4_time_final = formatter.parse(s4_time);
		ShowTime s4 = new ShowTime(c2, m2, s4_time_final);
		showtimeList.add(s4);
		CinemaOperatorManager.addShowtime(s4);
		
	}
}
