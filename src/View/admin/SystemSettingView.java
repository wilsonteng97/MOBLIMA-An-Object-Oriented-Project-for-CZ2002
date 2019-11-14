package View.admin;
import View.View;
import static Presenter.AdminManager.*;
import static Presenter.Presenter.*;
import java.util.Scanner;

public class SystemSettingView extends View{

	protected void starter()
	{
		displayMenu();
	}
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(1) Configure Ticket Price\n"
				+ "(2) Configure Holidays\n"
				+ "(3) Update Admin Account\n"
				+ "(4) Configure Top 5 Ranking by Rating\n"
				+ "(5) Configure Top 5 Ranking by Sales\n"
				+ "(6) Return\n");
		
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 6)) { 
			switch (choice) {
		        case 1:
		            setMoviePrice(); 
		            break;
		        case 2:
		            setHoliday();  
		            break;
		        case 3:
		        	updateAdminAccount();
		        	break;
		        case 4:
		        	getTop5RankingRating();
		        	break;
		        case 5:
		        	getTop5RankingSales();
		        	break;
				case 6:				
		        	break;
			}
		}
	}
}



