package com.InfApp.InfApp.Components.CovidService;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    public ArrayList<Covid> getCovidDataFromDateToAnotherDate(String country, String fromDate, String toDate) throws IOException, ParseException {
        covidsDataList.clear();

        // Example:
        //https://api.covid19api.com/country/poland/status/confirmed?from=2020-09-19T00:00:00Z&to=2020-09-20T00:00:00Z
        //2020-09-19T00:00:00Z

        // date to Calendar/date
        // date = day - 1
        //And this:

        URL url = new URL("https://api.covid19api.com/total/country/" + country
                + "/status/confirmed?from="
                    + fromDate + "T00:00:00Z"
                        + "&to="
                            + toDate + "T00:00:00Z");

        Covid[] covidsTemp = creatGson(url);

        tabToListData(covidsTemp);

        return covidsDataList;
    }

    public void addCovid(Covid covid) {
        covidsDataList.add(covid);
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


