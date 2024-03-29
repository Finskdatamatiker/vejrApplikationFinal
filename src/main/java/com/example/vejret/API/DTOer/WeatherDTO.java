package com.example.vejret.API.DTOer;

public class WeatherDTO {

    private String description;
    private String icon;
    private String main;

    public WeatherDTO(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }


    @Override
    public String toString() {
        return "WeatherDTO{" +
                "description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", main='" + main + '\'' +
                '}';
    }
}
