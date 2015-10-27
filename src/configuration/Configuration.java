package configuration;

/**
 * Created by user on 22/10/15.
 */
public interface Configuration {

    boolean isCreatedForTheFirstTime();
    String getSmartDriveRootPath();
    void setSmartDriveRootPath(String path);

    int getLastLocalDirectoryOpenedID();
    void setLastLocalDirectoryOpenedID(int id);

    int getLastSmartDriveDirectoryOpenedID();
    void setLastSmartDriveDirectoryOpenedID(int id);



}
