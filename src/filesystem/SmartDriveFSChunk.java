package filesystem;

import files.FileElement;

/**
 * Created by user on 27/10/15.
 */
public interface SmartDriveFSChunk {
    FileElement getFileContainer();
    long offset();
    long length();
}
