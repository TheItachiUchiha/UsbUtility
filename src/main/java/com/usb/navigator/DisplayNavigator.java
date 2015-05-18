package com.usb.navigator;

import com.usb.controller.DeviceController;
import com.usb.controller.DeviceTabController;
import com.usb.controller.MainController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Utility class for controlling navigation between screens.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */

public class DisplayNavigator {

    /**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public static final String MAIN    = "/fxml/Main.fxml";
    public static final String DEVICE_LIST = "/fxml/DeviceList.fxml";
    public static final String DEVICE_TAB = "/fxml/DeviceTab.fxml";


    /** The main application layout controller. */
    private static MainController mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
    public static void setMainController(MainController mainController) {
        DisplayNavigator.mainController = mainController;
    }

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     *   cache FXMLLoaders
     *   cache loaded vista nodes, so they can be recalled or reused
     *   allow a user to specify vista node reuse or new creation
     *   allow back and forward history like a browser
     *
     * @param fxml the fxml file to be loaded.
     */

    public static FXMLLoader loadVista(String fxml) {
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(
                    DisplayNavigator.class.getResource(
                            fxml
                    ));
            Parent parent = (Parent) loader.load();
            mainController.setCenter(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loader;
    }
}
