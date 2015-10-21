package core;

import elements.FilesystemElement;

import java.util.List;

/**
 * Created by user on 21/10/15.
 */
public interface SmartDrive {

    List<FilesystemElement> getChildrenElements(FilesystemElement target);
    void copyElement(FilesystemElement target, FilesystemElement destination);
    void moveElement(FilesystemElement target, FilesystemElement destination);
    void deleteElement(FilesystemElement target);
    void createDirectory(String name);

}
