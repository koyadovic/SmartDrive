package operations;

/**
 * Created by user on 20/10/15.
 */
public interface OperationObserver {
    void notifyStart(FilesystemOperation operation);
    void notifyProgress(FilesystemOperation operation, int current, int total);
    void notifyEnd(FilesystemOperation operation);
}
