package fsmanager;

/**
 * Created by user on 20/10/15.
 */
public interface ManagerOperation {
    int STATUS_IDLE         = 0;
    int STATUS_STARTING     = 1;
    int STATUS_WORKING      = 2;
    int STATUS_FINALIZED    = 3;

    /**
     * @return STATUS_IDLE, STATUS_STARTING, STATUS_WORKING, STATUS_FINALIZED
     */
    int getStatus();

    /**
     * @return The current status explained for the UI
     */
    String getStatusText();

    /**
     * @param observer Object implementing the interface OperationObserver that will be notified with every STATUS change
     */
    void addOperationObserver(OperationObserver observer);

    /**
     * @param observer Renove previous observer
     */
    void removeOperationObserver(OperationObserver observer);

    /**
     * Do the job!
     */
    void operate();

}
