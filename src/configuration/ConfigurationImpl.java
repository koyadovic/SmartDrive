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
    private static final String MAIN_SECTION = "main";
    private boolean mCreatedForTheFirstTime = false;

    // configuration file
    private Wini mConfigurationWini;

    protected ConfigurationImpl() {
        File configurationFile = getConfigurationFile();
        if(!configurationFile.exists()) {
            try {
                mCreatedForTheFirstTime =
                        (configurationFile.getParentFile().exists() && configurationFile.createNewFile()) ||
                        (configurationFile.getParentFile().mkdirs() && configurationFile.createNewFile());

                if(!mCreatedForTheFirstTime)
                    UIFacadeSingleton.getUIFacade().fatalError("IO Error", "Cannot create configuration file");

            } catch (IOException e) {
                UIFacadeSingleton.getUIFacade().fatalError("IO Error", e.getMessage());
            }

        }
        mConfigurationWini = getConfigurationWini();
    }


    private File getConfigurationFile() {
        Paths paths = PathsFactory.getPaths();
        String configPath = paths.getConfigurationDirectoryPath();
        configPath += "config.ini";
        return new File(configPath);
    }

    private Wini getConfigurationWini(){
        try {
            return new Wini(getConfigurationFile());
        }
        catch (IOException ioe){
            UIFacadeSingleton.getUIFacade().error("IO Error", ioe.getMessage());
        }
        catch (Exception e){
            UIFacadeSingleton.getUIFacade().error("Unhandled exception", e.getMessage());
        }
        return null;
    }

    @Override
    public boolean isCreatedForTheFirstTime() {
        return mCreatedForTheFirstTime;
    }

    @Override
    public void setValue(String key, String value) {
        mConfigurationWini.put(MAIN_SECTION, key, value);
    }

    @Override
    public void setValue(String key, Integer value) {
        mConfigurationWini.put(MAIN_SECTION, key, value);
    }

    @Override
    public void setValue(String key, Float value) {
        mConfigurationWini.put(MAIN_SECTION, key, value);
    }

    @Override
    public void setValue(String key, Double value) {
        mConfigurationWini.put(MAIN_SECTION, key, value);
    }

    @Override
    public void setValue(String key, Long value) {
        mConfigurationWini.put(MAIN_SECTION, key, value);
    }

    @Override
    public String getStringValue(String key, String defaultValue) {
        return mConfigurationWini.get(MAIN_SECTION, key, String.class) == null ? defaultValue : mConfigurationWini.get(MAIN_SECTION, key, String.class);
    }

    @Override
    public Integer getIntegerValue(String key, Integer defaultValue) {
        return mConfigurationWini.get(MAIN_SECTION, key, Integer.class) == null ? defaultValue : mConfigurationWini.get(MAIN_SECTION, key, Integer.class);
    }

    @Override
    public Float getFloatValue(String key, Float defaultValue) {
        return mConfigurationWini.get(MAIN_SECTION, key, Float.class) == null ? defaultValue : mConfigurationWini.get(MAIN_SECTION, key, Float.class);
    }

    @Override
    public Double getDoubleValue(String key, Double defaultValue) {
        return mConfigurationWini.get(MAIN_SECTION, key, Double.class) == null ? defaultValue : mConfigurationWini.get(MAIN_SECTION, key, Double.class);
    }

    @Override
    public Long getLongValue(String key, Long defaultValue) {
        return mConfigurationWini.get(MAIN_SECTION, key, Long.class) == null ? defaultValue : mConfigurationWini.get(MAIN_SECTION, key, Long.class);
    }

    @Override
    public void storeConfiguration() {
        try {
            mConfigurationWini.store();
        } catch (IOException ioe){
            UIFacadeSingleton.getUIFacade().error("IO Error", ioe.getMessage());
        }
    }
}
