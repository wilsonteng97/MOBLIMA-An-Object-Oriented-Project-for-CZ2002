package Model;

import java.io.IOException;
import java.util.ArrayList;
import Presenter.DataManager;
import static Presenter.CinemaOperatorManager.*;

public class CinemaOperatorGenerator extends DataManager {
    
        public static void CinemaOperatorList() throws IOException
        {
            ArrayList<CinemaOperator> list = new ArrayList<CinemaOperator>();
            CinemaOperator c1 = new CinemaOperator(0, "Golden Village");
            list.add(c1);
            addCinemaOperator(c1);

            CinemaOperator c2 = new CinemaOperator(1, "Shaw");
            list.add(c2);
            addCinemaOperator(c2);

            CinemaOperator c3 = new CinemaOperator(2, "Cathay");
            list.add(c3);
            addCinemaOperator(c3);

     //       String fileName = "datafiles/cinemaOperatorListFile.txt";
      //      writeDataFile(list, fileName);
            
        }
    }
