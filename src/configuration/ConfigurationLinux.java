package configuration;

/**
 * Created by user on 22/10/15.
 */
public class ConfigurationLinux implements Configuration {
    String mRootPath = "";

    protected ConfigurationLinux(){
        String configurationIniFilePath = System.getProperty("user.home") + "/.config/SmartDrive/config.ini";

        // tendremos que leer el fichero y extraer los valores.
    }

    @Override
    public String getSmartDriveRootPath() {
        return mRootPath;
    }


}
