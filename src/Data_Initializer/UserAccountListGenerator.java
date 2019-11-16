package Data_Initializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Customer;

public class UserAccountListGenerator {
	
	static ArrayList<Customer> cust_list = new ArrayList<Customer>();
	
	public static ArrayList<Customer> CustomerList() throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		
//		Customer(int customerID, String name, String mobile, String email, Date DOB, String password, boolean isSenior)
		
		String c1_dob = "14-05-1994";
		Date date_c1 = formatter.parse(c1_dob);
		Customer c1 = new Customer((int)Math.random()*10000, "May Tan", "98741526", "may@july.com", date_c1, "may12345");
		cust_list.add(c1);
		
		String c2_dob = "22-11-1949";
		Date date_c2 = formatter.parse(c2_dob);
		Customer c2 = new Customer((int)Math.random()*10000, "Lau Wong Kin", "91428523", "old_man@email.com", date_c2, "madeIn1949");
		cust_list.add(c2);
		
		String c3_dob = "14-07-1986";
		Date date_c3 = formatter.parse(c3_dob);
		Customer c3 = new Customer((int)Math.random()*10000, "Shirley Tan", "86951236", "shirley@email.com", date_c3, "shirley86");
		cust_list.add(c3);
		
		String c4_dob = "14-06-1996";
		Date date_c4 = formatter.parse(c4_dob);
		Customer c4 = new Customer((int)Math.random()*10000, "Sarah Lim", "91741526", "sarah@email.com", date_c4, "sarah2345");
		cust_list.add(c4);
		
		String c5_dob = "22-01-1947";
		Date date_c5 = formatter.parse(c5_dob);
		Customer c5 = new Customer((int)Math.random()*10000, "Jean Lee", "91488523", "jean@email.com", date_c5, "jean949");
		cust_list.add(c5);
		
		String c6_dob = "14-07-1986";
		Date date_c6 = formatter.parse(c6_dob);
		Customer c6 = new Customer((int)Math.random()*10000, "Alex Wong", "86921236", "alex@email.com", date_c6, "alex186");
		cust_list.add(c6);
		
		return cust_list;
	}
	
	public static Customer getCustomerFromGenerator(int n) {
		return cust_list.get(n);
	}
}
