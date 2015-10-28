
import core.SmartDrive;
import core.SmartDriveFactory;
import ui.*;

/**
 * Created by user on 21/10/15.
 *
 * This is the entry point of the app.
 */
public class Main {

    public static void main(String[] args){
        // todo quizá mejor ejecutar el controlador y que éste se encargue de arrancar la UI de forma abstracta.
        SmartDrive sd = SmartDriveFactory.getAppInstance();


        MainWindow.run();
        MainWindow.freeResources();
    }
}
