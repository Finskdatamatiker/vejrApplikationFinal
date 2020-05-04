package com.example.vejret.API.services;

import com.example.vejret.API.DTOer.SamletDTO;
import com.example.vejret.services.SamletService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * HomeController bruger metoder i denne service til at hente
 * data fra RESTservice openweathermap.
 */


@org.springframework.stereotype.Service
public class RESTConsumeService implements InterfaceService {

    private final RestTemplate restTemplate;
    private final SamletService samletService;

    public RESTConsumeService(RestTemplate restTemplate, SamletService samletService) {
        this.restTemplate = restTemplate;
        this.samletService = samletService;
    }

    /**
     * Metoden henter data fra REST service "openweathermap" med RestTemplate og getForObject().
     * RestTemplate er lavet til at hente JSON og oversætter dens objekter til
     * klasser i Spring (i dette program DTO'er).
     * getForObject() udfoerer GET med URL, som den faar som parameter.
     * Respons kommer som JSON, hvis objekter modsvarer felter i klassen.
     * Respons gemmes i samletDTO (data transfer object).
     * @return
     */
    @Override
    public SamletDTO findAll(){

        String url = lavUrl();
        SamletDTO samletDTO = restTemplate.getForObject(url, SamletDTO.class);

        assert samletDTO != null;

        /*
          Icon, som er et felt i weather, konverteres til et link.
          Dette link indeholder den ikon, som dagens vejr, der er kommet til denne DTO.
          Når weather.icon vises på view, optraeder den som et link til
          openweathermap til det rigtige icon. <img th:src="@{${weather.icon}}"/>
         */
        String icon = samletDTO.getWeatherDTO().get(0).getIcon();
        icon =  "http://openweathermap.org/img/wn/" + icon + "@2x.png";
        samletDTO.getWeatherDTO().get(0).setIcon(icon);

        /*
          SamletDTO har et felt Timestamp for dato.
          Jeg giver selv her tidspunktet for, hvornaar data er hentet.
         */
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        samletDTO.setDt(ts);

        /*
         SamletDTO gives til metoden, som mapper den med entities og
         gemmer data i databasen
         */
        samletService.save(samletDTO);

        return samletDTO;


    }


    /**
     * Metoden laver URI for getForObject()
     * @return
     */
    private String lavUrl(){

        String api_url = "https://api.openweathermap.org/data/2.5/weather?zip=2000,dk";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("units", "metric")
                .queryParam("APPID", "25b2301cd13ad69ad15aa65234db2bde");
        return uriBuilder.toUriString();
    }

    /**
     * Metoden formaterer int (timestamp) til date
     */
    @Override
    public String tidFormatter(int tid){

        String svar = new SimpleDateFormat("HH:mm")
                .format(new Date(tid * 1000L));
        return svar;
    }


    public String tidFormatterDato(long tid){

        String svar = new SimpleDateFormat("dd/MM/yyyy HH:mm")
                .format(new Date(tid));
        return svar;
    }

}





