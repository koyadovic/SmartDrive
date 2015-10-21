package ui;

import org.eclipse.swt.widgets.Display;

/**
 * Created by user on 21/10/15.
 */
public class MainWindowFactory {

    public static MainWindow runInstance(Display display){
        return new MainWindowImpl(display);
    }
}
