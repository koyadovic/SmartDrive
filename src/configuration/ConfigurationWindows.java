package configuration;

/**
 * Created by user on 22/10/15.
 */
public class ConfigurationWindows implements Configuration {
    String mRootPath = "";

    protected ConfigurationWindows(){
        String configurationIniFilePath = System.getenv("APPDATA") + "\\SmartDrive\\config.ini";

        // tendremos que leer el fichero y extraer los valores.
    }

    @Override
    public String getSmartDriveRootPath() {
        return mRootPath;
    }
}
