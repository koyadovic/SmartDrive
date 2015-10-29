package configuration;

/**
 * Created by user on 22/10/15.
 */
public interface Configuration {

    /**
     * because users must specify the Directory where SmartDrive will place SmartDrive directory and all the files inside it.
     * @return true if is the first execution
     */
    boolean isCreatedForTheFirstTime();

    /**
     * On the first execution, users will be prompted to select a directory to place the root directory of SmartDrive
     * If a user select ./Directory/ the root directory of SmartDrive will be ./Directory/SmartDrive/
     * @return The canonical path of the root directory of SmartDrive
     */
    String getSmartDriveLocalRootPath();

    /**
     * @param path Sets the root directory of SmartDrive
     */
    void setSmartDriveLocalRootPath(String path);

    /**
     * this String stored must be understood to recreate the necessary objects later
     * using the objects constructors or whatever. package "files"
     * @return The last local directory opened by the user
     */
    String getLastLocalDirectoryOpenedPath();

    /**
     * @param path Sets the last local directory opened by the user
     */
    void setLastLocalDirectoryOpenedPath(String path);

    /**
     * @return Here is the same but for SmartDrive, not for local.
     */
    String getLastSmartDriveDirectoryOpenedPath();

    /**
     * @param path Sets the last SmartDrive directory opened by the user
     */
    void setLastSmartDriveDirectoryOpenedPath(String path);

    /**
     * This makes all the configuration changes to be persistent.
     */
    void save();

}
