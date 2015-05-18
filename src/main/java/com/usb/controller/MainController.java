package com.usb.controller;

import com.usb.navigator.DisplayNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button deviceListButton;

    @FXML
    private Label appName;

    public void setCenter(Node node) {
        borderPane.setCenter(node);
    }

    @FXML
    private void showDeviceList(ActionEvent event) {
        DisplayNavigator.loadVista(DisplayNavigator.DEVICE_LIST);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
