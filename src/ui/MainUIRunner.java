package ui;

import org.eclipse.swt.widgets.Display;

/**
 * Created by user on 21/10/15.
 */
public class MainUIRunner {

    public static void runInstance(Display display){
        MainUI ui = new MainUIImpl(display);
        boolean result = ui.showConfirmationDialog("Test", "Lo desea?");

        if(result){
            ui.showInfoMessage("Resultado", "Ha pulsado OK");
        } else {
            ui.showErrorMessage("Resultado", "Ha pulsado Cancel");
        }

        ui.run();
    }
}
