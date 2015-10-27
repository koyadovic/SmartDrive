package core;

import files.FileElement;

import java.util.List;

/**
 * Created by user on 21/10/15.
 */
public interface SmartDrive {
    void copyFileElement(FileElement target, FileElement destination);
    void moveFileElement(FileElement target, FileElement destination);
    void deleteFileElement(FileElement target);
    void createDirectory(FileElement target);

    FileElement getCurrentLocalDirectory();
    FileElement getCurrentSmartDriveDirectory();

}
