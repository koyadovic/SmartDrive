package ui;

/**
 * Created by user on 28/10/15.
 */
public class UIFacadeImpl implements UIFacade {

    protected UIFacadeImpl(){

    }

    @Override
    public void startUI() {
        MainWindow.run();
    }

    @Override
    public void finishUI() {
        MainWindow.freeResources();
    }

    @Override
    public String chooseDirectory(String title) {
        return DialogChooseDirectory.show(title);
    }

    @Override
    public boolean confirm(String title, String message) {
        return DialogConfirmation.show(title, message);
    }

    @Override
    public void error(String title, String message) {
        DialogError.show(title, message);
    }

    @Override
    public void fatalError(String title, String message) {
        DialogError.show(title, message);
        finishUI();
        System.exit(1);
    }

    @Override
    public void information(String title, String message) {
        DialogInformation.show(title, message);
    }
}
