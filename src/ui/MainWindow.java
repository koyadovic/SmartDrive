package ui;

import core.SmartDrive;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import paths.PathsFactory;

/**
 * Created by user on 28/10/15.
 */
public class MainWindow {
    private static Display mDisplay;
    private static Shell mShell;
    private static SmartDrive mSmartDriveController;

    private static Combo mLocalDirectoryCombo;
    private static Combo mSmartDriveDirectoryCombo;

    private static List mDebugArea;

    private static Tree mLocalTree;
    private static Tree mSmartDriveTree;

    private static Table mLocalTable;
    private static Table mSmartDriveTable;

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
                UIFacadeSingleton.getUIFacade().information("About SmartDrive", "SmartDrive\n\nJust better than OneDrive ;-)\n\nBy Miguel Collado");
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
                UIFacadeSingleton.getUIFacade().information("About SmartDrive", "SmartDrive\n\nJust better than OneDrive ;-)\n\nBy Miguel Collado");
            }
        });

        mShell.setMenuBar(menuBar);

    }

    private static void configureDebugArea(){
        GridData gridDataDebug = new GridData(GridData.FILL, GridData.FILL, true, false);
        gridDataDebug.horizontalSpan = 4;
        gridDataDebug.verticalSpan = 3;

        mDebugArea = new List(mShell, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
        mDebugArea.setLayoutData(gridDataDebug);
    }

    private static void configurePathsArea(){
        GridData comboGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
        new Label(mShell, SWT.SIMPLE).setText("Local:");
        mLocalDirectoryCombo = new Combo(mShell, SWT.SIMPLE);
        mLocalDirectoryCombo.setLayoutData(comboGridData);

        new Label(mShell, SWT.SIMPLE).setText("SmartDrive:");
        mSmartDriveDirectoryCombo = new Combo(mShell, SWT.SIMPLE);
        mSmartDriveDirectoryCombo.setLayoutData(comboGridData);

        mLocalDirectoryCombo.setItems(new String[]{});
        mSmartDriveDirectoryCombo.setItems(new String[]{});

        mLocalDirectoryCombo.add(PathsFactory.getPaths().getDefaultLocalRootDirectory());
        mLocalDirectoryCombo.select(0);

        mSmartDriveDirectoryCombo.add("SD:/");
        mSmartDriveDirectoryCombo.select(0);

        // selection listeners
        mLocalDirectoryCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                String newPath = mLocalDirectoryCombo.getText();

                for(int n = 0; n < mLocalDirectoryCombo.getItemCount(); n++){
                    if(mLocalDirectoryCombo.getItem(n).equals(newPath))
                        mLocalDirectoryCombo.remove(n);
                }
                mLocalDirectoryCombo.add(newPath, 0);
                mLocalDirectoryCombo.select(0);
                mSmartDriveController.changeLocalWorkingPath(newPath);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
                String newPath = mLocalDirectoryCombo.getText();

                for(int n = 0; n < mLocalDirectoryCombo.getItemCount(); n++){
                    if(mLocalDirectoryCombo.getItem(n).equals(newPath))
                        mLocalDirectoryCombo.remove(n);
                }
                mLocalDirectoryCombo.add(newPath, 0);
                mLocalDirectoryCombo.select(0);
                mSmartDriveController.changeLocalWorkingPath(newPath);
            }
        });
        mSmartDriveDirectoryCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                String newPath = mSmartDriveDirectoryCombo.getText();

                for(int n = 0; n < mSmartDriveDirectoryCombo.getItemCount(); n++){
                    if(mSmartDriveDirectoryCombo.getItem(n).equals(newPath))
                        mSmartDriveDirectoryCombo.remove(n);
                }
                mSmartDriveDirectoryCombo.add(newPath, 0);
                mSmartDriveDirectoryCombo.select(0);
                mSmartDriveController.changeSmartDriveWorkingPath(newPath);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
                String newPath = mSmartDriveDirectoryCombo.getText();

                for(int n = 0; n < mSmartDriveDirectoryCombo.getItemCount(); n++){
                    if(mSmartDriveDirectoryCombo.getItem(n).equals(newPath))
                        mSmartDriveDirectoryCombo.remove(n);
                }
                mSmartDriveDirectoryCombo.add(newPath, 0);
                mSmartDriveDirectoryCombo.select(0);
                mSmartDriveController.changeSmartDriveWorkingPath(newPath);
            }
        });

    }

    private static void configureTreeViewArea(){
        GridData treeGridDate = new GridData(GridData.FILL, GridData.FILL, true, true);
        treeGridDate.horizontalSpan = 2;


        mLocalTree = new Tree(mShell, SWT.BORDER);
        mLocalTree.setLayoutData(treeGridDate);

        mSmartDriveTree = new Tree(mShell, SWT.BORDER);
        mSmartDriveTree.setLayoutData(treeGridDate);
    }

    private static void configureTableArea(){
        GridData tableGridDate = new GridData(GridData.FILL, GridData.FILL, true, true);
        tableGridDate.horizontalSpan = 2;
        tableGridDate.verticalSpan = 5;
        tableGridDate.minimumHeight = 200;

        mLocalTable = new Table(mShell, SWT.BORDER);
        mLocalTable.setLayoutData(tableGridDate);
        TableColumn tlName = new TableColumn(mLocalTable, 0);
        TableColumn tlSize = new TableColumn(mLocalTable, 0);
        TableColumn tlType = new TableColumn(mLocalTable, 0);
        TableColumn tlLastChange = new TableColumn(mLocalTable, 0);
        tlName.setText("Name");
        tlType.setText("Type");
        tlSize.setText("Size");
        tlLastChange.setText("Last Change");
        tlName.setWidth(70);
        tlSize.setWidth(70);
        tlType.setWidth(70);
        tlLastChange.setWidth(70);
        mLocalTable.setHeaderVisible(true);

        mSmartDriveTable = new Table(mShell, SWT.BORDER);
        mSmartDriveTable.setLayoutData(tableGridDate);
        TableColumn tsName = new TableColumn(mSmartDriveTable, 0);
        TableColumn tsSize = new TableColumn(mSmartDriveTable, 0);
        TableColumn tsType = new TableColumn(mSmartDriveTable, 0);
        TableColumn tsLastChange = new TableColumn(mSmartDriveTable, 0);
        tsName.setText("Name");
        tsSize.setText("Size");
        tsType.setText("Type");
        tsLastChange.setText("Last Change");
        tsName.setWidth(70);
        tsSize.setWidth(70);
        tsType.setWidth(70);
        tsLastChange.setWidth(70);

        mSmartDriveTable.setHeaderVisible(true);
    }

    /**
     * Init the main window, add layouts widgets and set listeners
     */
    private static void init(){
        // Main Window
        mShell = new Shell(mDisplay);
        mShell.setText(mSmartDriveController.getApplicationNameAndVersion());
        mShell.setSize(800, 600);

        // 4 columns Window
        GridLayout layout = new GridLayout(4, false);
        mShell.setLayout(layout);

        //Menú
        configureMenu();

        // Debug Area
        //configureDebugArea();

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
        mSmartDriveController.endApplication(0);
    }
}
