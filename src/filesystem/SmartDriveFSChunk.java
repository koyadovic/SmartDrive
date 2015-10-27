package filesystem;

import files.FileElement;

/**
 * Created by user on 27/10/15.
 */
public class SmartDriveFSChunk {
    private FileElement mContainer;
    private long mOffset;
    private long mLength;

    protected SmartDriveFSChunk(FileElement container, long offset, long length){
        mContainer = container;
        mOffset = offset;
        mLength = length;
    }

    public FileElement getFileContainer() {
        return mContainer;
    }

    public long offset() {
        return mOffset;
    }

    public long length() {
        return mLength;
    }
}
