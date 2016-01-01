package workmanager;

/**
 * Created by user on 20/10/15.
 */
public interface Work {
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
     * @param observer Object implementing the interface WorkObserver that will be notified with every STATUS change
     */
    void addOperationObserver(WorkObserver observer);

    /**
     * @param observer Renove previous observer
     */
    void removeOperationObserver(WorkObserver observer);

    /**
     * Do the job!
     */
    void doIt();

}
