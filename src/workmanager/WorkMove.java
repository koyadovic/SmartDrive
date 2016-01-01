package workmanager;

import java.nio.file.Path;

/**
 * Created by user on 20/10/15.
 */
public class WorkMove extends WorkAbstract {
    private Path mSource;
    private Path mDestination;

    protected WorkMove(Path source, Path destination){
        mSource = source;
        mDestination = destination;
    }

    @Override
    public void doIt() {

    }

}
