package com.InfApp.InfApp.Components.CovidService;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

@Service
public class CovidService {

    public ArrayList<Covid> covidsDataList = new ArrayList<Covid>();
    public ArrayList<CovidCountry> covidsCountry = new ArrayList<CovidCountry>();

    public ArrayList<Covid> getAllCovids() throws IOException {

        URL url = new URL("https://api.covid19api.com/total/country/poland");

        Covid[] covidsTemp = creatGson(url);

        tabToListData(covidsTemp);

        return covidsDataList;
    }

    public ArrayList<CovidCountry> getAllCountriesCovids() throws IOException {
        URL url = new URL("https://api.covid19api.com/countries");

        creatGson(url);
        CovidCountry[] covidsTemp = creatGsonCountry(url);

        tabToListCountry(covidsTemp);

        return covidsCountry;
    }

    public ArrayList<Covid> getCovidFromBeginning(String country) throws IOException {
        covidsDataList.clear();

        URL url = new URL("https://api.covid19api.com/total/country/" + country);
        Covid[] covidsTemp = creatGson(url);

        tabToListData(covidsTemp);

        return covidsDataList;
    }


    public Covid[] getNCovidDaysFromCountry(String country, Integer days) throws IOException{
        var covidDays = getCovidFromBeginning(country);
        Integer covidBegin = covidDays.size() - 1;
        Integer covidEnd = covidDays.size() - 1 - days;

        Covid[] result = new Covid[days];

        for(int iterator = 0, i = covidBegin; i > covidEnd; i--){
            result[iterator] = covidDays.get(i);
            iterator++;
        }

        result = AlgorithmIncrease(result);

        return result;
    }

    public Covid[] AlgorithmIncrease(Covid[] result) {

        for(int i = 0; i < result.length; i++){
            if(i == result.length - 1){
                result[i].setIncrease(0);
            }else result[i].setIncrease(result[i].getConfirmed() - result[i + 1].getConfirmed());
        }

        return result;
    }





    public void addCovid(Covid covid) {
        covidsDataList.add(covid);
    }

    public void updateCovid(String country, Covid covid){
        for(int i = 0; i < covidsDataList.size(); i++){
            Covid t = covidsDataList.get(i);
            if(t.getCountry().equals(country)){
                covidsDataList.set(i,covid);
                return;
            }
        }
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

    //Tab to list
    public ArrayList<Covid> tabToListData(Covid[] covidsTemp){
        for(int i = 0; i < covidsTemp.length; i++) {
            covidsDataList.add(covidsTemp[i]);
        }
        return covidsDataList;
    }
    public ArrayList<CovidCountry> tabToListCountry(CovidCountry[] covidsTemp){
        for(int i = 0; i < covidsTemp.length; i++) {
            covidsCountry.add(covidsTemp[i]);
        }
        return covidsCountry;
    }

    //Tab to list


}


