package com.example.vejret.API.mapper;

import com.example.vejret.API.DTOer.SamletDTO;
import com.example.vejret.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Denne mapper knytter DTO, som faar data fra RESTservice
 * "openweatherservice", med persistence entities (dvs. med
 * model-klasserne, som repræsenterer tabeller i databasen).
 * Jeg oesnker at adskille det ansvar.
 * Saa data hentes fra RESTservice, mappes med entities og
 * gemmes i database.
 */

@Component
public class Mapper{

    public Samlet samletDTOToSamlet(SamletDTO samletDTO) {

        if(samletDTO == null){
            return null;
        }

        Samlet samlet = new Samlet();
        Coord coord = new Coord();
        Main main = new Main();
        List<Weather> weather = new ArrayList<>();
        Weather weather1 = new Weather();
        weather.add(weather1);
        Wind wind = new Wind();
        Sys sys = new Sys();
        Clouds clouds = new Clouds();
        samlet.setCoord(coord);
        samlet.setMain(main);
        samlet.setWeather(weather);
        samlet.setWind(wind);
        samlet.setSys(sys);
        samlet.setClouds(clouds);

        samlet.setBase(samletDTO.getBase());
        samlet.setCod(samletDTO.getCod());
        samlet.setDt((samletDTO.getDt()));
        samlet.setVisibility(samletDTO.getVisibility());
        samlet.setTimezone(samletDTO.getTimezone());
        samlet.setName((samletDTO.getName()));

        samlet.getCoord().setLat(samletDTO.getCoord().getLat());
        samlet.getCoord().setLon(samletDTO.getCoord().getLon());

        samlet.getMain().setFeels_like(samletDTO.getMain().getFeels_like());
        samlet.getMain().setHumidity(samletDTO.getMain().getHumidity());
        samlet.getMain().setPressure(samletDTO.getMain().getPressure());
        samlet.getMain().setTemp(samletDTO.getMain().getTemp());
        samlet.getMain().setTemp_max(samletDTO.getMain().getTemp_max());
        samlet.getMain().setTemp_min(samletDTO.getMain().getTemp_min());

        samlet.getWeather().get(0).setDescription(samletDTO.getWeatherDTO().get(0).getDescription());
        samlet.getWeather().get(0).setIcon(samletDTO.getWeatherDTO().get(0).getIcon());
        samlet.getWeather().get(0).setMain(samletDTO.getWeatherDTO().get(0).getMain());

        samlet.getWind().setDeg(samletDTO.getWind().getDeg());
        samlet.getWind().setSpeed(samletDTO.getWind().getSpeed());

        samlet.getSys().setMessage(samletDTO.getSys().getMessage());
        samlet.getSys().setSunrise(samletDTO.getSys().getSunrise());
        samlet.getSys().setSunset(samletDTO.getSys().getSunset());
        samlet.getSys().setType(samletDTO.getSys().getType());

        samlet.getClouds().setAll(samletDTO.getClouds().getAll());

        return samlet;
    }

}
