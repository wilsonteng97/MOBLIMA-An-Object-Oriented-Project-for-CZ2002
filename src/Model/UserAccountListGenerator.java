package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserAccountListGenerator {
	public static ArrayList<Customer> CustomerList() throws ParseException {
		ArrayList<Customer> cust_list = new ArrayList<Customer>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		
//		Customer(int customerID, String name, String mobile, String email, Date DOB, String password)
		
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
		
		return cust_list;
	}
}
