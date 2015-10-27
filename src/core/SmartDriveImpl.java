package core;

import files.FileElement;
import fsmanager.FilesystemManager;
import fsmanager.FilesystemManagerFactory;
import fsmanager.ManagerOperation;
import fsmanager.ManagerOperationBuilder;
import ui.MainWindow;

/**
 * Created by user on 20/10/15.
 */
public class SmartDriveImpl implements SmartDrive {
    private MainWindow mMainWindow;
    private FilesystemManager mManager;

    private FileElement mCurrentLocalDirectory;
    private FileElement mCurrentSmartDriveDirectory;

    protected SmartDriveImpl(MainWindow mainWindow){
        mMainWindow = mainWindow;
        mManager = FilesystemManagerFactory.getFilesystemManager(mMainWindow);

        // leer la configuración .ini en %APPDATA%, si no existe SmartDrive directory, preguntarlo y guardar la configuración.
    }


    /*
     Here we must translate UI request into concrete FilesystemOperation's
     */
    @Override
    public void copyFileElement(FileElement target, FileElement destination) {
        if(! destination.isDirectory())
            mMainWindow.showErrorMessage("Error", "Destination must be a directory");

        ManagerOperation operation = ManagerOperationBuilder.getCopyOperation(target, destination);
        mManager.operate(operation);
    }

    @Override
    public void moveFileElement(FileElement target, FileElement destination) {
        if(!target.isFile() && destination.isFile())
            mMainWindow.showErrorMessage("Error", "Destination must be a directory");

        ManagerOperation operation = ManagerOperationBuilder.getMoveOperation(target, destination);
        mManager.operate(operation);
    }

    @Override
    public void deleteFileElement(FileElement target) {
        if(target.exists()) {
            ManagerOperation operation = ManagerOperationBuilder.getDeleteOperation(target);
            mManager.operate(operation);
        }
    }

    @Override
    public void createDirectory(FileElement target) {
        if(!target.exists()) {
            ManagerOperation operation = ManagerOperationBuilder.getCreateDirectoryOperation(target);
            mManager.operate(operation);
        }
    }

    @Override
    public FileElement getCurrentLocalDirectory() {
        return mCurrentLocalDirectory;
    }

    @Override
    public FileElement getCurrentSmartDriveDirectory() {
        return mCurrentSmartDriveDirectory;
    }

}
