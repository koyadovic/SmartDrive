package fsmanager;

import files.FileElement;

/**
 * Created by user on 20/10/15.
 */
public class ManagerOperationDelete extends ManagerOperationAbstract {
    private FileElement mTarget;

    protected ManagerOperationDelete(FileElement target){
        mTarget = target;
    }


    @Override
    public void operate() {

    }

}
