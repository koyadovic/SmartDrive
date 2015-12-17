package configuration;

/**
 * Created by user on 22/10/15.
 */
public interface Configuration {

    void setValue(String key, String value);
    void setValue(String key, Integer value);
    void setValue(String key, Float value);
    void setValue(String key, Double value);
    void setValue(String key, Long value);

    String getStringValue(String key, String defaultValue);
    Integer  getIntegerValue(String key, Integer defaultValue);
    Float getFloatValue(String key, Float defaultValue);
    Double getDoubleValue(String key, Double defaultValue);
    Long getLongValue(String key, Long defaultValue);

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
