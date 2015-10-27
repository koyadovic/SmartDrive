package configuration;

import org.ini4j.Wini;
import paths.Paths;
import paths.PathsFactory;
import ui.MainUI;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 22/10/15.
 */
public class ConfigurationImpl implements Configuration {
    private MainUI mMainUI;

    private boolean mCreatedForTheFirstTime = false;

    // configuration vars
    private String mSmartDriveRootPath = "";
    private int mLastLocalDirectoryOpenedID = 0;
    private int mLastSmartDriveDirectoryOpenedID = 0;

    protected ConfigurationImpl(MainUI mainUI) {
        mMainUI = mainUI;

        File configurationFile = getConfigurationFile();

        try {
            if(! configurationFile.exists())
                createConfigurationFile();

            loadConfigurationFile();
        }
        catch (IOException ioe){
            mMainUI.showErrorMessage("IO Error", ioe.getMessage());
        }
        catch (Exception e){
            mMainUI.showErrorMessage("Unhandled exception", e.getMessage());
        }


    }

    private File getConfigurationFile() {
        Paths paths = PathsFactory.getPaths();
        String configPath = paths.getConfigurationFilePath();
        return new File(configPath);
    }

    private void createConfigurationFile() throws IOException {
        mCreatedForTheFirstTime = true;

        // createConfigurationFile();
    }

    private void loadConfigurationFile() throws IOException {
        Wini ini = new Wini(getConfigurationFile());
        ini.get("main", "smartDriveRootPath", String.class);
        ini.get("main", "lastLocalDirectoryID", Integer.class);
        ini.get("main", "lastSmartDriveDirectoryID", Integer.class);
    }

    private void saveConfigurationFile() throws IOException {
        Wini ini = new Wini(getConfigurationFile());
        ini.put("main", "smartDriveRootPath", mSmartDriveRootPath);
        ini.put("main", "lastLocalDirectoryID", mLastLocalDirectoryOpenedID);
        ini.put("main", "lastSmartDriveDirectoryID", mLastSmartDriveDirectoryOpenedID);
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

    }


    @Override
    public int getLastLocalDirectoryOpenedID() {
        return mLastLocalDirectoryOpenedID;
    }

    @Override
    public void setLastLocalDirectoryOpenedID(int id) {

    }

    @Override
    public int getLastSmartDriveDirectoryOpenedID() {
        return mLastSmartDriveDirectoryOpenedID;
    }

    @Override
    public void setLastSmartDriveDirectoryOpenedID(int id) {

    }
}
