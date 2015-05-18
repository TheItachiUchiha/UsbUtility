package com.usb.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Device {

    private StringProperty name = new SimpleStringProperty();
    private StringProperty commMedium = new SimpleStringProperty();
    private IntegerProperty humidity = new SimpleIntegerProperty();
    private IntegerProperty temperature = new SimpleIntegerProperty();

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCommMedium() {
        return commMedium.get();
    }

    public StringProperty commMediumProperty() {
        return commMedium;
    }

    public void setCommMedium(String commMedium) {
        this.commMedium.set(commMedium);
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
