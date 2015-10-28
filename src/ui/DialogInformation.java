package ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by user on 28/10/15.
 */
public class DialogInformation {
    private static final int width = 360;
    private static final int height = 70;

    protected static void show(String title, String message){
        Display display = DisplaySingleton.getDisplay();
        Shell shell = new Shell(display);
        shell.setSize(width, height);

        Rectangle parentBounds = shell.getBounds();

        shell.setLocation(
                parentBounds.x + (parentBounds.width - width) / 2,
                parentBounds.y + (parentBounds.height - height) / 2);

        MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);

        messageBox.setText(title);
        messageBox.setMessage(message);
        messageBox.open();

        shell.dispose();
    }
}
