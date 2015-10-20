package core;

import elements.FilesystemElement;
import ui.MainWindow;

import java.util.List;

/**
 * Created by user on 20/10/15.
 */
public class SmartDrive {
    public SmartDrive(){
        // leer la configuración .ini en %APPDATA%, si no existe SmartDrive directory, preguntarlo y guardar la configuración.
    }

    public static void main(String[] args) {
        SmartDrive app = new SmartDrive();
        MainWindow ui = new MainWindow(app);
        ui.runUI();
    }

    public List<FilesystemElement> getChildrenElements(FilesystemElement target) {
        return null;
    }

    public void copyElement(FilesystemElement target, FilesystemElement destination) {

    }

    public void moveElement(FilesystemElement target, FilesystemElement destination) {

    }

    public void deleteElement(FilesystemElement target) {

    }

    public void createDirectory(String name) {

    }
}
