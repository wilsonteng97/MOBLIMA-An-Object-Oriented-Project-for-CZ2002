package Data_Initializer;

import java.io.IOException;
import java.util.ArrayList;

import Model.Cinema;
import Model.CinemaOperator;
import Presenter.DataManager;
import static Presenter.CinemaOperatorManager.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CinemaOperatorGenerator implements dummy records of cinema operators to the system.
 */
public class CinemaOperatorGenerator extends DataManager {
	
	/** The cinema operator list to add the cinema operator object. */
	static ArrayList<CinemaOperator> list = new ArrayList<CinemaOperator>();
    
        /**
         * Cinema operator list to be generated. The object is created based on the attributes in the constructor.
         * The cinema operators are created for use in the system.
         * @throws IOException Signals that an I/O exception has occurred.
         */
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
        
        /**
         * Generates the cinema operator from the list of cinema operator created so that other objects can use the cinema operator object created here.
         *
         * @param n the index of the list which the required objects want.
         * @return the cinema operator from the list
         */
        public static CinemaOperator getCinemaOperatorFromGenerator(int n) {
    		return list.get(n);
    	}
    }