package core;

import configuration.Configuration;
import configuration.PersistentConfiguration;
import ui.UIFacade;
import ui.UIFacadeSingleton;
import workmanager.Work;
import workmanager.WorkManager;
import workmanager.WorkManagerFactory;
import workmanager.WorkOperationBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by user on 20/10/15.
 */
public class SmartDriveImpl implements SmartDrive {
    private static final String APPLICATION_NAME = "SmartDrive";
    private static final String APPLICATION_VERSION = "v0.1";

    private UIFacade mUI;
    private WorkManager mManager;
    private Configuration mConfiguration;

    private Path mCurrentLocalPath;
    private Path mCurrentSmartDriveDirectory;

    protected SmartDriveImpl(){
        mUI = UIFacadeSingleton.getUIFacade();
        mManager = WorkManagerFactory.getFilesystemManager();
        mConfiguration = PersistentConfiguration.getConfiguration();

        if(mConfiguration.isCreatedForTheFirstTime()||mConfiguration.getStringValue(SmartDrive.CONFIGURATION_ROOT_LOCAL_DIRECTORY_FOR_SMARTDRIVE, "").equals(""))
            getRootSmartDriveDirectory();

        mUI.setApplicationController(this);
    }


    /**
     * Here we must translate UI request into concrete FilesystemOperation's
     */
    @Override
    public void copy(Path source, Path destination) {
        if(Files.isDirectory(source) && !Files.isDirectory(destination)) {
            mUI.error("Error", "Destination must be a directory");
        } else {
            Work operation = WorkOperationBuilder.getCopyOperation(source, destination);
            mManager.work(operation);
        }
    }

    @Override
    public void move(Path source, Path destination) {
        if(Files.isDirectory(source) && !Files.isDirectory(destination)) {
            mUI.error("Error", "Destination must be a directory");
        } else {
            Work operation = WorkOperationBuilder.getMoveOperation(source, destination);
            mManager.work(operation);
        }
    }

    @Override
    public void remove(Path target) {
        if(Files.exists(target)) {
            Work operation = WorkOperationBuilder.getDeleteOperation(target);
            mManager.work(operation);
        }
    }

    @Override
    public void mkdir(Path target) {
        if(!Files.exists(target)) {
            Work operation = WorkOperationBuilder.getCreateDirectoryOperation(target);
            mManager.work(operation);
        }
    }

    @Override
    public void changeLocalWorkingPath(String newPath) {
        mCurrentLocalPath = FileSystems.getDefault().getPath(newPath);
    }

    @Override
    public void changeSmartDriveWorkingPath(String newPath) {
        //todo mCurrentSmartDriveDirectory = new SDPath()
    }

    @Override
    public void changeLocalWorkingPath(Path newPath) {
        mCurrentLocalPath = newPath;
    }

    @Override
    public void changeSmartDriveWorkingPath(Path newPath) {
        mCurrentSmartDriveDirectory = newPath;
    }

    @Override
    public Path getLocalWorkingPath() {
        return mCurrentLocalPath;
    }

    @Override
    public Path getSmartDriveWorkingPath() {
        return mCurrentSmartDriveDirectory;
    }

    @Override
    public void startApplication() {
        mUI.startUI();
    }

    @Override
    public void endApplication(int status) {
        mUI.finishUI();
        System.exit(status);
    }

    private void getRootSmartDriveDirectory(){
        String rootDirectory = mUI.chooseDirectory("Choose the root directory where will be placed SmartDrive directory");

        if(rootDirectory != null && !rootDirectory.equals("")) {
            File file = new File(rootDirectory);

            if(! file.exists()) {
                boolean ok = mUI.confirm("Confirm", "Create directory?");
                if(ok) {
                    ok = file.mkdirs();
                    if(!ok)
                        mUI.fatalError("Fatal Error", "Root directory creation failed.");

                } else {
                    mUI.fatalError("Fatal Error", "Root directory needed");
                }
            }

            if(file.isDirectory()){
                File rootSmartDriveDirectory = new File(file, ".sd");
                if(!rootSmartDriveDirectory.exists()) {
                    boolean ok = rootSmartDriveDirectory.mkdirs();
                    if (!ok) {
                        try {
                            mUI.fatalError("Fatal Error", "Cannot create " + rootSmartDriveDirectory.getCanonicalPath());
                        } catch (IOException e){
                            mUI.fatalError("IOException", e.getMessage());
                        }
                    } else {
                        try {
                            mConfiguration.setValue(SmartDrive.CONFIGURATION_ROOT_LOCAL_DIRECTORY_FOR_SMARTDRIVE, rootSmartDriveDirectory.getCanonicalPath());
                            mConfiguration.storeConfiguration();

                        } catch (IOException e){
                            mUI.fatalError("IOException", e.getMessage());
                        }
                        mUI.information("Information", "SmartDrive directory created correctly.");
                    }
                }

            } else {
                mUI.fatalError("Fatal Error", "Is not a directory!");
            }
        } else {
            mUI.fatalError("Fatal Error", "Must be selected a root directory where to place SmartDrive directory");
        }
    }

    @Override
    public String getApplicationNameAndVersion() {
        return APPLICATION_NAME + " " + APPLICATION_VERSION;
    }
}
