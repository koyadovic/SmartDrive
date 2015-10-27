package files;

/**
 * Created by user on 27/10/15.
 */
public interface FileElement {
    int TYPE_LOCAL          = 1;
    int TYPE_SMARTDRIVE     = 2;

    boolean isFile();
    boolean isDirectory();

    int getType();

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
