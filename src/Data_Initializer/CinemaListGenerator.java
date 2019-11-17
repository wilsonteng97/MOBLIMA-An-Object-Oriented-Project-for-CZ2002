package Data_Initializer;

import Model.Admin;
import Model.Cinema;
import Model.Enums.CinemaClass;

import java.io.IOException;
import java.util.ArrayList;
import static Presenter.CinemaOperatorManager.*;
import Presenter.DataManager;


public class CinemaListGenerator extends DataManager {
    public static void CinemaList() throws IOException 
    {
        ArrayList<Cinema> cinema_list = new ArrayList<Cinema>();
        Cinema g1 = new Cinema("1G", "Vivo City", CinemaClass.NORMAL, getCinemaOperators().get(0), 8.0);
        cinema_list.add(g1);
        addCinema(g1);

        Cinema g2 = new Cinema("2G", "Suntec City", CinemaClass.NORMAL, getCinemaOperators().get(0), 8.0);
        cinema_list.add(g2);
        addCinema(g2);

        Cinema g3 = new Cinema("3G", "Katong", CinemaClass.PLATINUM, getCinemaOperators().get(0), 12.0);
        cinema_list.add(g3);
        addCinema(g3);

        Cinema s1 = new Cinema("1S", "Lido", CinemaClass.NORMAL, getCinemaOperators().get(1), 9.0);
        cinema_list.add(s1);
        addCinema(s1);

        Cinema s2 = new Cinema("2S", "Seletar", CinemaClass.NORMAL, getCinemaOperators().get(1), 9.0);
        cinema_list.add(s2);
        addCinema(s2);

        Cinema s3 = new Cinema("3S", "WaterWay", CinemaClass.PLATINUM, getCinemaOperators().get(1), 11.0);
        cinema_list.add(s3);
        addCinema(s3);

        Cinema c1 = new Cinema("1C", "Jem", CinemaClass.NORMAL, getCinemaOperators().get(2), 11.0);
        cinema_list.add(c1);
        addCinema(c1);

        Cinema c2 = new Cinema("2C", "Parkway Paradise", CinemaClass.NORMAL, getCinemaOperators().get(2), 11.0);
        cinema_list.add(c2);
        addCinema(c2);

        Cinema c3 = new Cinema("3C", "West Mail", CinemaClass.PLATINUM, getCinemaOperators().get(2), 14.0);
        cinema_list.add(c3);
        addCinema(c3);

      //  String fileName = "datafiles\\cinemaListFile.txt";
      //  writeDataFile(cinema_list, fileName);

    }
}