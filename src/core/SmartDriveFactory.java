package core;


/**
 * Created by user on 21/10/15.
 */
public class SmartDriveFactory {

    public static SmartDrive getAppInstance(){
        return new SmartDriveImpl();
    }
}
