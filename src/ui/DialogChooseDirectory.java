package ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;



/**
 * Created by user on 28/10/15.
 */
public class DialogChooseDirectory {
    private static final int width = 560;
    private static final int height = 420;

    public static String show(String title){
        Display display = DisplaySingleton.getDisplay();
        Shell shell = new Shell(display, SWT.APPLICATION_MODAL);
        shell.setSize(width, height);

        Rectangle parentBounds = shell.getBounds();

        shell.setLocation(
                parentBounds.x + (parentBounds.width - width) / 2,
                parentBounds.y + (parentBounds.height - height) / 2);

        DirectoryDialog dialog = new DirectoryDialog(shell, SWT.OPEN | SWT.OK | SWT.CANCEL);
        dialog.setText(title);

        String result = dialog.open();
        shell.dispose();
        return result;
    }

}
