package files;

/**
 * Created by user on 27/10/15.
 */
public interface FileElement {
    boolean isFile();
    boolean isDirectory();
    boolean isLocal();

    String[] list();
    FileElement[] listFiles();

    boolean delete();
    boolean exists();

    String getAbsolutePath();

    String getName();
    String getParent();
    FileElement getParentFile();

    long length(); // the length in bytes for the file, if a directory unespecified

    boolean mkdir();
    boolean createNewFile();
    boolean renameTo(FileElement dest);

}
