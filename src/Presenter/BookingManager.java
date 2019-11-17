package Presenter;

import java.io.IOException;
import java.util.ArrayList;

import static Presenter.DataManager.*;
import static Presenter.Query.*;
import Model.Booking;
import Model.Customer;

public class BookingManager {
    private final static String userBookingListFile = "datafiles/userBookingFile.txt";
    private static ArrayList<Booking> userBookingList;

    public BookingManager(){
        
    }

    public static void readBookingListing() throws IOException {
        if (readDataFile_List(userBookingListFile) == null) 
        	userBookingList = new ArrayList<>();
        else userBookingList = (ArrayList<Booking>) readDataFile_List(userBookingListFile);
    }

    public static void updateBookingListing() throws IOException{
        writeDataFile(userBookingList, userBookingListFile);
    }

    
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
    
    public static void addBooking(Booking history) {
    	userBookingList.add(history);
        try {
			updateBookingListing();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}