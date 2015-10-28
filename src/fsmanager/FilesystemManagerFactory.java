package fsmanager;


/**
 * Created by user on 21/10/15.
 */
public class FilesystemManagerFactory {

    public static FilesystemManager getFilesystemManager(){
        return new FilesystemManagerImpl();
    }
}
