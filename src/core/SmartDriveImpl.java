package core;

import files.FileElement;
import fsmanager.FilesystemManager;
import fsmanager.FilesystemManagerFactory;
import fsmanager.ManagerOperation;
import fsmanager.ManagerOperationBuilder;
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
    public FileElement[] getChildrenElements(FileElement target) {
        return target.listFiles();
    }

    public void copyFileElement(FileElement target, FileElement destination) {
        if(! destination.isDirectory())
            mMainWindow.showErrorMessage("Error", "Destination must be a directory");

        ManagerOperation operation = ManagerOperationBuilder.getCopyOperation(target, destination);
        mManager.operate(operation);
    }

    public void moveFileElement(FileElement target, FileElement destination) {
        if(!target.isFile() && destination.isFile())
            mMainWindow.showErrorMessage("Error", "Destination must be a directory");

        ManagerOperation operation = ManagerOperationBuilder.getMoveOperation(target, destination);
        mManager.operate(operation);
    }

    public void deleteFileElement(FileElement target) {
        if(target.exists()) {
            ManagerOperation operation = ManagerOperationBuilder.getDeleteOperation(target);
            mManager.operate(operation);
        }
    }

    public void createDirectory(FileElement target) {
        if(!target.exists()) {
            ManagerOperation operation = ManagerOperationBuilder.getCreateDirectoryOperation(target);
            mManager.operate(operation);
        }
    }

    @Override
    public FileElement getCurrentDirectory() {
        return null;
    }
}
