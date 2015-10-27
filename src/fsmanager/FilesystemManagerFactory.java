package fsmanager;

import ui.MainWindow;

/**
 * Created by user on 21/10/15.
 */
public class FilesystemManagerFactory {

    public static FilesystemManager getFilesystemManager(MainWindow mainWindow){
        return new FilesystemManagerImpl(mainWindow);
    }
}
