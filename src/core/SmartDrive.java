package core;

import files.FileElement;

/**
 * Created by user on 21/10/15.
 */
public interface SmartDrive {
    String CONFIGURATION_ROOT_LOCAL_DIRECTORY_FOR_SMARTDRIVE = "root_local_directory";

    String CONFIGURATION_LAST_LOCAL_DIRECTORY = "last_local_directory";
    String CONFIGURATION_LAST_SMARTDRIVE_DIRECTORY = "last_smartdrive_directory";

    void copyFileElement(FileElement target, FileElement destination);
    void moveFileElement(FileElement target, FileElement destination);
    void deleteFileElement(FileElement target);
    void createDirectory(FileElement target);

    FileElement getCurrentLocalDirectory();
    FileElement getCurrentSmartDriveDirectory();

    void startApplication();
    void endApplication(int status);

}
