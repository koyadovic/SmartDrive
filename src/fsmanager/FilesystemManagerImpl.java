package fsmanager;

import filesystem.SmartDriveFS;
import filesystem.SmartDriveFSFactory;
import ui.MainWindow;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by user on 20/10/15.
 */
public class FilesystemManagerImpl implements FilesystemManager, OperationObserver {
    private MainWindow mMainWindow;
    private SmartDriveFS mSmartDriveFS;

    private final Queue<ManagerOperation> queue = new ConcurrentLinkedQueue<ManagerOperation>();

    protected FilesystemManagerImpl(MainWindow mainWindow){
        mMainWindow = mainWindow;
        FilesystemWorker worker = new FilesystemWorker(this, queue); // this para publicar el progreso hacia el View
        Thread workerThread = new Thread(worker);
        workerThread.start();

        mSmartDriveFS = SmartDriveFSFactory.getSmartDriveFS();
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
        mMainWindow.showFilesystemOperationInfo(operation);
    }

    @Override
    public void notifyProgress(ManagerOperation operation, int current, int total) {
        mMainWindow.showProgressBar(operation, current, total);
    }

    @Override
    public void notifyEnd(ManagerOperation operation) {
        mMainWindow.showFilesystemOperationInfo(operation);
    }
}
