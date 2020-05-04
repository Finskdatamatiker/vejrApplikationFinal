package com.example.vejret.services;

import com.example.vejret.models.Weather;
import com.example.vejret.repositories.IWeatherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService implements IService<Weather> {

    private final IWeatherRepository iWeatherRepository;


    public WeatherService(IWeatherRepository iWeatherRepository) {
        this.iWeatherRepository = iWeatherRepository;
    }

    @Override
    public List<Weather> findAll() {
        return null;
    }

    @Override
    public void save(Weather weather) {
        iWeatherRepository.save(weather);

    }
}
