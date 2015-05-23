package com.usb.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by itachi on 18/5/15.
 */
public class SSIDController implements Initializable {

    @FXML
    private VBox vbox;

    private Image image;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image = new Image(getClass().getResource("/images/wifi.png").toExternalForm());
        vbox.getChildren().setAll(loadDummyData());
    }

    // Only for testing purpose
    private List<HBox> loadDummyData() {

        List<HBox> list = new ArrayList<>();
        for (int i=0; i<3; i++) {
            HBox hBox = new HBox();
            hBox.setSpacing(20);
            Label label = new Label("Device " + i);
            ImageView view = new ImageView(image);
            hBox.getChildren().addAll(label, view);
            list.add(hBox);
        }
        return list;
    }
}
