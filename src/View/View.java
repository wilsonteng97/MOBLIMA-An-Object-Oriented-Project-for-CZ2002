package View;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class View is the parent class.
 */
public abstract class View {
    
    /** The previous view. */
    public View previousView;  

    /**
     * Starter.
     */
    protected abstract void starter();

    /**
     * This end operations is to allow the system to go back to previous interface.
     */
    protected void end()
    {
        if(previousView == null)
        {
            System.exit(1);
        }
        else
        {
        	goBack();
            previousView.starter();
        }
        
    }
    
    /**
     * Intent.
     *
     * @param currentView the current view
     * @param newView the new view
     */
    protected void intent(View currentView, View newView) {
        newView.previousView = currentView;
        newView.starter();
    }
    
    /**
     * Go back to previous interface.
     *
     * @return the string
     */
    protected static String goBack() {
    	System.out.print("Press ENTER to go back");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Gets the previous.
     *
     * @return the previous
     */
    public View getPrevious()
    {
    	return previousView;
    }
}
