package fsmanager;

/**
 * Created by user on 21/10/15.
 */
public interface FilesystemManager {
    /**
     * @param operation The concrete operation that will be done, like copy, move, delete, etc.
     */
    void operate(ManagerOperation operation);
}
