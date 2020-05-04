package com.example.vejret.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Samlet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    protected Coord coord;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Main main;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<Weather> weather;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Wind wind;
    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Sys sys;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Clouds clouds;


    private String base;
    private int cod;
    private Timestamp dt;
    private int timezone;
    private int visibility;
    private String name;


    public Samlet(){ }

  /*  public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Timestamp getDt() {
        return dt;
    }

    public void setDt(Timestamp dt) {
        this.dt = dt;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Samlet{" +
                "coord=" + coord +
                ", main=" + main +
                ", weather=" + weather +
                ", wind=" + wind +
                ", sys=" + sys +
                ", clouds=" + clouds +
                ", base='" + base + '\'' +
                ", cod=" + cod +
                ", dt=" + dt +
                ", timezone=" + timezone +
                ", visibility=" + visibility +
                ", name='" + name + '\'' +
                '}';
    }
}
