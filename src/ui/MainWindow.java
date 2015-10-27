package ui;

import fsmanager.ManagerOperation;

/**
 * Created by user on 21/10/15.
 *
 * Main window of the app. Here is were we will launch others windows like configuration ones, etc.
 */
public interface MainWindow {

    void showFilesystemOperationInfo(ManagerOperation operation);
    void showProgressBar(ManagerOperation operation, int current, int total);
    void showErrorMessage(String title, String text);
    void showInfoMessage(String title, String text);

}
