package com.example.vejret.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Main {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double feels_like;
    private long humidity;
    private long pressure;
    private double temp;
    private double temp_max;
    private double temp_min;

    public Main(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feelsLike) {
        this.feels_like = feelsLike;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double tempMax) {
        this.temp_max = tempMax;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double tempMin) {
        this.temp_min = tempMin;
    }


    @Override
    public String toString() {
        return "Main{" +
                ", feels_like=" + feels_like +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", temp=" + temp +
                ", temp_max=" + temp_max +
                ", temp_min=" + temp_min +
                '}';
    }
}
