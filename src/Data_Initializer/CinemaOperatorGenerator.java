package Data_Initializer;

import java.io.IOException;
import java.util.ArrayList;

import Model.Cinema;
import Model.CinemaOperator;
import Presenter.DataManager;
import static Presenter.CinemaOperatorManager.*;

public class CinemaOperatorGenerator extends DataManager {
	
	static ArrayList<CinemaOperator> list = new ArrayList<CinemaOperator>();
    
        public static void CinemaOperatorList() throws IOException
        {
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
        
        public static CinemaOperator getCinemaOperatorFromGenerator(int n) {
    		return list.get(n);
    	}
    }
