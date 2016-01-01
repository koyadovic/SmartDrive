package workmanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by user on 20/10/15.
 */
public class WorkCopy extends WorkAbstract {
    private Path mSource;
    private Path mDestination;

    protected WorkCopy(Path source, Path destination){
        mSource = source;
        mDestination = destination;
    }

    @Override
    public void doIt() {
        try {
            Files.copy(mSource, mDestination);
        } catch (IOException e){

        }
    }
}
