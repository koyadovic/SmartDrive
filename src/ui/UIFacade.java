package ui;

/**
 * Created by user on 28/10/15.
 */
public interface UIFacade {
    /**
     * Starts the UI and begin to interact with the user
     */
    void startUI();

    /**
     * Ends UI and quits the application
     */
    void finishUI();

    /**
     * Open a Window that allow the users to choose one directory of the computer
     * @param title The title of the dialog
     * @return Canonical path of the directory selected
     */
    String chooseDirectory(String title);

    /**
     * @param title of the dialog
     * @param message of the dialog
     * @return returns true or false if the user accept or deny the confirmation
     */
    boolean confirm(String title, String message);

    /**
     * Shows an error message and force a quit of the application
     * @param title of the dialog
     * @param message of the dialog
     */
    void fatalError(String title, String message); // this quits the application

    /**
     * Shows an error message but not close the application
     * @param title of the dialog
     * @param message of the dialog
     */
    void error(String title, String message);

    /**
     * Shows a dialog to inform of whatever to user
     * @param title of the dialog
     * @param message of the dialog
     */
    void information(String title, String message);

}
