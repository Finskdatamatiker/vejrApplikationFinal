package com.example.vejret.models;

import javax.persistence.*;

@Entity
public class Coord /*extends BaseEntity*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double lon;
    private double lat;

    public Coord(){}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public double getLon() {
        return lon;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }


    @Override
    public String toString() {
        return "lon=" + lon +
                ", lat=" + lat;
    }
}
