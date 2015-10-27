package ui;

import fsmanager.ManagerOperation;

/**
 * Created by user on 21/10/15.
 *
 * Main window of the app. Here is were we will launch others windows like configuration ones, etc.
 */
public interface MainUI {

    void showFilesystemOperationInfo(ManagerOperation operation);

    void showProgressBar(ManagerOperation operation, long current, long total);

    void showErrorMessage(String title, String text);
    void showInfoMessage(String title, String text);
    boolean showConfirmationDialog(String title, String text);

    void exit(int status);
    void run();

}
