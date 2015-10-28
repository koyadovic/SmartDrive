package configuration;

/**
 * Created by user on 22/10/15.
 */
public interface Configuration {

    boolean isCreatedForTheFirstTime();
    String getSmartDriveRootPath();
    void setSmartDriveRootPath(String path);

    // this String stored must be understood to recreate the necessary objects later
    // using the objects constructors or whatever. package "files"
    String getLastLocalDirectoryOpenedPath();
    void setLastLocalDirectoryOpenedPath(String path);

    String getLastSmartDriveDirectoryOpenedPath();
    void setLastSmartDriveDirectoryOpenedPath(String path);

}
