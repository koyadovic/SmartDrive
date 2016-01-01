package core;

import java.nio.file.Path;

/**
 * Created by user on 21/10/15.
 */
public interface SmartDrive {
    String CONFIGURATION_ROOT_LOCAL_DIRECTORY_FOR_SMARTDRIVE = "root_local_directory";

    String CONFIGURATION_LAST_LOCAL_WORKING_PATH = "last_local_working_path";
    String CONFIGURATION_LAST_SMARTDRIVE_WORKING_PATH = "last_smartdrive_working_path";

    void copy(Path source, Path destination);
    void move(Path source, Path destination);
    void remove(Path target);
    void mkdir(Path target);

    void changeLocalWorkingPath(String newPath);
    void changeSmartDriveWorkingPath(String newPath);
    void changeLocalWorkingPath(Path newPath);
    void changeSmartDriveWorkingPath(Path newPath);

    Path getLocalWorkingPath();
    Path getSmartDriveWorkingPath();

    void startApplication();
    void endApplication(int status);

    String getApplicationNameAndVersion();

}
