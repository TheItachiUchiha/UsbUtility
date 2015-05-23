package com.usb.main;

import com.aquafx_project.AquaFx;
import com.guigarage.flatterfx.FlatterFX;
import com.guigarage.material.MaterialDesignPane;
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
        scene.getStylesheets().add(getClass().getResource("/css/slideout.css").toExternalForm());

        stage.setScene(scene);
        stage.setResizable(true);
        //stage.getIcons().add(new Image("/img/logo.png"));
        stage.setTitle("HD EMCOM USB UTILITY");
        stage.setMaximized(true);
        stage.show();
        // FlatterFX.style();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
