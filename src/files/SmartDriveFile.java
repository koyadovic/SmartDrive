package files;

import core.SmartDrive;

/**
 * Created by user on 27/10/15.
 */
public class SmartDriveFile implements FileElement {
    private final int   mType = FileElement.TYPE_SMARTDRIVE;

    private String      mName;
    private FileElement mParent;
    private long        mSize;

    private static final String mPathPrefix     = "SD:";
    private static final String mPathSeparator  = "\\";

    public SmartDriveFile(String pathname){

    }

    public SmartDriveFile(String parent, String child){

    }

    public SmartDriveFile(FileElement parent, String child){

    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public int getType() {
        return mType;
    }

    @Override
    public String[] list() {
        return new String[0];
    }

    @Override
    public FileElement[] listFiles() {
        return new FileElement[0];
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public String getCanonicalPath() {
        FileElement c   = this;
        String path     = "";

        while(c != null){
            path        = mPathSeparator + c.getName() + path;
            c           = c.getParent();
        }
        path            = mPathPrefix + path;

        if(isDirectory())
            path        = path + mPathPrefix;

        return path;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public FileElement getParent() {
        return mParent;
    }

    @Override
    public long length() {
        return 0;
    }

    @Override
    public boolean mkdir() {
        return false;
    }

    @Override
    public boolean createNewFile() {
        return false;
    }

    @Override
    public boolean renameTo(FileElement dest) {
        return false;
    }
}
