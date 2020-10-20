package com.InfApp.InfApp.Components.CovidService;

import com.google.gson.Gson;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;


@RestController
public class CovidController {

    public static  Date today = new Date(); //Calendar today = Calendar.getInstance(); // "today" is not modified
    public static  ArrayList<Covid> covidsList = new ArrayList<Covid>();


    @GetMapping("/covid")
    public ArrayList<Covid> CovidController(Model model) throws IOException {
        /*
            Getting  what country and days
        */

        String country = "poland";
        int fromDay = -10; int toDay = 0;

        if(toDay > 0){
            /* What it means ?
            If users wants to see day 30.10.2020, but today is 20.10.2020
             so toDay = 10. We on Algorithms
            */

             AlgorithmCovid(country,toDay);
        }

        ArrayList<Covid> covids = CreatURL(country,fromDay,toDay);

        return covids;
    }

    public ArrayList<Covid> CreatURL(String country, int fromDay, int toDay) throws IOException {

        URL url = new URL("https://api.covid19api.com/country/"
                + country
                + "?from=" + FormatingDate(today,fromDay) + "T00:00:00Z" +  // from the date
                "&to=" + FormatingDate(today,toDay) + "T00:00:00Z");  // To the Date


        InputStreamReader reader = new InputStreamReader(url.openStream());
        Covid[] covids = new Gson().fromJson(reader, Covid[].class);

        //ArrayList<Covid> covids = new Gson().fromJson(reader, ArrayList.class);  ArrayList > yr Mom
        //BUT if u use arrayFirst<Covid> entire array/json doesnt work. Why ? To be honest i dont know
        // I am gonna to reaserch this.
        for(int i =0; i < covids.length; i++) {
            covidsList.add(covids[i]);
        }

            return covidsList;
    }

    public String FormatingDate(Date date, int days){
        // formating date looks like 2020-10-18 *,*
        Calendar temp = Calendar.getInstance();
        SimpleDateFormat origin = new SimpleDateFormat("yyyy-MM-dd");

        if(days != 0){
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, days);
            date = c.getTime();
            return origin.format(date);
        }

        return origin.format(date);
    }

    public ArrayList<Covid> AlgorithmCovid(String country, int toDay) throws IOException {
        //first we take 14 days later getConfirmed to tab
        // tab = dayOne. we sort them
        //  i do some Magic
        //return List from today to toDay

        ArrayList<Covid> AlgoList = CreatURL(country,-14,0);
        int [] tab = new int[toDay];

        for(int i = 0; i < AlgoList.size(); i++) {
            if(i != 0)  tab[i] = ( AlgoList.get(i).getConfirmed() - AlgoList.get(i-1).getConfirmed() );
            if(tab[i] == 0) tab[i] = 1;
        }

        return AlgoList;
    }

}
