package fsmanager;

import java.util.Queue;

/**
 * Created by user on 20/10/15.
 */
public class FilesystemWorker implements Runnable {

    private final Queue<ManagerOperation> mOperationQueue;
    private final FilesystemManagerImpl mManager;

    protected FilesystemWorker(FilesystemManagerImpl manager, Queue<ManagerOperation> operationQueue){
        this.mOperationQueue = operationQueue;
        this.mManager = manager;
    }

    @Override
    public void run() {
        while (true) {
            consume();

            try {
                synchronized (mOperationQueue) {
                    mOperationQueue.wait();
                }

            } catch (InterruptedException ex) {
                // interrumpido
            }
        }
    }

    private void consume() {
        while (!mOperationQueue.isEmpty()) {
            ManagerOperation op = mOperationQueue.poll();

            if (op != null) {
                // do it and publish the start, progress and end to manager but only if the operation requires it ...
                // if not, this methods won't be called.

                op.operate();

            }
        }
    }

}
