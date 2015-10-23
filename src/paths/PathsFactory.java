package paths;

/**
 * Created by user on 23/10/15.
 */
public class PathsFactory {

    public static Paths getPaths() throws Exception {
        String os = System.getProperty("os.name", "generic");

        if(os.toLowerCase().startsWith("linux")){
            return new LinuxPaths();
        }
        else if(os.toLowerCase().startsWith("windows")) {
            return new WindowsPaths();
        } else {
            throw new Exception("Platform not supported.");
        }
    }
}
