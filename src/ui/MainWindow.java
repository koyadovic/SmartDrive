package ui;

import core.SmartDrive;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by user on 28/10/15.
 */
public class MainWindow {
    private static Display mDisplay;
    private static Shell mShell;
    private static SmartDrive mSmartDriveController;

    private MainWindow() { }

    protected static void setApplicationController(SmartDrive controller) {
        mSmartDriveController = controller;
    }

    protected static void run() {
        mDisplay = DisplaySingleton.getDisplay();

        // create widgets and set listeners
        init();

        // Start the execution loop
        start();

    }

    /**
     * Frees resources closing the main window
     */
    protected static void freeResources(){
        if(mShell != null)
            mShell.dispose();
    }

    private static void configureMenu(){
        Menu menuBar = new Menu(mShell, SWT.BAR);
        MenuItem fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
        fileMenuHeader.setText("&File");

        Menu fileMenu = new Menu(mShell, SWT.DROP_DOWN);
        fileMenuHeader.setMenu(fileMenu);

        MenuItem fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
        fileExitItem.setText("E&xit");

        MenuItem helpMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
        helpMenuHeader.setText("&Help");

        Menu helpMenu = new Menu(mShell, SWT.DROP_DOWN);
        helpMenuHeader.setMenu(helpMenu);

        MenuItem aboutItem = new MenuItem(helpMenu, SWT.PUSH);
        aboutItem.setText("&About");

        fileExitItem.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                UIFacadeSingleton.getUIFacade().finishUI();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
                UIFacadeSingleton.getUIFacade().finishUI();
            }
        });

        aboutItem.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                UIFacadeSingleton.getUIFacade().information("About", "Just better than OneDrive ;-)");
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
                UIFacadeSingleton.getUIFacade().information("About", "Just better than OneDrive ;-)");
            }
        });

        mShell.setMenuBar(menuBar);

    }

    private static void configureDebugArea(){
        GridData gridDataDebug = new GridData(GridData.FILL, GridData.FILL, true, true);
        gridDataDebug.horizontalSpan = 4;

        List debugArea = new List(mShell, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
        debugArea.setLayoutData(gridDataDebug);
    }

    private static void configurePathsArea(){
        GridData comboGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
        new Label(mShell, SWT.SIMPLE).setText("Local:");
        new Combo(mShell, SWT.SIMPLE).setLayoutData(comboGridData);
        new Label(mShell, SWT.SIMPLE).setText("SmartDrive:");
        new Combo(mShell, SWT.SIMPLE).setLayoutData(comboGridData);
    }

    private static void configureTreeViewArea(){
        GridData treeGridDate = new GridData(GridData.FILL, GridData.FILL, true, true);
        treeGridDate.horizontalSpan = 2;

        Tree localTree = new Tree(mShell, SWT.BORDER);
        localTree.setLayoutData(treeGridDate);

        Tree smartDriveTree = new Tree(mShell, SWT.BORDER);
        smartDriveTree.setLayoutData(treeGridDate);
    }

    private static void configureTableArea(){
        GridData tableGridDate = new GridData(GridData.FILL, GridData.FILL, true, true);
        tableGridDate.horizontalSpan = 2;

        Table localTable = new Table(mShell, SWT.BORDER);
        localTable.setLayoutData(tableGridDate);

        Table smartDriveTable = new Table(mShell, SWT.BORDER);
        smartDriveTable.setLayoutData(tableGridDate);

    }

    /**
     * Init the main window, add layouts widgets and set listeners
     */
    private static void init(){
        // Main Window
        mShell = new Shell(mDisplay);
        mShell.setText(mSmartDriveController.getApplicationNameAndVersion());
        mShell.setSize(800, 500);

        // 4 columns Window
        GridLayout layout = new GridLayout(4, false);
        mShell.setLayout(layout);

        //Menú
        configureMenu();

        // Debug Area
        configureDebugArea();

        // Paths area
        configurePathsArea();

        // Tree Views Area
        configureTreeViewArea();

        // Table Area
        configureTableArea();


        mShell.open();
    }


    /**
     * Starts the main loop
     */
    private static void start() {
        // execution loop
        while (!mShell.isDisposed()) {
            if (!mDisplay.readAndDispatch()) {
                mDisplay.sleep();
            }
        }
        mDisplay.dispose();
    }
}
