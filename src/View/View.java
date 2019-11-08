package View;

public abstract class View {
    
    public View prevView;  

    protected void destroy() {
        if (prevView == null) 
        	System.exit(1);  
        else prevView.start();
    }

    protected void intent(View v, View u) {
        u.prevView = v;
        u.start();
    }

    /**
     * This method is to get the last {@code View} before this.
     * @return the last {@code View}
     */
    protected View getPrevView() {
        return prevView;
    }
}
