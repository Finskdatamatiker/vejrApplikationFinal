package com.example.vejret.API.DTOer;

public class MainDTO  {

    private double feels_like;
    private long humidity;
    private long pressure;
    private double temp;
    private double temp_max;
    private double temp_min;


    public MainDTO(){}

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
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


    @Override
    public String toString() {
        return "MainDTO{" +
                "feelsLike=" + feels_like +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", temp=" + temp +
                ", tempMax=" + temp_max +
                ", tempMin=" + temp_min +
                '}';
    }
}
