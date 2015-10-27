package paths;

/**
 * Created by user on 23/10/15.
 */
public class PathsFactory {

    public static Paths getPaths() {
        String os = System.getProperty("os.name", "generic");

        if(os.toLowerCase().startsWith("windows")) {
            return new WindowsPaths();
        } else {
            return new LinuxPaths();
        }
    }
}
