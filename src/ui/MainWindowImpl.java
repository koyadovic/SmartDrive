package ui;

import configuration.Configuration;
import configuration.ConfigurationFactory;
import core.SmartDrive;
import core.SmartDriveFactory;
import fsmanager.ManagerOperation;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by user on 21/10/15.
 */
public class MainWindowImpl implements MainWindow {

    private SmartDrive mApp;
    private Display mDisplay;
    private Shell mShell;
    private Configuration mConfiguration;

    protected MainWindowImpl(Display display){
        mDisplay = display;

        // here we instantiate the Controller, our app.
        mApp = SmartDriveFactory.getAppInstance(this);

        // get the configuration
        mConfiguration = ConfigurationFactory.getConfiguration(this);

        // create widgets and set listeners
        initUI();

        // execution loop
        while (!mShell.isDisposed()) {
            if (!mDisplay.readAndDispatch()) {
                mDisplay.sleep();
            }
        }
    }

    private void initUI(){
        mShell = new Shell(mDisplay);

        // llenar la ventana y establecer listeners de eventos

        mShell.open();
    }

    @Override
    public void showFilesystemOperationInfo(ManagerOperation operation) {

    }

    @Override
    public void showProgressBar(ManagerOperation operation, int current, int total) {

    }

    @Override
    public void showErrorMessage(String title, String text) {

    }

    @Override
    public void showInfoMessage(String title, String text) {

    }
}
