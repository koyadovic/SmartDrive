
import core.SmartDriveFactory;

/**
 * Created by user on 21/10/15.
 *
 * This is the entry point of the app.
 */
public class Main {
    public static void main(String[] args){

        SmartDriveFactory .getAppInstance()
                          .startApplication();

    }
}
