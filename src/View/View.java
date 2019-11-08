package View;

<<<<<<< Updated upstream
public interface View {
	public void displayMenu();
=======
public abstract class View {
    
    public View previousView;  

    protected void destroy() {
        if (previousView == null)
        {
            System.exit(1);  
        } 
        else 
            previousView();
    }

    protected void intent(View currentView, View newView) {
        newView.previousView = currentView;
        newview();
    }

    /**
     * This method is to get the last {@code View} before this.
     * @return the last {@code View}
     */
    protected View getPreviousView() {
        return previousView;
    }
>>>>>>> Stashed changes
}
