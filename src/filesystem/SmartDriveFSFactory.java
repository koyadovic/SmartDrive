package filesystem;

/**
 * Created by user on 27/10/15.
 */
public class SmartDriveFSFactory {
    public static SmartDriveFS getSmartDriveFS(){
        return new SmartDriveFSImpl();
    }
}
