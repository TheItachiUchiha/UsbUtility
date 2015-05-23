package com.usb.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by abhinay_agarwal on 18/05/15.
 */
public class Reading {

    private IntegerProperty srNo = new SimpleIntegerProperty();
    private StringProperty timeStamp = new SimpleStringProperty();
    private IntegerProperty humidity = new SimpleIntegerProperty();
    private IntegerProperty temperature = new SimpleIntegerProperty();

    public Reading(int srNo, String timeStamp, int humidity, int temperature) {
        this.srNo.set(srNo);
        this.timeStamp.set(timeStamp);
        this.humidity.set(humidity);
        this.temperature.set(temperature);
    }

    public int getSrNo() {
        return srNo.get();
    }

    public IntegerProperty srNoProperty() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo.set(srNo);
    }

    public String getTimeStamp() {
        return timeStamp.get();
    }

    public StringProperty timeStampProperty() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp.set(timeStamp);
    }

    public int getHumidity() {
        return humidity.get();
    }

    public IntegerProperty humidityProperty() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity.set(humidity);
    }

    public int getTemperature() {
        return temperature.get();
    }

    public IntegerProperty temperatureProperty() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature.set(temperature);
    }
}
