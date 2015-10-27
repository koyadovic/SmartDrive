package files;

/**
 * Created by user on 27/10/15.
 */
public class SmartDriveFile implements FileElement {

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isLocal() {
        return false;
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
    public String getAbsolutePath() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getParent() {
        return null;
    }

    @Override
    public FileElement getParentFile() {
        return null;
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
