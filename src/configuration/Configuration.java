package configuration;

import java.io.IOException;

/**
 * Created by user on 22/10/15.
 */
public interface Configuration {

    boolean isCreatedForTheFirstTime();
    String getSmartDriveRootPath();
    void setSmartDriveRootPath(String path);

}
