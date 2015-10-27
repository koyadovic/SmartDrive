package ui;

import configuration.Configuration;
import configuration.ConfigurationFactory;
import core.SmartDrive;
import core.SmartDriveFactory;
import fsmanager.ManagerOperation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by user on 21/10/15.
 */
public class MainUIImpl implements MainUI {

    private SmartDrive mApp;
    private Display mDisplay;
    private Shell mShell;
    private Configuration mConfiguration;

    private ProgressBar mProgressBar;

    protected MainUIImpl(Display display){
        mDisplay = display;

        // create widgets and set listeners
        init();

        // here we instantiate the Controller, our app.
        mApp = SmartDriveFactory.getAppInstance(this);

        // get the configuration
        mConfiguration = ConfigurationFactory.getConfiguration(this);

    }

    private void init(){
        mShell = new Shell(mDisplay);

        // llenar la ventana y establecer listeners de eventos

        mShell.open();
    }

    @Override
    public void showFilesystemOperationInfo(ManagerOperation operation) {

    }

    @Override
    public void showProgressBar(ManagerOperation operation, long current, long total) {
        // todo hay que pensar cómo lo hacemos.
        // http://git.eclipse.org/c/platform/eclipse.platform.swt.git/tree/examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet56.java
    }

    @Override
    public void showErrorMessage(String title, String message) {
        MessageBox messageBox = new MessageBox(mShell, SWT.OK | SWT.ICON_ERROR);

        messageBox.setText(title);
        messageBox.setMessage(message);
        messageBox.open();
    }

    @Override
    public void showInfoMessage(String title, String message) {
        MessageBox messageBox = new MessageBox(mShell, SWT.OK | SWT.ICON_INFORMATION);

        messageBox.setText(title);
        messageBox.setMessage(message);
        messageBox.open();
    }

    @Override
    public boolean showConfirmationDialog(String title, String message) {
        MessageBox messageBox = new MessageBox(mShell, SWT.OK | SWT.CANCEL | SWT.ICON_WARNING);

        messageBox.setText(title);
        messageBox.setMessage(message);

        return messageBox.open() == SWT.OK;
    }

    @Override
    public void exit(int status) {
        mShell.dispose();
    }

    @Override
    public void run() {
        // execution loop
        while (!mShell.isDisposed()) {
            if (!mDisplay.readAndDispatch()) {
                mDisplay.sleep();
            }
        }
    }

}
