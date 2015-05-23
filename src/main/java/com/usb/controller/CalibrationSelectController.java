package com.usb.controller;

import com.usb.navigator.DisplayNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CalibrationSelectController {

    @FXML
    private Button humidity;

    @FXML
    private Button temperature;

    private VBox parent;

    @FXML
    void openSettings(ActionEvent event) {
        try {
            JPanel panel = new JPanel();
            panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalibrationSettings.fxml"));
            Parent parent = loader.load();
            this.parent.getChildren().set(1, parent);
            VBox.setVgrow(parent, Priority.ALWAYS);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    /**
     *  TODO
     *  Change this method to something better
     */
    public void setParent(VBox box) {
        parent = box;
    }


}
