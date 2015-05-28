package com.usb.controller;

import com.usb.navigator.DisplayNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button deviceListButton;

    @FXML
    private Label appName;

    @FXML
    private ComboBox<String> themeChange;

    public void setCenter(Region node) {

        borderPane.setCenter(node);
        borderPane.prefHeightProperty().bind(node.heightProperty().add(80));
    }

    @FXML
    private void showDeviceList(ActionEvent event) {
        DisplayNavigator.loadVista(DisplayNavigator.DEVICE_LIST);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        themeChange.valueProperty().addListener((ov, oldValue, newValue) -> {
            if(newValue.equalsIgnoreCase("Dark Theme")) {
                themeChange.getScene().getStylesheets().clear();
                themeChange.getScene().getStylesheets().add(getClass().getResource("/css/darktheme.css").toExternalForm());
            } else {
                themeChange.getScene().getStylesheets().clear();
                themeChange.getScene().getStylesheets().add(getClass().getResource("/css/lighttheme.css").toExternalForm());
            }
        });
    }

    public void selectDefaultTheme() {
        //Change to default theme
        themeChange.getSelectionModel().select(0);
    }

    public void loadDevices () {
        deviceListButton.fire();
    }
}
