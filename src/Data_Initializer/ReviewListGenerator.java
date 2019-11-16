package Data_Initializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Customer;
import Model.Review;

public class ReviewListGenerator {
	public void ReviewList() throws ParseException {
		ArrayList<Review> review_list = new ArrayList<Review>();
		
//		Review (Integer rating, String comment, Date date, Customer customer)
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		
		String c1_date = "10-11-2019";
		Date date_c1 = formatter.parse(c1_date);
		Customer cust1 = UserAccountListGenerator.getCustomerFromGenerator(0);
		Review r1 = new Review(4, "Joker is brutal, dark and a compelling origin story of a man's painful journey to self destruction.",
				date_c1, cust1);
		review_list.add(r1);
		
		String c2_date = "11-11-2019";
		Date date_c2 = formatter.parse(c2_date);
		Customer cust2 = UserAccountListGenerator.getCustomerFromGenerator(1);
		Review r2 = new Review(3, "Interesting movie with lots of twists and turns. Recommend all to watch!",
				date_c2, cust2);
		review_list.add(r2);
		
		String c3_date = "10-11-2019";
		Date date_c3 = formatter.parse(c3_date);
		Customer cust3 = UserAccountListGenerator.getCustomerFromGenerator(2);
		Review r3 = new Review(2, "Joker is a scary film, not advisable if you fear violence.",
				date_c3, cust3);
		review_list.add(r3);
		
	}
}