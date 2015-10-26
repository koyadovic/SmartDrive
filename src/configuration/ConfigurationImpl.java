package configuration;

import core.SmartDriveFactory;
import org.ini4j.Wini;
import paths.Paths;
import paths.PathsFactory;
import ui.MainWindow;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 22/10/15.
 */
public class ConfigurationImpl implements Configuration {
    private MainWindow mMainWindow;

    private boolean mCreatedForTheFirstTime = false;

    // configuration vars
    private String mSmartDriveRootPath = "";

    protected ConfigurationImpl(MainWindow mainWindow) {
        mMainWindow = mainWindow;

        try {
            Paths paths = PathsFactory.getPaths();
            String configPath = paths.getConfigurationFilePath();

            File configurationFile = new File(configPath);

            if(! configurationFile.exists())
                createConfigurationFile(configPath);

            loadConfigurationFile(configPath);
        }
        catch (IOException ioe){
            mMainWindow.showErrorMessage("IO Error", ioe.getMessage());
        }
        catch (Exception e){
            mMainWindow.showErrorMessage("Unhandled exception", e.getMessage());
        }


    }

    private void createConfigurationFile(String path) throws IOException {
        mCreatedForTheFirstTime = true;

        File configurationFile = new File(path);

    }

    private void loadConfigurationFile(String path) throws IOException {
        File configurationFile = new File(path);
        Wini ini = new Wini(configurationFile);
    }

    private void saveConfigurationFile(String path) throws IOException {
        File configurationFile = new File(path);
        Wini ini = new Wini(configurationFile);
        ini.put("main", "smartDriveRootPath", path);
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
}
