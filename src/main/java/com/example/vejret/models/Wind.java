package com.example.vejret.models;

import javax.persistence.*;

@Entity
public class Wind{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double deg;
    private double speed;

    public Wind(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return "Wind{" +
                ", deg=" + deg +
                ", speed=" + speed +
                '}';
    }
}
