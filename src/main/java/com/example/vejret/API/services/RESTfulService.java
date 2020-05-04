package com.example.vejret.API.services;

import com.example.vejret.models.Samlet;
import com.example.vejret.services.SamletService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/*
    Denne service bruger samletService til at hente historisk data
    fra databasen. Det er RESTfulController, som skal bruge dataen.
    Der skal hentes datoer og luftfugtigheds-procenter fra de fem sidste
    besoeg paa siden.
    De skal sorteres efter procenterne fra det mindste til det stoerste.
    Datoer skal tilsvarende sorteres, saadan at de foelger procenterne.
    Sorteret data bruges i diagrammet, som javascript laver.
 */
@Service
public class RESTfulService {

    private final SamletService samletService;

    public RESTfulService(SamletService samletService) {
        this.samletService = samletService;
    }

    /**
     * Ud fra alle besoeg gemmes max fem datoer.
     * @return
     */
    public List<Samlet> hentDataFraDatabasen(){

        List<Samlet> alle = samletService.findAll();
        List<Samlet> femSidsteSamlet = new ArrayList<>();

        int size = alle.size();

        if(alle.size() > 0) femSidsteSamlet.add(alle.get(size-1));
        if(alle.size() > 1) femSidsteSamlet.add(alle.get(size-2));
        if(alle.size() > 2) femSidsteSamlet.add(alle.get(size-3));
        if(alle.size() > 3) femSidsteSamlet.add(alle.get(size-4));
        if(alle.size() > 4) femSidsteSamlet.add(alle.get(size-5));

        return femSidsteSamlet;
    }

    /**
     * Datoerne skal hentes fra de fem besoeg.
     * Feltet "dato" i Samlet er gemt som Timestamp.
     * Den skal konverteres til long, som giver sekunder siden 1.1.1970.
     * Saa kan long konverteres til String ved hjaelp af SimpleDaraFormat
     * med metoden tidFormatterDato(), som findes i denne klasse.
     * Dermed gemmes dato som String, som JSON kan bruge.
     * @return
     */
    public List<String> hentDatoerFraDatabasen(){

        List<Samlet> historisk = hentDataFraDatabasen();
        List<String> historiskeDatoer = new ArrayList<>();

        for(int i = 0; i < historisk.size(); i++){
            Timestamp d = historisk.get(i).getDt();
            long dat = d.getTime();
            String da = tidFormatterDato(dat);
            historiskeDatoer.add(da);
        }
        return historiskeDatoer;
    }

    /*
       Saa skal vi henter luftfugtighedsprocenter fra de fem besoeg.
       De kommer som long, som konverteres til String til JSON.
     */

    public List<String> hentProcenterFraDatabasen() {

        List<Samlet> historisk = hentDataFraDatabasen();
        List<String> svar = new ArrayList<>();

        for(int i = 0; i < historisk.size(); i++){
            svar.add(Long.toString(historisk.get(i).getMain().getHumidity()));
        }

        return svar;
    }


    /*
        Procenter og dermed ogsaa datoer skal sorteres fra det mindste
        procent til det stoerste procent. Saadan vil jeg vise dem i diagrammet.

        Jeg gemmer dem i TreeMap, som sorterer elementer efter keys fra mindst til stoerst.
        Procenter er keys og datoer er vaerdier.
        Procent 0 modsvarer dag 0, men jeg ved bare ikke, i hvilken raekkefoelge
        de ender i TreeMap. Men jeg ved, at de er sorterede.

        Map accepterer ikke dubletter blandt keys, saa jeg tilfoejer bogstaverne a-d
        for at keys er autentiske.
     */
    public Map<String, String> lavMapMedDatoerOgProcenter(){

        List<String> dataTilProcenter = hentProcenterFraDatabasen();
        List<String> dataTilDatoer = hentDatoerFraDatabasen();

        Map<String, String> sammensat = new TreeMap<>();
        sammensat.put(dataTilProcenter.get(0) + "a", dataTilDatoer.get(0));
        sammensat.put(dataTilProcenter.get(1) + "b", dataTilDatoer.get(1));
        sammensat.put(dataTilProcenter.get(2) + "c", dataTilDatoer.get(2));
        sammensat.put(dataTilProcenter.get(3) + "d", dataTilDatoer.get(3));
        sammensat.put(dataTilProcenter.get(4) + "e", dataTilDatoer.get(4));

        return sammensat;

    }

    /*
         Efter at dato-procent er sorteret, vil jeg sende dem hver
         for sig til RESTfulController, som returnerer dem i to forskellige
         JSON'er, fordi de bruges forskellige steder i diagrammet.
         Det er values fra TreeMap, som er datoerne.
         values() i TreeMap returnerer Collection med vaerdierne.
         Jeg gemmer collectionen i arrayliste her.
     */

    public List<String> sammensatDatoer() {

        return new ArrayList<>(lavMapMedDatoerOgProcenter().values());
    }

    /*
        Ogsaa procenter skal til RESTFulController. Jeg skal bare fjerne
        bogstaverne a-d. fra dem. Det er keys fra TreeMap, som er procenterne.
        keySet() fra TreeMap returnerer Set af keys. Accepterer ikke dubletter.
        Jeg giver dette set til en arrayliste.
     */

    public List<String> fjernIdentifierOgLavProcenter() {

        ArrayList<String> procenter = new ArrayList<>(lavMapMedDatoerOgProcenter().keySet());

        ArrayList<String> sendProcenter = new ArrayList<>();
        sendProcenter.add(procenter.get(0).substring(0,procenter.get(0).length()-1));
        sendProcenter.add(procenter.get(1).substring(0,procenter.get(1).length()-1));
        sendProcenter.add(procenter.get(2).substring(0,procenter.get(2).length()-1));
        sendProcenter.add(procenter.get(3).substring(0,procenter.get(3).length()-1));
        sendProcenter.add(procenter.get(4).substring(0,procenter.get(4).length()-1));

        return sendProcenter;
    }

    /*
        Tiden angivet som long kan formateres til String som
        dato med SimpleDateFormat.
     */
    public String tidFormatterDato(long tid){

        String svar = new SimpleDateFormat("dd/MM/yyyy HH:mm")
                .format(new Date(tid));
        return svar;
    }

}
