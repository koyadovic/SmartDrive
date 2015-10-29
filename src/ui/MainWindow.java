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

    protected static void run() {
        mDisplay = DisplaySingleton.getDisplay();

        // create widgets and set listeners
        init();

        // Start the execution loop
        start();

    }

    /**
     * Frees resources closing the main window
     */
    protected static void freeResources(){
        if(mShell != null)
            mShell.dispose();
    }

    /**
     * Init the main window, add layouts widgets and set listeners
     */
    private static void init(){
        mShell = new Shell(mDisplay);

        // llenar la ventana y establecer listeners de eventos

        mShell.open();
    }


    /**
     * Starts the main loop
     */
    private static void start() {
        // execution loop
        while (!mShell.isDisposed()) {
            if (!mDisplay.readAndDispatch()) {
                mDisplay.sleep();
            }
        }
        mDisplay.dispose();
    }
}
