package com.usb.controller;

import com.usb.beans.Device;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *  Controller for DeviceList.fxml which keeps an accordion and show them on the screen
 */
public class DeviceListController implements Initializable {

    @FXML
    private Accordion accordion;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Bind the scrollpane height and width to vbox
        accordion.prefWidthProperty().bind(scrollPane.widthProperty());

        // Fetch list of devices and populate them

        //For each device load the Device FXML and add them
        try {
            ObservableList<Device> list = loadDummyValue();
            for(Device device : list) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Device.fxml"));
                TitledPane pane = loader.load();
                DeviceController controller = loader.getController();
                controller.setDetails(device);
                accordion.getPanes().add(pane);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ObservableList<Device> loadDummyValue() {
        ObservableList<Device> list = FXCollections.observableArrayList();

        for( int i=0; i< 3; i++) {
            Device device = new Device();
            device.setName("Device"+String.valueOf(i));
            device.setCommMedium("Eth"+String.valueOf(i));
            device.setHumidity((int)(Math.random()*100));
            device.setTemperature((int)(Math.random()*100));
            device.setSupportedTypes("Humidity, Temperature");
            list.add(device);
        }

        return list;
    }
}
