package com.usb.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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

    }

    @FXML
    void loadConfiguration(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConfigurationSetting.fxml"));
            Parent parent = loader.load();
            // If any previously loaded data
            if(container.getChildren().size()==2) {
                container.getChildren().remove(1);
            }
            container.getChildren().add(parent);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @FXML
    void loadSSID(ActionEvent event) {

    }


}
