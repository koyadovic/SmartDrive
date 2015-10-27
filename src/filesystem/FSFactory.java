package filesystem;

import files.FileElement;

/**
 * Created by user on 27/10/15.
 */
public class FSFactory {

    public static FS getFS(FileElement element){
        switch (element.getType()){

            case FileElement.TYPE_LOCAL:
                return new LocalFS();

            case FileElement.TYPE_SMARTDRIVE:
                return new SmartDriveFS();

        }

        return null;
    }
}
