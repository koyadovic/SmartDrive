import org.eclipse.swt.widgets.Display;
import ui.MainWindowFactory;

/**
 * Created by user on 21/10/15.
 *
 * This is the entry point of the app.
 */
public class Main {
    public static void main(String[] args){
        Display display = new Display();
        MainWindowFactory.runInstance(display);
        display.dispose();
    }
}
