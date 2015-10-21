package core;

import ui.MainWindow;

/**
 * Created by user on 21/10/15.
 */
public class SmartDriveFactory {

    public static SmartDrive getAppInstance(MainWindow mainWindow){
        return new SmartDriveImpl(mainWindow);
    }
}
