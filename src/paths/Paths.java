package paths;

/**
 * Created by user on 23/10/15.
 */
public interface Paths {
    /**
     * @return String with the canonical path of the configuration directory
     */
    String getConfigurationDirectoryPath();

    /**
     * @return Returns the local startup directory
     */
    String getDefaultLocalRootDirectory();
}
