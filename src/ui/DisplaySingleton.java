package ui;

import org.eclipse.swt.widgets.Display;

/**
 * Created by user on 28/10/15.
 */
public class DisplaySingleton {

    private DisplaySingleton() {}

    protected static Display getDisplay(){
        Display display = Display.getCurrent();

        if (display == null)
            display = Display.getDefault();

        return display;
    }
}
