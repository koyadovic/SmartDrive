package paths;



/**
 * Created by user on 23/10/15.
 */
public class LinuxPaths implements Paths {

    protected LinuxPaths (){

    }

    @Override
    public String getConfigurationFilePath() {
        return System.getProperty("user.home") + "/.config/SmartDrive/config.ini";
    }
}
