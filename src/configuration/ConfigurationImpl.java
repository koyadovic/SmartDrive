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
    private String mSmartDriveLocalRootPath = "";
    private String mLastLocalDirectoryOpened = PathsFactory.getPaths().getDefaultLocalRootDirectory();
    private String mLastSmartDriveDirectoryOpened = "SD:\\"; // todo tendremos que ver cómo mejorar esto ...

    protected ConfigurationImpl() {

        File configurationFile = getConfigurationFile();

        try {
            if(! configurationFile.exists())
                createConfigurationFile();

        }
        catch (IOException ioe){
            UIFacadeSingleton.getUIFacade().error("IO Error", ioe.getMessage());
        }
        catch (Exception e){
            UIFacadeSingleton.getUIFacade().error("Unhandled exception", e.getMessage());
        }

        load();
    }

    private File getConfigurationFile() {
        Paths paths = PathsFactory.getPaths();
        String configPath = paths.getConfigurationDirectoryPath();
        configPath += "config.ini";
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

    private void load(){
        try {
            loadConfigurationFile();
        } catch (IOException e){
            UIFacadeSingleton.getUIFacade().fatalError("Fatal Error", "Cannot load configuration file: " + e.getMessage());
        }
    }

    @Override
    public void save() {
        try {
            saveConfigurationFile();
        } catch (IOException e){
            UIFacadeSingleton.getUIFacade().fatalError("Fatal Error", "Cannot save configuration file: " + e.getMessage());
        }
    }

    private void saveConfigurationFile() throws IOException {
        Wini ini = new Wini(getConfigurationFile());
        ini.put("main", "smartDriveRootPath", mSmartDriveLocalRootPath);
        ini.put("main", "lastLocalDirectoryPath", mLastLocalDirectoryOpened);
        ini.put("main", "lastSmartDriveDirectoryPath", mLastSmartDriveDirectoryOpened);
        ini.store();
    }

    @Override
    public boolean isCreatedForTheFirstTime() {
        return mCreatedForTheFirstTime;
    }

    @Override
    public String getSmartDriveLocalRootPath() {
        return mSmartDriveLocalRootPath;
    }

    @Override
    public void setSmartDriveLocalRootPath(String path){
        mSmartDriveLocalRootPath = path;
    }


    @Override
    public String getLastLocalDirectoryOpenedPath() {
        return mLastLocalDirectoryOpened;
    }

    @Override
    public void setLastLocalDirectoryOpenedPath(String path) {
        mLastLocalDirectoryOpened = path;
    }

    @Override
    public String getLastSmartDriveDirectoryOpenedPath() {
        return mLastSmartDriveDirectoryOpened;
    }

    @Override
    public void setLastSmartDriveDirectoryOpenedPath(String path) {
        mLastSmartDriveDirectoryOpened = path;
    }
}
