package core;

import elements.FilesystemElement;
import filesystem.FilesystemManager;
import filesystem.FilesystemManagerFactory;
import ui.MainWindow;

import java.util.List;

/**
 * Created by user on 20/10/15.
 */
public class SmartDriveImpl implements SmartDrive {
    private MainWindow mMainWindow;
    private FilesystemManager mManager;

    protected SmartDriveImpl(MainWindow mainWindow){
        mMainWindow = mainWindow;
        mManager = FilesystemManagerFactory.getFilesystemManager(mMainWindow);

        // leer la configuración .ini en %APPDATA%, si no existe SmartDrive directory, preguntarlo y guardar la configuración.
    }


    /*
     Here we must translate UI request into concrete FilesystemOperation's
     */
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
