package workmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20/10/15.
 */
public abstract class WorkAbstract implements Work {
    private int mStatus = Work.STATUS_IDLE;
    private String mStatusText = "";

    private List<WorkObserver> mObservers = new ArrayList<>();

    @Override
    public void addOperationObserver(WorkObserver observer) {
        mObservers.add(observer);
    }

    @Override
    public void removeOperationObserver(WorkObserver observer) {
        mObservers.remove(observer);
    }

    /*
     This three methods, can be called for the extended classes to notify to user interface some information.
     */
    protected void notifyStart(){
        mStatus = Work.STATUS_STARTING;

        for(WorkObserver o : mObservers)
            o.notifyStart(this);
    }

    protected void notifyProgress(int current, int total){
        mStatus = Work.STATUS_WORKING;

        for(WorkObserver o : mObservers)
            o.notifyProgress(this, current, total);
    }


    protected void notifyEnd(){
        mStatus = Work.STATUS_FINALIZED;

        for(WorkObserver o : mObservers)
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

    public abstract void doIt();
}
