
import core.SmartDriveApp;

/**
 * Created by user on 21/10/15.
 *
 * This is the entry point of the app.
 */
public class Main {
    public static void main(String[] args){

        SmartDriveApp.getInstance()
                          .startApplication();

//        SDFileSystemProvider provider = new SDFileSystemProvider();
//
//        URI uri = URI.create("sd:/");
//        Map<String, String> env = new HashMap<>();
//        env.put("create", "true");
//
//        try {
//            FileSystem localFS = FileSystems.getDefault();
//            FileSystem smartDriveFS = provider.newFileSystem(uri, env);
//
//
//        } catch (IOException e){
//
//        }

    }
}
