package configuration;

/**
 * Created by user on 22/10/15.
 *
 * As a Singleton
 */
public class ConfigurationFactory {

    private ConfigurationFactory(){}

    public static Configuration getConfiguration() {
        return new ConfigurationImpl();

    }
}
