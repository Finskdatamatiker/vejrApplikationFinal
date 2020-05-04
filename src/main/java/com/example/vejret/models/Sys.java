package com.example.vejret.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double message;
    private int sunrise;
    private int sunset;
    private long type;

    public Sys(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }


    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sys{" +
                ", message=" + message +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", type=" + type +
                '}';
    }
}
