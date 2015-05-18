package com.usb.controller;

import com.usb.beans.Device;
import com.usb.navigator.DisplayNavigator;
import com.usb.utility.ApplicationConstants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

import java.io.IOException;

/**
 * Controller for Device.fxml
 *
 * Shows data for each device along with three options
 */
public class DeviceController {

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
        FXMLLoader loader = DisplayNavigator.loadVista(DisplayNavigator.DEVICE_TAB);
        DeviceTabController tabController = loader.getController();
        loadTabContents(tabController);
        tabController.selectCalibrationTab();
    }

    @FXML
    void openConfiguration(ActionEvent event) {
        FXMLLoader loader = DisplayNavigator.loadVista(DisplayNavigator.DEVICE_TAB);
        DeviceTabController tabController = loader.getController();
        loadTabContents(tabController);
        tabController.selectConfigurationTab();
    }

    @FXML
    void openDataDownload(ActionEvent event) {
        FXMLLoader loader = DisplayNavigator.loadVista(DisplayNavigator.DEVICE_TAB);
        DeviceTabController tabController = loader.getController();
        loadTabContents(tabController);
        tabController.selectDataDownloadTab();
    }

    private void loadTabContents(DeviceTabController tabController) {
        try {
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/fxml/CalibrationSelect.fxml"));
            tabController.setCalibrationTabContent((Node) loader1.load());
            ((CalibrationSelectController)loader1.getController()).setParentTabController(tabController);
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/fxml/Configuration.fxml"));
            tabController.setConfigurationTabContent((Node) loader2.load());
            /*FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/fxml/Configuration.fxml"));
            tabController.setDataDownloadTabContent((Node) loader3.load());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
