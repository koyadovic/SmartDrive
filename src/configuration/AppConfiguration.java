package configuration;

/**
 * Created by user on 22/10/15.
 *
 * As a Singleton
 */
public class AppConfiguration {

    private static Configuration mConfiguration = null;

    private AppConfiguration(){}

    public static Configuration getConfiguration() throws Exception {

        if(mConfiguration != null)
            return mConfiguration;

        String os = System.getProperty("os.name", "generic");

        if(os.toLowerCase().startsWith("linux")){
            mConfiguration = new ConfigurationLinux();
        }
        else if(os.toLowerCase().startsWith("windows")) {
            mConfiguration = new ConfigurationWindows();

        } else {
            throw new Exception("Unsupported platform, nor Linux or Windows machine");
        }

        return mConfiguration;

    }
}
