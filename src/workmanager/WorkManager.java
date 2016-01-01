package workmanager;

/**
 * Created by user on 21/10/15.
 */
public interface WorkManager {
    /**
     * @param operation The concrete operation that will be done, like copy, move, delete, etc.
     */
    void work(Work operation);
}
