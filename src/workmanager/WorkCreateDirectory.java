package workmanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by user on 20/10/15.
 */
public class WorkCreateDirectory extends WorkAbstract {
    private Path mTarget;

    protected WorkCreateDirectory(Path target){
        mTarget = target;
    }


    @Override
    public void doIt() {
        try {
            Files.createDirectory(mTarget);
        } catch (IOException e){

        }
    }

}
