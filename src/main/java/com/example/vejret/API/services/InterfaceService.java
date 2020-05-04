package com.example.vejret.API.services;

import com.example.vejret.API.DTOer.SamletDTO;

/**
 * Interface, som HomeController kan kalde paa,
 * naar den skal have data fra RESTservice openweathermap.
 * Implementeringer hentes fra RESTConsumeService.
 */

public interface InterfaceService {

    SamletDTO findAll();
    String tidFormatter(int tid);
    String tidFormatterDato(long tid);

}
