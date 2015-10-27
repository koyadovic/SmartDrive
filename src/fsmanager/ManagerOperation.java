package fsmanager;

/**
 * Created by user on 20/10/15.
 */
public interface ManagerOperation {
    int STATUS_IDLE         = 0;
    int STATUS_STARTING     = 1;
    int STATUS_WORKING      = 2;
    int STATUS_FINALIZED    = 3;

    int getStatus();
    String getStatusText();

    void addOperationObserver(OperationObserver observer);
    void removeOperationObserver(OperationObserver observer);

    void operate();

}
