package operations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20/10/15.
 */
public abstract class AbstractOperation implements FilesystemOperation {
    private int mStatus = FilesystemOperation.STATUS_IDLE;
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

    protected void notifyStart(){
        mStatus = FilesystemOperation.STATUS_STARTING;

        for(OperationObserver o : mObservers)
            o.notifyStart(this);
    }

    protected void notifyProgress(int current, int total){
        mStatus = FilesystemOperation.STATUS_WORKING;

        for(OperationObserver o : mObservers)
            o.notifyProgress(this, current, total);
    }


    protected void notifyEnd(){
        mStatus = FilesystemOperation.STATUS_FINALIZED;

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
