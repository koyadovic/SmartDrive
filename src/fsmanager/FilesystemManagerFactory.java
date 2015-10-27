package fsmanager;

import ui.MainUI;

/**
 * Created by user on 21/10/15.
 */
public class FilesystemManagerFactory {

    public static FilesystemManager getFilesystemManager(MainUI mainUI){
        return new FilesystemManagerImpl(mainUI);
    }
}
