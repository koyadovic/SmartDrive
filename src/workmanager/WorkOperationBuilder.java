package workmanager;

import java.nio.file.Path;

/**
 * Created by user on 27/10/15.
 */
public class WorkOperationBuilder {

    public static Work getCopyOperation(Path target, Path destination){
        return new WorkCopy(target, destination);
    }

    public static Work getMoveOperation(Path target, Path destination){
        return new WorkMove(target, destination);
    }

    public static Work getDeleteOperation(Path target){
        return new WorkDelete(target);
    }

    public static Work getCreateDirectoryOperation(Path target){
        return new WorkCreateDirectory(target);
    }
}
