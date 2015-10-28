package ui;

/**
 * Created by user on 28/10/15.
 */
public interface UIFacade {
    void startUI();
    void finishUI();

    String chooseDirectory(String title);
    boolean confirm(String title, String message);
    void fatalError(String title, String message); // this quits the application
    void error(String title, String message); // this not.
    void information(String title, String message);

}
