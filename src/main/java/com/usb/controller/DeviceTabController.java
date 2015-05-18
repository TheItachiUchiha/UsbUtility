package com.usb.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DeviceTabController implements Initializable {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab configurationTab;

    @FXML
    private Tab calibrationTab;

    @FXML
    private Tab dataDownloadTab;

    public void selectConfigurationTab() {
        tabPane.getSelectionModel().select(configurationTab);
    }

    public void selectCalibrationTab() {
        tabPane.getSelectionModel().select(calibrationTab);
    }

    public void selectDataDownloadTab() {
        tabPane.getSelectionModel().select(dataDownloadTab);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setConfigurationTabContent(Node node) {
        configurationTab.setContent(node);
    }

    public void setCalibrationTabContent(Node node) {
        calibrationTab.setContent(node);
    }

    public void setDataDownloadTabContent(Node node) {
        dataDownloadTab.setContent(node);
    }
}
