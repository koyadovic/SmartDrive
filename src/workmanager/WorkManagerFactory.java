package workmanager;


/**
 * Created by user on 21/10/15.
 */
public class WorkManagerFactory {

    public static WorkManager getFilesystemManager(){
        return new WorkManagerImpl();
    }
}
