package View;
    
public abstract class View {
    
    public View previousView;  

    protected abstract void starter();

    protected void destroy()
    {
        if(previousView == null)
        {
            System.exit(1);
        }
        else
        {
            previousView.starter();
        }
    }
    protected void intent(View currentView, View newView) {
        newView.previousView = currentView;
        newView.starter();
    }

}
