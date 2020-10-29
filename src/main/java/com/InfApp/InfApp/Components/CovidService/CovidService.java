package com.InfApp.InfApp.Components.CovidService;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;



@Service
public class CovidService {

    public ArrayList<Covid> covidsList = new ArrayList<Covid>();
    public ArrayList<CovidCountry> covidsCountry = new ArrayList<CovidCountry>();

    public ArrayList<Covid> getAllCovids() throws IOException {

        URL url = new URL("https://api.covid19api.com/total/country/poland");

        Covid[] covidsTemp = creatGson(url);

        for(int i = 0; i < covidsTemp.length; i++) {
            covidsList.add(covidsTemp[i]);
        }

        return covidsList;
    }

    public ArrayList<CovidCountry> getAllCountriesCovids() throws IOException {
        URL url = new URL("https://api.covid19api.com/countries");

        creatGson(url);
        CovidCountry[] covidsTemp = creatGsonCountry(url);

        for(int i = 0; i < covidsTemp.length; i++) {
            covidsCountry.add(covidsTemp[i]);
        }

        return covidsCountry;
    }

    public ArrayList<Covid> getCovidFromBeginning(String country) throws IOException {
        covidsList.clear();

        URL url = new URL("https://api.covid19api.com/total/country/" + country);
        Covid[] covidsTemp = creatGson(url);

        for(int i = 0; i < covidsTemp.length; i++) {
            covidsList.add(covidsTemp[i]);
        }

        return covidsList;
    }

    public void addCovid(Covid covid) {
        covidsList.add(covid);
    }


    // Methods url

    public Covid[] creatGson(URL url) throws IOException {
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Covid[] covidsTemp = new Gson().fromJson(reader, Covid[].class);
        return covidsTemp;
    }

    public CovidCountry[] creatGsonCountry(URL url) throws IOException {
        InputStreamReader reader = new InputStreamReader(url.openStream());
        CovidCountry[] covidsTemp = new Gson().fromJson(reader, CovidCountry[].class);
        return covidsTemp;
    }

    // Methods url

}


