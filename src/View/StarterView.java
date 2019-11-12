package View;
import java.util.Scanner;

public class StarterView extends View{
	public StarterView() {
		System.out.println("============================\n"
				+ "|          MOBLIMA         |\n"
				+ "|   BY CZ2002 SS8 Group5   |\n"
				+ "============================");
		displayMenu();
	} 
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello, Welcome to MOBLIMA!");
		System.out.println("Menu\n"
				+ "----\n"
				+ "(1) Staff\n"
				+ "(2) MovieGoer\n"
				+ "Please enter choice");
		int choice = sc.nextInt();
		switch (choice) {
        case 1:
            intent(this, new AdminView());
            break;
        case 2:
            intent(this, new MovieGoerView());
            break;
	}
}
