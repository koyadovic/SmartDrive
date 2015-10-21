package filesystem;

import operations.FilesystemOperation;
import operations.OperationObserver;
import ui.MainWindow;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by user on 20/10/15.
 */
public class FilesystemManagerImpl implements FilesystemManager, OperationObserver {
    private MainWindow mMainWindow;

    private final Queue<FilesystemOperation> queue = new ConcurrentLinkedQueue<FilesystemOperation>();

    protected FilesystemManagerImpl(MainWindow mainWindow){
        mMainWindow = mainWindow;
        FilesystemWorker worker = new FilesystemWorker(this, queue); // this para publicar el progreso hacia el View
        Thread workerThread = new Thread(worker);
        workerThread.start();
    }


    /*
     FilesystemManager Method Implemented
     */
    public void operate(FilesystemOperation operation) {
        operation.addOperationObserver(this);
        queue.add(operation);
    }

    /*
     OperationObserver Methods Implemented

     Operations only will call this methods if they think it's necessary
     Due to that, this methods only route the operation to User Interface.
     */
    @Override
    public void notifyStart(FilesystemOperation operation) {
        mMainWindow.showFilesystemOperationInfo(operation);
    }

    @Override
    public void notifyProgress(FilesystemOperation operation, int current, int total) {
        mMainWindow.showProgressBar(operation, current, total);
    }

    @Override
    public void notifyEnd(FilesystemOperation operation) {
        mMainWindow.showFilesystemOperationInfo(operation);
    }
}
