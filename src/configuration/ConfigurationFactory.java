package configuration;

import paths.Paths;
import paths.PathsFactory;

/**
 * Created by user on 22/10/15.
 *
 * As a Singleton
 */
public class ConfigurationFactory {

    private static Configuration mConfiguration = null;

    private ConfigurationFactory(){}

    public static Configuration getConfiguration() {
        Paths paths = null;

        try {
            paths = PathsFactory.getPaths();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return new ConfigurationImpl(paths.getConfigurationFilePath());

    }
}
