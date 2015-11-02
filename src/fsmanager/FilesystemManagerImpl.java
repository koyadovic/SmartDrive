package fsmanager;

import ui.UIFacade;
import ui.UIFacadeSingleton;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by user on 20/10/15.
 */
public class FilesystemManagerImpl implements FilesystemManager, OperationObserver {
    private final Queue<ManagerOperation> queue = new ConcurrentLinkedQueue<ManagerOperation>();

    protected FilesystemManagerImpl(){
        FilesystemWorker worker = new FilesystemWorker(this, queue); // this para publicar el progreso hacia el View
        Thread workerThread = new Thread(worker);
        workerThread.start();

    }

    /*
     FilesystemManager Method Implemented
     */

    public void operate(ManagerOperation operation) {
        operation.addOperationObserver(this);
        queue.add(operation);
    }

    /*
     OperationObserver Methods Implemented

     Operations only will call this methods if they think it's necessary
     Due to that, this methods only route the operation to User Interface.
     */
    @Override
    public void notifyStart(ManagerOperation operation) {
        UIFacadeSingleton.getUIFacade().information("Start Operation", operation.getStatusText());
    }

    @Override
    public void notifyProgress(ManagerOperation operation, int current, int total) {
        UIFacade ui = UIFacadeSingleton.getUIFacade();

        if(! ui.isProgressBarStarted())
            ui.startProgressBar();

        ui.updateProgressBar(current, total);

        if(current == total)
            ui.endProgressBar();
    }

    @Override
    public void notifyEnd(ManagerOperation operation) {
        UIFacadeSingleton.getUIFacade().information("End Operation", operation.getStatusText());
    }
}
