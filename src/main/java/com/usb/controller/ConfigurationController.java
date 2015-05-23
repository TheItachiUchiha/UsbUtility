package com.usb.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by itachi on 18/5/15.
 */
public class ConfigurationController {

    @FXML
    private VBox container;

    @FXML
    private Button configuration;

    @FXML
    private Button ssid;

    @FXML
    private Button communication;

    @FXML
    void loadCommunication(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CommunicationSetting.fxml"));
            Parent parent = loader.load();
            container.getChildren().set(1, parent);
            VBox.setVgrow(parent, Priority.ALWAYS);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @FXML
    void loadConfiguration(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConfigurationSetting.fxml"));
            Parent parent = loader.load();
            container.getChildren().set(1, parent);
            VBox.setVgrow(parent, Priority.ALWAYS);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @FXML
    void loadSSID(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConfigurationSsid.fxml"));
            Parent parent = loader.load();
            container.getChildren().set(1, parent);
            VBox.setVgrow(parent, Priority.ALWAYS);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
