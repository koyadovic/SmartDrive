package fsmanager;

import files.FileElement;

/**
 * Created by user on 20/10/15.
 */
public class ManagerOperationCreateDirectory extends ManagerOperationAbstract {
    private FileElement mTarget;

    protected ManagerOperationCreateDirectory(FileElement target){
        mTarget = target;
    }


    @Override
    public void operate() {

    }

}
