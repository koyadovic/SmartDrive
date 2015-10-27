
import org.eclipse.swt.widgets.Display;
import ui.MainUIRunner;

/**
 * Created by user on 21/10/15.
 *
 * This is the entry point of the app.
 */
public class Main {
    public static void main(String[] args){
        Display display = new Display();
        MainUIRunner.runInstance(display);
        display.dispose();
    }
}
