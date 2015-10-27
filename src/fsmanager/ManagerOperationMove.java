package fsmanager;

import files.FileElement;

/**
 * Created by user on 20/10/15.
 */
public class ManagerOperationMove extends ManagerOperationAbstract {
    private FileElement mTarget;
    private FileElement mDestination;

    protected ManagerOperationMove(FileElement target, FileElement destination){
        mTarget = target;
        mDestination = destination;
    }

    @Override
    public void operate() {

    }

}
