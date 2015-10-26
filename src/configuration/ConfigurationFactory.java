package configuration;

import paths.Paths;
import paths.PathsFactory;
import ui.MainWindow;

/**
 * Created by user on 22/10/15.
 *
 * As a Singleton
 */
public class ConfigurationFactory {

    private static Configuration mConfiguration = null;

    private ConfigurationFactory(){}

    public static Configuration getConfiguration(MainWindow mainWindow) {
        Paths paths = null;

        try {
            paths = PathsFactory.getPaths();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return new ConfigurationImpl(mainWindow);

    }
}
