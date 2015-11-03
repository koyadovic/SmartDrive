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

    // configuration file
    private Wini mConfigurationIniFile;

    protected ConfigurationImpl() {

        File configurationFile = getConfigurationFile();

        try {
            if(! configurationFile.exists()){
                mConfigurationIniFile = new Wini(configurationFile);
                setDefaults();

                mConfigurationIniFile.store();
                mCreatedForTheFirstTime = true;
            } else {
                mConfigurationIniFile = new Wini(configurationFile);
            }

        }
        catch (IOException ioe){
            UIFacadeSingleton.getUIFacade().error("IO Error", ioe.getMessage());
        }
        catch (Exception e){
            UIFacadeSingleton.getUIFacade().error("Unhandled exception", e.getMessage());
        }

    }

    private void setDefaults(){
        mConfigurationIniFile.put("main", Configuration.SMARTDRIVE_LOCAL_ROOT_PATH, "");
        mConfigurationIniFile.put("main", Configuration.LAST_LOCAL_DIRECTORY_OPENED, PathsFactory.getPaths().getDefaultLocalRootDirectory());
        mConfigurationIniFile.put("main", Configuration.LAST_SMARTDRIVE_DIRECTORY_OPENED, "SD:\\"); // todo tendremos que ver cómo mejorar esto ...
    }

    private File getConfigurationFile() {
        Paths paths = PathsFactory.getPaths();
        String configPath = paths.getConfigurationDirectoryPath();
        configPath += "config.ini";
        return new File(configPath);
    }

    @Override
    public boolean isCreatedForTheFirstTime() {
        return mCreatedForTheFirstTime;
    }

    @Override
    public void setValue(String key, String value) {
        mConfigurationIniFile.put("main", key, value);
    }

    @Override
    public void setValue(String key, Integer value) {
        mConfigurationIniFile.put("main", key, value);
    }

    @Override
    public void setValue(String key, Float value) {
        mConfigurationIniFile.put("main", key, value);
    }

    @Override
    public void setValue(String key, Double value) {
        mConfigurationIniFile.put("main", key, value);
    }

    @Override
    public void setValue(String key, Long value) {
        mConfigurationIniFile.put("main", key, value);
    }

    @Override
    public String getStringValue(String key) {
        return mConfigurationIniFile.get("main", key, String.class);
    }

    @Override
    public Integer getIntegerValue(String key) {
        return mConfigurationIniFile.get("main", key, Integer.class);
    }

    @Override
    public Float getFloatValue(String key) {
        return mConfigurationIniFile.get("main", key, Float.class);
    }

    @Override
    public Double getDoubleValue(String key) {
        return mConfigurationIniFile.get("main", key, Double.class);
    }

    @Override
    public Long getLongValue(String key) {
        return mConfigurationIniFile.get("main", key, Long.class);
    }

    @Override
    public void storeConfiguration() {
        try {
            mConfigurationIniFile.store();
        } catch (IOException ioe){
            UIFacadeSingleton.getUIFacade().error("IO Error", ioe.getMessage());
        }
    }
}
