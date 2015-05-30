package com.usb.main;

import com.usb.controller.MainController;
import com.usb.navigator.DisplayNavigator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Entry Point of the Application
 *
 * This will load the Main Screen
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(DisplayNavigator.MAIN));

        BorderPane root = loader.load();
        MainController mainController = loader.getController();
        DisplayNavigator.setMainController(mainController);
        // Load Devices on startup
        mainController.loadDevices();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(true);
        //stage.getIcons().add(new Image("/img/logo.png"));
        stage.setTitle("HD EMCOM USB UTILITY");
        stage.setMaximized(true);
        stage.show();

        //Change to default theme
        mainController.selectDefaultTheme();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
