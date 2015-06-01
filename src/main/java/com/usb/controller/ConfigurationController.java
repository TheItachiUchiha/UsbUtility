package com.usb.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by itachi on 18/5/15.
 */
public class ConfigurationController implements Initializable {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox container;

    @FXML
    private ToggleButton configuration;

    @FXML
    private ToggleButton ssid;

    @FXML
    private ToggleButton communication;

    private ToggleGroup group = new ToggleGroup();

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        communication.setToggleGroup(group);
        configuration.setToggleGroup(group);
        ssid.setToggleGroup(group);
        container.prefWidthProperty().bind(scrollPane.widthProperty());
        configuration.fire();
    }
}
