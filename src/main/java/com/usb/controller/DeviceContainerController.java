package com.usb.controller;

import com.usb.utility.FontUtil;
import com.usb.utility.PropertiesUtil;
import com.usb.utility.SideBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeviceContainerController implements Initializable {

    @FXML
    private BorderPane container;

    private final HBox topBox = new HBox();

    @FXML
    private ToggleButton configuration;
    @FXML
    private ToggleButton calibration;
    @FXML
    private ToggleButton dataDownload;

    private Button slideButton;

    private Label deviceName = new Label("Device Name : Something");

    private final  VBox boxLabelContent = new VBox();
    private final ToggleGroup group = new ToggleGroup();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Set toggle group
        calibration.setToggleGroup(group);
        configuration.setToggleGroup(group);
        dataDownload.setToggleGroup(group);

        final SideBar sideOut = new SideBar(230, 80, configuration, calibration, dataDownload);
        deviceName.getStyleClass().add("label-header-min");
        container.setLeft(sideOut);
        BorderPane.setAlignment(sideOut, Pos.CENTER);

        slideButton = sideOut.getControlButton();
        HBox tempBox = new HBox(deviceName);
        tempBox.setAlignment(Pos.CENTER);
        HBox.setHgrow(tempBox, Priority.ALWAYS);

        topBox.getChildren().setAll(slideButton, tempBox);

        boxLabelContent.getChildren().addAll(topBox, new VBox());// Vbox gets replaced later
        container.setCenter(boxLabelContent);
    }
    @FXML
    private void loadCalibration(ActionEvent action) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalibrationSelect.fxml"));
            Node node = loader.load();
            // Set the parent container
            ((CalibrationSelectController)loader.getController()).setParent(boxLabelContent);
            setBoxLabelContent(node);
            VBox.setVgrow(node, Priority.ALWAYS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void loadConfiguration(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Configuration.fxml"));
            Node node = loader.load();
            setBoxLabelContent(node);
            VBox.setVgrow(node, Priority.ALWAYS);
        } catch (IOException iox) {

        }
    }
    @FXML
    private void loadDataDownload(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DataDownload.fxml"));
            Node node = loader.load();
            setBoxLabelContent(node);
            VBox.setVgrow(node, Priority.ALWAYS);
        } catch (IOException iox) {

        }
    }

    protected void setBoxLabelContent(Node node) {
        boxLabelContent.getChildren().set(1, node);
    }

    public void fireCalibration() {
        calibration.fire();
    }

    public void fireConfiguration() {
        configuration.fire();
    }

    public void fireDataDownload() {
        dataDownload.fire();
    }
}
