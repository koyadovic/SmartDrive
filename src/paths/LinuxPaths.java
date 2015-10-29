package paths;



/**
 * Created by user on 23/10/15.
 */
public class LinuxPaths implements Paths {

    protected LinuxPaths (){

    }

    @Override
    public String getConfigurationDirectoryPath() {
        return System.getProperty("user.home") + "/.config/SmartDrive/";
    }

    @Override
    public String getDefaultLocalRootDirectory() {
        return System.getProperty("user.home");
    }
}
