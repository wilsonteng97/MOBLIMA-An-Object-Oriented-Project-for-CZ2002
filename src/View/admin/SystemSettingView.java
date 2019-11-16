package View.admin;

import View.View;
import static Presenter.AdminManager.*;
import static Presenter.Presenter.*;

import java.util.Scanner;

public class SystemSettingView extends View{
	
	Scanner sc = new Scanner(System.in);

	protected void starter()
	{
		displayMenu();
	}
	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
  System.out.println("System Setting");
		System.out.println();
		System.out.println("(1) Configure Holidays\n"
							+ "(2) Update Admin Account\n"
							+ "(3) Configure Top 5 Ranking by Rating\n"
							+ "(4) Configure Top 5 Ranking by Sales\n"
							+ "(5) Return\n");
		System.out.println();
		System.out.println("Enter the number of your choice: ");
		// if(cinema.getStatus == PLATINUM)
		// {
		// 	price = price * 1.2;
		// }
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 5)) { 
			switch (choice) {
		        case 1:
		            setHoliday();  
		            break;
		        case 2:
		        	updateAdminAccount();
		        	break;
		        case 3:
		        	getTop5RankingRating();
		        	break;
		        case 4:
		        	getTop5RankingSales();
		        	break;
				case 5:				
		        	break;
			}
		}
	}
	private void setMoviePrice() {
		passChoiceString("Enter movie:");
		
		passChoiceString("Enter base price:");
	}
}



