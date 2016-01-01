package workmanager;

/**
 * Created by user on 20/10/15.
 */
public interface WorkObserver {
    void notifyStart(Work operation);
    void notifyProgress(Work operation, int current, int total);
    void notifyEnd(Work operation);
}
