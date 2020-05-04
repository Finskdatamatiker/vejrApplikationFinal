package com.example.vejret.services;

import com.example.vejret.API.DTOer.SamletDTO;
import com.example.vejret.API.mapper.Mapper;
import com.example.vejret.models.Samlet;
import com.example.vejret.repositories.SamletRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
    Denne servive bruges alle de andre services ogsaa, fordi Samlet
    har de andre model-klasser som sine felter.
    Denne service bruges i RESTConsumeService til at gemme samletDTO
    til databasen som Samlet.
    Denne service bruges ogsaa i HomeController til at hente historisk
    data fra databasen.
 */
@Service
public class SamletService {

    private final SamletRepository samletRepository;
    private final CoordService coordService;
    private final MainService mainService;
    private final SysService sysService;
    private final WeatherService weatherService;
    private final WindService windService;
    private final CloudsService cloudsService;
    private final Mapper mapper;

    public SamletService(SamletRepository samletRepository, CoordService coordService, MainService mainService, SysService sysService, WeatherService weatherService, WindService windService, CloudsService cloudsService, Mapper mapper){
        this.samletRepository = samletRepository;
        this.coordService = coordService;
        this.mainService = mainService;
        this.sysService = sysService;
        this.weatherService = weatherService;
        this.windService = windService;
        this.cloudsService = cloudsService;
        this.mapper = mapper;
    }


    /*
     * Jeg vil kun returnere max de sidste fem besoeg paa siden
     * til HomeController
     */
    public List<Samlet> findAll() {
        List<Samlet> list = new ArrayList<>();

        for(Samlet s : samletRepository.findAll()){
            list.add(s);
        }

        List<Samlet> maxFem = new ArrayList<>();

        /*
           Hvis der er flere end fem, looper jeg bagfra
           de sidste fem.
         */
        if(list.size()> 6) {
            for(int i = list.size()-1; i > list.size()-6; i--){
                Samlet element = list.get(i);
                maxFem.add(element);
            }

        }
        else{
            maxFem = list;
        }

        return maxFem;
    }

    /*
     * Her gemmer jeg Samlet saadan, at jeg mapper SamletDTO
     * men Samlet med Mapper og gemmer derefter.
     * Der er altid kun ét weather knyttet til DTO, men
     * den figurerer som list i JSON, saa er ogsaa List i programmet.
     */

    public void save(SamletDTO samletDTO) {

        Samlet samlet = mapper.samletDTOToSamlet(samletDTO);
        coordService.save(samlet.getCoord() );
        mainService.save(samlet.getMain());
        sysService.save(samlet.getSys());
        weatherService.save(samlet.getWeather().get(0));
        windService.save(samlet.getWind());
        cloudsService.save(samlet.getClouds());
        samletRepository.save(samlet);
    }

}
