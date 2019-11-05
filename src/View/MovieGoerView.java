package View;

public class MovieGoerView implements View{
	public MovieGoerView() {}
	private void displayMenu() {
		System.out.println("(1) Movie Listing\n"
				+ "(2) Booking\n"
				+ "(3) Payment\n"
				+ "(4) Review\n"
				+ "(5) Booking History");
	}
}
