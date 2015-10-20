package filesystem;

import elements.FilesystemElement;
import operations.FilesystemOperation;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by user on 20/10/15.
 */
public class FilesystemManager {

    private final Queue<FilesystemOperation> queue = new ConcurrentLinkedQueue<FilesystemOperation>();

    public FilesystemManager(){
        FilesystemWorker worker = new FilesystemWorker(this, queue); // this para publicar el progreso hacia el View
        Thread workerThread = new Thread(worker);
        workerThread.start();
    }

    public FilesystemOperation operate(FilesystemOperation operation) {
        queue.add(operation);
        return operation;
    }
}
