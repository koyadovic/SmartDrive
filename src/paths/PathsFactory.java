package paths;

import ui.UIFacadeSingleton;

/**
 * Created by user on 23/10/15.
 */
public class PathsFactory {

    public static Paths getPaths() {
        String os = System.getProperty("os.name", "generic");

        if(os.toLowerCase().startsWith("windows")) {
            return new WindowsPaths();
        }
        else if(os.toLowerCase().equals("linux")){
            return new LinuxPaths();
        } else {
            UIFacadeSingleton.getUIFacade().fatalError("Fatal Error", "Platform not supported");
            return new LinuxPaths(); // eek !
        }
    }
}
