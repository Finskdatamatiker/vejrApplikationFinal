package com.example.vejret.API.DTOer;

public class WindDTO {

    private double deg;
    private double speed;

    public WindDTO(){}

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    @Override
    public String toString() {
        return "WindDTO{" +
                "deg=" + deg +
                ", speed=" + speed +
                '}';
    }
}
