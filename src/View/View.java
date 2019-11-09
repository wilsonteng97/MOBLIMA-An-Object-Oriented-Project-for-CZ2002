package View;
    
public abstract class View {
    
    public View previousView;  



    protected void intent(View currentView, View newView) {
        newView.previousView = currentView;
        newview();
    }

}
