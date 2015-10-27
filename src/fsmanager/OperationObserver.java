package fsmanager;

/**
 * Created by user on 20/10/15.
 */
public interface OperationObserver {
    void notifyStart(ManagerOperation operation);
    void notifyProgress(ManagerOperation operation, int current, int total);
    void notifyEnd(ManagerOperation operation);
}
