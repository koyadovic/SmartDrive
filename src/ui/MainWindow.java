package ui;

import core.SmartDrive;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**
 * Created by user on 20/10/15.
 */
public class MainWindow {
    private SmartDrive mApp;
    private Display mDisplay;
    private Shell mShell;

    public MainWindow(SmartDrive app){
        this.mApp = app;
        initUI();
    }

    private void initUI(){
        mDisplay = new Display();
        mShell = new Shell(mDisplay);

        // llenar la ventana y establecer listeners de eventos

        mShell.open();
    }

    public void runUI(){

        while (!mShell.isDisposed()) {
            if (!mDisplay.readAndDispatch()) {
                mDisplay.sleep();
            }
        }
        mDisplay.dispose();
    }
}
