package configuration;

/**
 * Created by user on 22/10/15.
 */
public interface Configuration {
    String SMARTDRIVE_LOCAL_ROOT_PATH = "smartdrive_local_root_path";
    String LAST_LOCAL_DIRECTORY_OPENED = "last_local_directory_opened";
    String LAST_SMARTDRIVE_DIRECTORY_OPENED = "last_smartdrive_directory_opened";


    void setValue(String key, String value);
    void setValue(String key, Integer value);
    void setValue(String key, Float value);
    void setValue(String key, Double value);
    void setValue(String key, Long value);

    String getStringValue(String key);
    Integer  getIntegerValue(String key);
    Float getFloatValue(String key);
    Double getDoubleValue(String key);
    Long getLongValue(String key);

    /**
     * because users must specify the Directory where SmartDrive will place SmartDrive directory and all the files inside it.
     * @return true if is the first execution
     */
    boolean isCreatedForTheFirstTime();

    /**
     * This makes all the configuration changes persistent.
     */
    void storeConfiguration();

}
