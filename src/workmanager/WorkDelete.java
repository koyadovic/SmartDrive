package workmanager;

import java.nio.file.Path;

/**
 * Created by user on 20/10/15.
 */
public class WorkDelete extends WorkAbstract {
    private Path mTarget;

    protected WorkDelete(Path target){
        mTarget = target;
    }


    @Override
    public void doIt() {

    }

}
