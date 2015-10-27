package fsmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20/10/15.
 */
public abstract class ManagerOperationAbstract implements ManagerOperation {
    private int mStatus = ManagerOperation.STATUS_IDLE;
    private String mStatusText = "";

    private List<OperationObserver> mObservers = new ArrayList<>();

    @Override
    public void addOperationObserver(OperationObserver observer) {
        mObservers.add(observer);
    }

    @Override
    public void removeOperationObserver(OperationObserver observer) {
        mObservers.remove(observer);
    }

    /*
     This three methods, can be called for the extended classes to notify to user interface some information.
     */
    protected void notifyStart(){
        mStatus = ManagerOperation.STATUS_STARTING;

        for(OperationObserver o : mObservers)
            o.notifyStart(this);
    }

    protected void notifyProgress(int current, int total){
        mStatus = ManagerOperation.STATUS_WORKING;

        for(OperationObserver o : mObservers)
            o.notifyProgress(this, current, total);
    }


    protected void notifyEnd(){
        mStatus = ManagerOperation.STATUS_FINALIZED;

        for(OperationObserver o : mObservers)
            o.notifyEnd(this);
    }

    @Override
    public int getStatus() {
        return mStatus;
    }

    @Override
    public String getStatusText() {
        return mStatusText;
    }

    public abstract void operate();
}
