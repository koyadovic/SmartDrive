package ui;

import core.SmartDrive;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by user on 28/10/15.
 */
public class UIFacadeImpl implements UIFacade {

    /*
     Main field for the progress bar
     */
    private ProgressBar mProgressBar = null;

    protected UIFacadeImpl(){}

    @Override
    public void startUI() {
        MainWindow.run();
    }

    @Override
    public void finishUI() {
        MainWindow.freeResources();
    }

    @Override
    public String chooseDirectory(String title) {
        return DialogChooseDirectory.show(title);
    }

    @Override
    public boolean confirm(String title, String message) {
        return DialogConfirmation.show(title, message);
    }

    @Override
    public void error(String title, String message) {
        DialogError.show(title, message);
    }

    @Override
    public void fatalError(String title, String message) {
        DialogError.show(title, message);
        finishUI();
        System.exit(1);
    }

    @Override
    public void information(String title, String message) {
        DialogInformation.show(title, message);
    }

    @Override
    public void startProgressBar() {
        if(mProgressBar != null)
            mProgressBar.dispose();

        Display display = DisplaySingleton.getDisplay();
        Shell shell = new Shell(display);
        mProgressBar = new ProgressBar(shell, SWT.SMOOTH);
        Rectangle clientArea = shell.getClientArea();
        mProgressBar.setBounds(clientArea.x, clientArea.y, 200, 32);
        shell.open();
    }

    @Override
    public void updateProgressBar(int total, final int current) {
        if(mProgressBar != null) {
            if (mProgressBar.getDisplay().isDisposed()) return;

            int maxProgress = mProgressBar.getMaximum();
            final int one = maxProgress / total;

            mProgressBar.getDisplay().asyncExec(new Runnable() {
                @Override
                public void run() {
                    mProgressBar.setSelection(one * current);
                }
            });

        }
    }

    @Override
    public void endProgressBar() {
        if(mProgressBar != null)
            mProgressBar.dispose();

        mProgressBar = null;
    }

    @Override
    public boolean isProgressBarStarted() {
        return mProgressBar != null;
    }

    @Override
    public void setApplicationController(SmartDrive controller) {
        MainWindow.setApplicationController(controller);
    }
}
