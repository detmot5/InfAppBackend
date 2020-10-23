package com.InfApp.InfApp.Components.CovidService;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;



@Service
public class CovidService {

    public ArrayList<Covid> covids = new ArrayList<Covid>();

    public ArrayList<Covid> getAllCovids(){

        return covids;
    }

    public ArrayList<Covid> getAllCountriesCovids() throws IOException {
        URL url = new URL("https://api.covid19api.com/countries");


        InputStreamReader reader = new InputStreamReader(url.openStream());
        Covid[] covidsTemp = new Gson().fromJson(reader, Covid[].class);

        for(int i =0; i < covidsTemp.length; i++) {
            covids.add(covidsTemp[i]);
        }

        return covids;
    }

    public Covid getCovid(String country) {
        return covids.stream().filter(t->t.getCountry().equals(country)).findFirst().get();
    }


}
