package Presenter;

import java.io.IOException;
import java.util.ArrayList;

import static Presenter.DataManager.*;
import static Presenter.Query.*;
import Model.Booking;
import Model.Customer;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingManager is used for booking of movie tickets.
 */
public class BookingManager {
    
    /** The Constant userBookingListFile is the txt file. */
    private final static String userBookingListFile = "datafiles/userBookingFile.txt";
    
    /** The user booking list. */
    private static ArrayList<Booking> userBookingList;

    /**
     * Instantiates a new booking manager.
     */
    public BookingManager(){
        
    }

    /**
     * Read booking listing from the txt file.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void readBookingListing() throws IOException {
        if (readDataFile_List(userBookingListFile) == null) 
        	userBookingList = new ArrayList<>();
        else userBookingList = (ArrayList<Booking>) readDataFile_List(userBookingListFile);
    }

    /**
     * Update booking listing.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void updateBookingListing() throws IOException{
        writeDataFile(userBookingList, userBookingListFile);
    }

    
    /**
     * Gets the booking history.
     *
     * @param customerName the customer name
     * @return the booking history
     */
    public static void getBookingHistory(Customer customerName){
    	
    	if (userBookingList == null || userBookingList.isEmpty()) {
            System.out.println("No history to show.");
        }
        else {
            for (Booking history : userBookingList) {
            	if (history.getCustomer() == customerName)
            		System.out.println(history);
            }
        }
    }
    
    /**
     * Adds into the booking list.
     *
     * @param history the history
     */
    public static void addBooking(Booking history) {
    	userBookingList.add(history);
        try {
			updateBookingListing();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}