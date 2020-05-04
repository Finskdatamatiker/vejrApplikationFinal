package com.example.vejret.API.controllers;

import com.example.vejret.API.DTOer.SamletDTO;
import com.example.vejret.API.DTOer.WeatherDTO;
import com.example.vejret.API.services.InterfaceService;
import com.example.vejret.models.Samlet;
import com.example.vejret.services.SamletService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller til at sende data, som vi har hentet fra RestService
 * "Openweathermap", og data, som vi har hentet fra databasen,
 * til view.
 * Så mappings i denne Controller returnerer et view.
 * InterfaceService (RESTConsumeService) henter data fra Openweathermap.
 * SamletService henter data fra databasen.
 */

@Controller
public class HomeController {
    
    private final InterfaceService interfaceService;
    private final SamletService samletService;

    public HomeController(InterfaceService interfaceService, SamletService samletService) {
        this.interfaceService = interfaceService;
        this.samletService = samletService;
    }

    @GetMapping("/")
    public String visForside(Model model) {

        /*
         * Foerst data fra RestService (dvs. vi consumer)
         */
        SamletDTO samletDTO = interfaceService.findAll();
        WeatherDTO weather = samletDTO.getWeatherDTO().get(0);

        /*
         * sunrise og sunset -tiderne formateres til "HH:mm"
         * og dato, som er gemt som Timestamp i DTO formateres til "dd/MM/yyyy HH:mm"
         * af interfaceService (dvs. af RESTConsumerService, som henter data fra RestService)
         * Timestamp konverteres til long, som angiver sekunder siden 1.1.1970.
         * Det konverteres til dato.
         */
        String sunrise = interfaceService.tidFormatter(samletDTO.getSys().getSunrise());
        String sunset = interfaceService.tidFormatter(samletDTO.getSys().getSunset());

        Timestamp dato = samletDTO.getDt();
        long datoen = dato.getTime();
        String dag = interfaceService.tidFormatterDato(datoen);

        /*
         * sigtbarhed er angivet i meter, som formateres til km med en decimal.
         */
        String sigtbarhed = Double.toString(samletDTO.getVisibility() * 0.001);

        /*
         * al data fragtes til view i modellen
         */
        model.addAttribute("weather", weather);
        model.addAttribute("data", samletDTO);
        model.addAttribute("sunrise", sunrise);
        model.addAttribute("sunset", sunset);
        model.addAttribute("dato", dag);
        model.addAttribute("sigtbarhed", sigtbarhed);

        /*
          Saa skal vi vise historikken fra tidligere besoeg.
          Vi returnerer max 5 historiske DTO'er (har der vaeret
          faerre besoeg, saa kun dem). Der vises temperaturer og ikoner.
          samletService henter data fra databasen.
         */
        List<Samlet> historisk = samletService.findAll();


        /*
         * Datoer i listen skal formateres til "dd/MM/yyyy HH:mm".
         * InterfaceService, som ellers henter data fra RestService,
         * kan hjaelpe til, fordi den allerede har metoden til formatering.
         */



        List<String> historiskeDatoer = new ArrayList<>();
        for (int i = 0; i < historisk.size(); i++) {
            Timestamp d = historisk.get(i).getDt();
            long dat = d.getTime();
            String da = interfaceService.tidFormatterDato(dat);
            historiskeDatoer.add(da);
        }

        model.addAttribute("samlet", historisk);
        model.addAttribute("historiskeDatoer", historiskeDatoer);

        return "/index";

        }
}




