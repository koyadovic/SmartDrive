package files;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 27/10/15.
 */
public class LocalFile implements FileElement {
    private final int mType = FileElement.TYPE_LOCAL;

    private File mFile;

    public LocalFile(String pathname){
        mFile = new File(pathname);
    }

    public LocalFile(String parent, String child){
        mFile = new File(parent, child);
    }

    public LocalFile(FileElement parent, String child){
        this(parent.getCanonicalPath() + child);
    }

    @Override
    public boolean isFile() {
        return mFile.isFile();
    }

    @Override
    public boolean isDirectory() {
        return mFile.isDirectory();
    }

    @Override
    public int getType() {
        return mType;
    }

    @Override
    public String[] list() {
        return mFile.list();
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
        return mFile.getAbsolutePath();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public FileElement getParent() {
        return null;
    }

    @Override
    public long length() {
        return mFile.length();
    }

    @Override
    public boolean mkdir() {
        return mFile.mkdir();
    }

    @Override
    public boolean createNewFile() {
        boolean r = false;
        try {
            r = mFile.createNewFile();

        } catch (IOException e){

        }
        return r;
    }

    @Override
    public boolean renameTo(FileElement dest) {
        return false;
    }
}
