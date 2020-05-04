package com.example.vejret.API.controllers;

import com.example.vejret.API.services.RESTfulService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * RestController, hvor mappings returnerer et JSON-objekt i stedet for et view.
 * Disse JSON-objekter bliver vist på den side, som de er mappet til,
 * dvs. /hentDiagramDatoer og /hentDiagramProcenter.
 * Javascript henter data til diagrammer derfra.
 *
 * CrossOrigin tillader cross origin requests.
 *
 * RestController bruger RESTfulService til at hente data fra databasen.
 *
 * Datoer og dertil knyttede procenter er sorteret fra den
 * mindste procent til den stoerste procent.
 * De vises i den raekkefoelge i diagrammet paa view.
 */

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*")

public class RESTfulController {

    private final RESTfulService rESTfulService;

    public RESTfulController(RESTfulService rESTfulService) {
        this.rESTfulService = rESTfulService;
    }

    /**
     * Denne GetMapping returnerer JSON-objekt (her lavet som
     * en string med key-value par "dag1 - dato fra databasen" osv.),
     * når der laves get-request med URL http://localhost:1950/hentDiagramDatoer.
     * Denne request laves fra javascript.
     * Javascript bruger data til at lave et diagram.
     * JSON indeholder sorterede datoer for de sidste fem besoeg.
     */

    @GetMapping("/hentDiagramDatoer")
    public String generateDatoer() {

        List<String> historisk = rESTfulService.sammensatDatoer();
        String s;
        s = "{\"dag1\" : \""+historisk.get(0)+"\",";
        s +="\"dag2\" : \""+historisk.get(1)+"\",";
        s +="\"dag3\" : \""+historisk.get(2)+"\",";
        s +="\"dag4\" : \""+historisk.get(3)+"\",";
        s +="\"dag5\" : \""+historisk.get(4)+"\"}";

        return s;
    }

    /**
     * Denne GetMapping returnerer JSON-objekt (her lavet som
     * en string med key-value par "p1 - procenter fra databasen" osv.),
     * når der laves get-request med URL http://localhost:1950/hentDiagramProcenter.
     * Denne request laves fra javascript.
     * Javascript bruger data til at lave et diagram.
     * JSON indeholder sorterede procenter fra det mindste procent til det stoerste.
     */
    @GetMapping ("/hentDiagramProcenter")
    public String generateProcenter() {

        List<String> procenter = rESTfulService.fjernIdentifierOgLavProcenter();
        String s;
        s = "{\"p1\" : \""+procenter.get(0)+"\",";
        s +="\"p2\" : \""+procenter.get(1)+"\",";
        s +="\"p3\" : \""+procenter.get(2)+"\",";
        s +="\"p4\" : \""+procenter.get(3)+"\",";
        s +="\"p5\" : \""+procenter.get(4)+"\"}";

        return s;
    }

    //String jsonRequestString = "{\"dag\" : \""+dag1+"\"}";
}
