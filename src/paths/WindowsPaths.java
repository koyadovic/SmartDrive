package paths;

/**
 * Created by user on 23/10/15.
 */
public class WindowsPaths implements Paths {

    protected WindowsPaths(){

    }

    @Override
    public String getConfigurationFilePath() {
        return System.getenv("APPDATA") + "\\SmartDrive\\config.ini";
    }
}
