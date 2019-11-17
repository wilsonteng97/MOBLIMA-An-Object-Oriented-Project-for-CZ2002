package Data_Initializer;

import Model.Admin;
import Model.Cinema;
import Model.CinemaOperator;
import Model.Movie;
import Model.Enums.CinemaClass;

import java.io.IOException;
import java.util.ArrayList;
import static Presenter.CinemaOperatorManager.*;
import Presenter.DataManager;

// TODO: Auto-generated Javadoc
/**
 * The Class CinemaListGenerator implements dummy records of cinemas to the system.
 */
public class CinemaListGenerator extends DataManager {
	
	/** The cinema list to add the cinema object. */
	static ArrayList<Cinema> cinema_list = new ArrayList<Cinema>();
	
    /**
     * Cinema list to be generated. The object is created based on the attributes in the constructor.
     * These cinemas are created for use in the system.
     * The cinema will require the cineplex details, hence getCinemaOperatorFromGenerator() is used to generate the cinema operator object.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void CinemaList() throws IOException 
    {
        CinemaOperator co1 = CinemaOperatorGenerator.getCinemaOperatorFromGenerator(0);
        Cinema g1 = new Cinema("1G", "Vivo City", CinemaClass.NORMAL, co1, 8.0);
        cinema_list.add(g1);
        addCinema(g1);

        Cinema g2 = new Cinema("2G", "Suntec City", CinemaClass.NORMAL, co1, 8.0);
        cinema_list.add(g2);
        addCinema(g2);

        Cinema g3 = new Cinema("3G", "Katong", CinemaClass.PLATINUM, co1, 12.0);
        cinema_list.add(g3);
        addCinema(g3);

        CinemaOperator co2 = CinemaOperatorGenerator.getCinemaOperatorFromGenerator(1);
        Cinema s1 = new Cinema("1S", "Lido", CinemaClass.NORMAL, co2, 9.0);
        cinema_list.add(s1);
        addCinema(s1);

        Cinema s2 = new Cinema("2S", "Seletar", CinemaClass.NORMAL, co2, 9.0);
        cinema_list.add(s2);
        addCinema(s2);

        Cinema s3 = new Cinema("3S", "WaterWay", CinemaClass.PLATINUM, co2, 11.0);
        cinema_list.add(s3);
        addCinema(s3);

        CinemaOperator co3 = CinemaOperatorGenerator.getCinemaOperatorFromGenerator(2);
        Cinema c1 = new Cinema("1C", "Jem", CinemaClass.NORMAL, co3, 11.0);
        cinema_list.add(c1);
        addCinema(c1);

        Cinema c2 = new Cinema("2C", "Parkway Paradise", CinemaClass.NORMAL, co3, 11.0);
        cinema_list.add(c2);
        addCinema(c2);

        Cinema c3 = new Cinema("3C", "West Mail", CinemaClass.PLATINUM, co3, 14.0);
        cinema_list.add(c3);
        addCinema(c3);

      //  String fileName = "datafiles\\cinemaListFile.txt";
      //  writeDataFile(cinema_list, fileName);

    }
    
    /**
     * Generates the cinema from the list of cinemas created so that other objects can use the cinema object created here.
     *
     * @param n the index of the list which the required objects want.
     * @return the cinema from the list
     */
    public static Cinema getCinemaFromGenerator(int n) {
		return cinema_list.get(n);
	}
}