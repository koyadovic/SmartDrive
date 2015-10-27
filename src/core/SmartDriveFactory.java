package core;

import ui.MainUI;

/**
 * Created by user on 21/10/15.
 */
public class SmartDriveFactory {

    public static SmartDrive getAppInstance(MainUI mainUI){
        return new SmartDriveImpl(mainUI);
    }
}
