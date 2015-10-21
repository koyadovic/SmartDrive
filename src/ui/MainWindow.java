package ui;

import core.SmartDrive;
import core.SmartDriveFactory;
import operations.FilesystemOperation;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by user on 21/10/15.
 *
 * Main window of the app. Here is were we will launch others windows like configuration ones, etc.
 */
public interface MainWindow {

    void showFilesystemOperationInfo(FilesystemOperation operation);
    void showProgressBar(FilesystemOperation operation, int current, int total);
}
