package com.example.vejret.API.DTOer;

public class CoordDTO {

    private double lon;
    private double lat;

    public CoordDTO(){}

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
        return "CoordDTO{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
