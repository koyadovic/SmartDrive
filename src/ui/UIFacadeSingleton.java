package ui;

/**
 * Created by user on 28/10/15.
 */
public class UIFacadeSingleton {
    private static UIFacade mUIFacade = null;

    public static UIFacade getUIFacade(){
        if(mUIFacade == null)
            mUIFacade = new UIFacadeImpl();

        return mUIFacade;
    }
}
