package core;

import configuration.Configuration;
import configuration.ConfigurationFactory;
import files.FileElement;
import fsmanager.FilesystemManager;
import fsmanager.FilesystemManagerFactory;
import fsmanager.ManagerOperation;
import fsmanager.ManagerOperationBuilder;
import ui.UIFacade;
import ui.UIFacadeSingleton;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 20/10/15.
 */
public class SmartDriveImpl implements SmartDrive {
    private UIFacade mUI;
    private FilesystemManager mManager;
    private Configuration mConfiguration;

    private FileElement mCurrentLocalDirectory;
    private FileElement mCurrentSmartDriveDirectory;

    protected SmartDriveImpl(){
        mUI = UIFacadeSingleton.getUIFacade();
        mManager = FilesystemManagerFactory.getFilesystemManager();
        mConfiguration = ConfigurationFactory.getConfiguration();

        if(mConfiguration.isCreatedForTheFirstTime() ||
                mConfiguration.getSmartDriveRootPath() == null ||
                mConfiguration.getSmartDriveRootPath().equals(""))

            getRootSmartDriveDirectory();

    }


    /*
     Here we must translate UI request into concrete FilesystemOperation's
     */
    @Override
    public void copyFileElement(FileElement target, FileElement destination) {
        if(! destination.isDirectory()) {
            mUI.error("Error", "Destination must be a directory");

        } else {
            ManagerOperation operation = ManagerOperationBuilder.getCopyOperation(target, destination);
            mManager.operate(operation);
        }
    }

    @Override
    public void moveFileElement(FileElement target, FileElement destination) {
        if(!target.isFile() && destination.isFile()) {
            mUI.error("Error", "Destination must be a directory");

        } else {
            ManagerOperation operation = ManagerOperationBuilder.getMoveOperation(target, destination);
            mManager.operate(operation);
        }
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

    @Override
    public void startApplication() {
        mUI.startUI();
    }

    @Override
    public void endApplication(int status) {
        mUI.finishUI();
        System.exit(1);
    }

    private void getRootSmartDriveDirectory(){
        String rootDirectory = mUI.chooseDirectory("Choose the root directory");

        if(rootDirectory != null && !rootDirectory.equals("")) {
            File file = new File(rootDirectory);

            if(file.exists()) {
                if(file.isDirectory()){
                    if(file.list().length > 0){
                        boolean ok = mUI.confirm("Confirm", "Directory is not empty. Correct?");

                        if(ok) {
                            try {
                                mConfiguration.setSmartDriveRootPath(file.getCanonicalPath());
                            } catch (IOException e){
                                mUI.fatalError("IOException", e.getMessage());
                            }
                        } else {
                            mUI.fatalError("Error", "Is not a directory!");
                        }

                    }
                } else {
                    mUI.fatalError("Error", "Is not a directory!");
                }
            }
        }
    }
}
