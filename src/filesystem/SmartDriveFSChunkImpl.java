package filesystem;

import files.FileElement;

/**
 * Created by user on 27/10/15.
 */
public class SmartDriveFSChunkImpl implements SmartDriveFSChunk {
    private FileElement mContainer;
    private long mOffset;
    private long mLength;

    protected SmartDriveFSChunkImpl(FileElement container, long offset, long length){
        mContainer = container;
        mOffset = offset;
        mLength = length;
    }

    @Override
    public FileElement getFileContainer() {
        return mContainer;
    }

    @Override
    public long offset() {
        return mOffset;
    }

    @Override
    public long length() {
        return mLength;
    }
}
