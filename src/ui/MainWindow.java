package ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by user on 28/10/15.
 */
public class MainWindow {
    private static Display mDisplay;
    private static Shell mShell;

    private MainWindow() { }

    public static void run() {
        mDisplay = DisplaySingleton.getDisplay();

        // create widgets and set listeners
        init();

        // Start the execution loop
        start();

    }

    public static void freeResources(){
        DisplaySingleton.getDisplay().dispose();
    }

    private static void init(){
        mShell = new Shell(mDisplay);

        // llenar la ventana y establecer listeners de eventos

        mShell.open();
    }


    private static void start() {
        // execution loop
        while (!mShell.isDisposed()) {
            if (!mDisplay.readAndDispatch()) {
                mDisplay.sleep();
            }
        }
    }
}
