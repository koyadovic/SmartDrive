package fsmanager;

import files.FileElement;

/**
 * Created by user on 27/10/15.
 */
public class ManagerOperationBuilder {

    public static ManagerOperation getCopyOperation(FileElement target, FileElement destination){
        return new ManagerOperationCopy(target, destination);
    }

    public static ManagerOperation getMoveOperation(FileElement target, FileElement destination){
        return new ManagerOperationMove(target, destination);
    }

    public static ManagerOperation getDeleteOperation(FileElement target){
        return new ManagerOperationDelete(target);
    }

    public static ManagerOperation getCreateDirectoryOperation(FileElement target){
        return new ManagerOperationCreateDirectory(target);
    }
}
