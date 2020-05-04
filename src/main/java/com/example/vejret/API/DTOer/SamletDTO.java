package com.example.vejret.API.DTOer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;

/**
 * Data Transfer Object DTO, som bruges til at
 * hente data fra REST service "openweathermap"
 * DTO'er modsvarer JSON-objekter.
 */
public class SamletDTO{

    private CoordDTO coord;

    private MainDTO main;
    //for at matche med feltet weather i POJO-Weather
    @JsonProperty("weather")
    private List<WeatherDTO> weatherDTO;
    private WindDTO wind;
    private SysDTO sys;
    private CloudsDTO clouds;

    private String base;
    private int cod;
    private Timestamp dt;
    private int timezone;
    private int visibility;
    private String name;


    public SamletDTO(){}

    public CoordDTO getCoord() {
        return coord;
    }
    public MainDTO getMain() {
        return main;
    }
    public void setMain(MainDTO main) {
        this.main = main;
    }
    public List<WeatherDTO> getWeatherDTO() {
        return weatherDTO;
    }
    public WindDTO getWind() {
        return wind;
    }
    public SysDTO getSys() {
        return sys;
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
    public CloudsDTO getClouds() {
        return clouds;
    }
    public void setClouds(CloudsDTO clouds) {
        this.clouds = clouds;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCoord(CoordDTO coord) {
        this.coord = coord;
    }
    public void setWeatherDTO(List<WeatherDTO> weatherDTO) {
        this.weatherDTO = weatherDTO;
    }
    public void setWind(WindDTO wind) {
        this.wind = wind;
    }
    public void setSys(SysDTO sys) {
        this.sys = sys;
    }
}
