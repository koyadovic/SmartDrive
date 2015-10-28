package configuration;

import org.ini4j.Wini;
import paths.Paths;
import paths.PathsFactory;
import ui.UIFacadeSingleton;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 22/10/15.
 */
public class ConfigurationImpl implements Configuration {
    private boolean mCreatedForTheFirstTime = false;

    // configuration vars
    private String mSmartDriveRootPath = "";
    private String mLastLocalDirectoryOpened = PathsFactory.getPaths().getDefaultLocalRootDirectory();
    private String mLastSmartDriveDirectoryOpened = "SD:\\"; // todo tendremos que ver cómo mejorar esto ...

    protected ConfigurationImpl() {

        File configurationFile = getConfigurationFile();

        try {
            if(! configurationFile.exists())
                createConfigurationFile();

            loadConfigurationFile();
        }
        catch (IOException ioe){
            UIFacadeSingleton.getUIFacade().error("IO Error", ioe.getMessage());
        }
        catch (Exception e){
            UIFacadeSingleton.getUIFacade().error("Unhandled exception", e.getMessage());
        }


    }

    private File getConfigurationFile() {
        Paths paths = PathsFactory.getPaths();
        String configPath = paths.getConfigurationFilePath();
        return new File(configPath);
    }

    private void createConfigurationFile() throws IOException {
        mCreatedForTheFirstTime = true;

        saveConfigurationFile();
    }

    private void loadConfigurationFile() throws IOException {
        Wini ini = new Wini(getConfigurationFile());
        ini.get("main", "smartDriveRootPath", String.class);
        ini.get("main", "lastLocalDirectoryPath", String.class);
        ini.get("main", "lastSmartDriveDirectoryPath", String.class);
    }

    private void saveConfigurationFile() throws IOException {
        Wini ini = new Wini(getConfigurationFile());
        ini.put("main", "smartDriveRootPath", mSmartDriveRootPath);
        ini.put("main", "lastLocalDirectoryPath", mLastLocalDirectoryOpened);
        ini.put("main", "lastSmartDriveDirectoryPath", mLastSmartDriveDirectoryOpened);
        ini.store();

    }

    @Override
    public boolean isCreatedForTheFirstTime() {
        return mCreatedForTheFirstTime;
    }

    @Override
    public String getSmartDriveRootPath() {
        return mSmartDriveRootPath;
    }

    @Override
    public void setSmartDriveRootPath(String path){
        // todo
    }


    @Override
    public String getLastLocalDirectoryOpenedPath() {
        return mLastLocalDirectoryOpened;
    }

    @Override
    public void setLastLocalDirectoryOpenedPath(String id) {
        // todo
    }

    @Override
    public String getLastSmartDriveDirectoryOpenedPath() {
        return mLastSmartDriveDirectoryOpened;
    }

    @Override
    public void setLastSmartDriveDirectoryOpenedPath(String id) {
        // todo
    }
}
