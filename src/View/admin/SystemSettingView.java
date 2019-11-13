package View.admin;
import View.View;
import Presenter.AdminManager;
import Presenter.CinemaOperatorManager;
import Presenter.Presenter;
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
		while (verifyChoiceNumber(choice, 1, 6)) { //[presenter: change passChoiceNumber() to boolean] done by KJ
			switch (choice) {
		        case 1:
		            setMoviePrice(); //[presenter: setPrice()] done by KJ
		            break;
		        case 2:
		            setHoliday(); //[presenter: setHoliday()] [model: Holiday class] presenter portion in AdminManager done by KJ
		            break;
		        case 3:
		        	AdminManager.updateAdminAccount();
		        	break;
		        case 4:
		        	AdminManager.getTop5RankingRating();
		        	break;
		        case 5:
		        	AdminManager.getTop5RankingSales();
		        	break;
				case 6:
				
		        	break;
			}
		}
	}
}



