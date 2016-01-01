package workmanager;

import ui.UIFacade;
import ui.UIFacadeSingleton;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by user on 20/10/15.
 */
public class WorkManagerImpl implements WorkManager, WorkObserver {
    private final Queue<Work> queue = new ConcurrentLinkedQueue<Work>();

    protected WorkManagerImpl(){
        Worker worker = new Worker(this, queue); // this para publicar el progreso hacia el View
        Thread workerThread = new Thread(worker);
        workerThread.start();

    }

    /*
     FilesystemManager Method Implemented
     */

    public void work(Work operation) {
        operation.addOperationObserver(this);
        queue.add(operation);
    }

    /*
     WorkObserver Methods Implemented

     Operations only will call this methods if they think it's necessary
     Due to that, this methods only route the operation to User Interface.
     */
    @Override
    public void notifyStart(Work operation) {
        UIFacadeSingleton.getUIFacade().information("Start Operation", operation.getStatusText());
    }

    @Override
    public void notifyProgress(Work operation, int current, int total) {
        UIFacade ui = UIFacadeSingleton.getUIFacade();

        if(! ui.isProgressBarStarted())
            ui.startProgressBar();

        ui.updateProgressBar(current, total);

        if(current == total)
            ui.endProgressBar();
    }

    @Override
    public void notifyEnd(Work operation) {
        UIFacadeSingleton.getUIFacade().information("End Operation", operation.getStatusText());
    }
}
