package paths;

/**
 * Created by user on 23/10/15.
 */
public class WindowsPaths implements Paths {

    protected WindowsPaths(){

    }

    @Override
    public String getConfigurationDirectoryPath() {
        return System.getenv("APPDATA") + "\\SmartDrive\\";
    }

    @Override
    public String getDefaultLocalRootDirectory() {
        return System.getenv("USERPROFILE");
    }
}
