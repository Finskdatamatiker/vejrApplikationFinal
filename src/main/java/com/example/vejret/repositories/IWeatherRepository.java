package com.example.vejret.repositories;

import com.example.vejret.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWeatherRepository extends JpaRepository<Weather, Long> {
}
