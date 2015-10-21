package filesystem;

import elements.FilesystemElement;
import operations.FilesystemOperation;

import java.util.List;

/**
 * Created by user on 21/10/15.
 */
public interface FilesystemManager {

    void operate(FilesystemOperation operation);
}
