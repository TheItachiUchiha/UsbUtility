package com.usb.controller;

import com.usb.beans.Device;
import com.usb.navigator.DisplayNavigator;
import com.usb.utility.ApplicationConstants;
import com.usb.utility.FontUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Device.fxml
 *
 * Shows data for each device along with three options
 */
public class DeviceController implements Initializable {

    @FXML
    private TitledPane titledPane;

    @FXML
    private Label humidity;

    @FXML
    private Label temperature;

    @FXML
    private Button configuration;

    @FXML
    private Button calibration;

    @FXML
    private Button dataDownload;

    public void setDetails(Device device) {
        titledPane.setText("Device : "  + device.getName() + "\n\n" + "Communication Medium : " + device.getCommMedium() );
        humidity.setText("Humidity : " + device.getHumidity() + ApplicationConstants.SPACE + "%");
        temperature.setText("Temperature : " + device.getTemperature() + ApplicationConstants.SPACE + "C");
    }

    @FXML
    void openCalibration(ActionEvent event) {
        FXMLLoader loader = DisplayNavigator.loadVista(DisplayNavigator.DEVICE_CONTAINER);
        DeviceContainerController container = loader.getController();
        container.fireCalibration();
    }

    @FXML
    void openConfiguration(ActionEvent event) {
        FXMLLoader loader = DisplayNavigator.loadVista(DisplayNavigator.DEVICE_CONTAINER);
        DeviceContainerController container = loader.getController();
        container.fireConfiguration();
    }

    @FXML
    void openDataDownload(ActionEvent event) {
        FXMLLoader loader = DisplayNavigator.loadVista(DisplayNavigator.DEVICE_CONTAINER);
        DeviceContainerController container = loader.getController();
        container.fireDataDownload();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // configuration.setGraphic(FontUtil.CONFIGURATION_FONT);
       // calibration.setGraphic(FontUtil.CALIBRATION_FONT);
       // dataDownload.setGraphic(FontUtil.DATA_DOWNLOAD_FONT);
    }
}
