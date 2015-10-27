package fsmanager;

import files.FileElement;
import filesystem.FS;
import filesystem.FSFactory;

/**
 * Created by user on 20/10/15.
 */
public class ManagerOperationCopy extends ManagerOperationAbstract {
    private FileElement mTarget;
    private FileElement mDestination;

    protected ManagerOperationCopy(FileElement target, FileElement destination){
        mTarget = target;
        mDestination = destination;
    }

    @Override
    public void operate() {
        FS readFS = FSFactory.getFS(mTarget);
        FS writeFS = FSFactory.getFS(mDestination);

        // todo aquí se tendrá que ver cómo copiar en concreto.
        // todo definirlo en la interfaz FS e implementarlo en las clases que se derivan dependiendo del tipo de elemento
    }
}
