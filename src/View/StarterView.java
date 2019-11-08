package View;

public class StarterView extends View{
	public StarterView() {
		System.out.println("============================\n"
				+ "|          MOBLIMA         |\n"
				+ "|   BY CZ2002 SS8 Group5   |\n"
				+ "============================");
		displayMenu();
	} 
	private void displayMenu() {
		System.out.println("Menu\n"
				+ "----\n"
				+ "(1) Staff\n"
				+ "(2) MovieGoer\n"
				+ "Please enter choice");
	}
}
