package com.usb.controller;

import com.usb.beans.Reading;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class DataDownloadController implements Initializable {

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private TableView<Reading> tableView;

    @FXML
    private VBox vBox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button exportToPDF;

    @FXML
    private Button exportToExcel;

    private final ObservableList<Reading> data =
            FXCollections.observableArrayList(
                    new Reading(1, "2015-26-FXML3 12:11 pm", 10, 50),
                    new Reading(2, "2015-26-3 12:10 pm", 11, 51),
                    new Reading(3, "2015-26-3 12:09 pm", 12, 52),
                    new Reading(4, "2015-26-3 12:08 pm", 13, 53),
                    new Reading(5, "2015-26-3 12:07 pm", 14, 54));


    private void loadDummyValuesInGraph() {
       // final CategoryAxis xAxis = new CategoryAxis();
       // final NumberAxis yAxis = new NumberAxis();


        lineChart.getXAxis().setLabel("Serial No");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Column P");

        series1.getData().add(new XYChart.Data("1", 23));
        series1.getData().add(new XYChart.Data("2", 14));
        series1.getData().add(new XYChart.Data("3", 15));
        series1.getData().add(new XYChart.Data("4", 24));
        series1.getData().add(new XYChart.Data("5", 34));
        series1.getData().add(new XYChart.Data("6", 36));
        series1.getData().add(new XYChart.Data("7", 22));
        series1.getData().add(new XYChart.Data("8", 45));
        series1.getData().add(new XYChart.Data("9", 43));
        series1.getData().add(new XYChart.Data("10", 17));
        series1.getData().add(new XYChart.Data("11", 29));
        series1.getData().add(new XYChart.Data("12", 25));


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Column O");

        series2.getData().add(new XYChart.Data("1", 12));
        series2.getData().add(new XYChart.Data("2", 23));
        series2.getData().add(new XYChart.Data("3", 14));
        series2.getData().add(new XYChart.Data("4", 31));
        series2.getData().add(new XYChart.Data("5", 12));
        series2.getData().add(new XYChart.Data("6", 19));
        series2.getData().add(new XYChart.Data("7", 31));
        series2.getData().add(new XYChart.Data("8", 21));
        series2.getData().add(new XYChart.Data("9", 34));
        series2.getData().add(new XYChart.Data("10", 41));
        series2.getData().add(new XYChart.Data("11", 29));
        series2.getData().add(new XYChart.Data("12", 96));

        lineChart.getData().addAll(series1, series2);
    }

    public void loadDummyDataInTableView(){
        TableColumn srColumn = new TableColumn("Sr No");
        srColumn.setCellValueFactory(
                new PropertyValueFactory<>("srNo"));
        TableColumn timeStampColumn = new TableColumn("TimeStamp");
        timeStampColumn.setCellValueFactory(
                new PropertyValueFactory<Reading, String>("timeStamp"));
        TableColumn humidityColumn = new TableColumn("Humidity");
        humidityColumn.setCellValueFactory(
                new PropertyValueFactory<Reading, String>("humidity"));
        TableColumn tempColumn = new TableColumn("Temperature");
        tempColumn.setCellValueFactory(
                new PropertyValueFactory<Reading, String>("temperature"));

        tableView.getColumns().removeAll();
        tableView.getColumns().addAll(srColumn, timeStampColumn, humidityColumn, tempColumn);
        tableView.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vBox.prefWidthProperty().bind(scrollPane.widthProperty());
        //tableView.prefWidthProperty().bind(vBox.widthProperty());


        loadDummyValuesInGraph();
        loadDummyDataInTableView();
    }
}