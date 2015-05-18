package com.usb.controller;

import com.usb.navigator.DisplayNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class CalibrationSelectController {

    @FXML
    private Button humidity;

    @FXML
    private Button temperature;

    private DeviceTabController parentTabController;

    @FXML
    void openSettings(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalibrationSettings.fxml"));
            Parent parent = loader.load();
            parentTabController.setCalibrationTabContent(parent);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public void setParentTabController(DeviceTabController parentTabController) {
        this.parentTabController = parentTabController;
    }


}
