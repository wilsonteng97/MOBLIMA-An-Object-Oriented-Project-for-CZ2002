package View;

import java.util.Scanner;

public abstract class View {
    
    public View previousView;  

    protected abstract void starter();

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
    protected void intent(View currentView, View newView) {
        newView.previousView = currentView;
        newView.starter();
    }
    
    protected static String goBack() {
    	System.out.print("Press ENTER to go back");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
