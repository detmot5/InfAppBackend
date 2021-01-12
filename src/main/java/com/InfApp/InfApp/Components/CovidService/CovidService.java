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

        increaseToListData(covidsTemp);

        return covidsDataList;
    }

    public ArrayList<CovidCountry> getAllCountriesCovids() throws IOException {
        URL url = new URL("https://api.covid19api.com/countries");

        creatGson(url);
        CovidCountry[] covidsTemp = creatGsonCountry(url);

        increaseToListCountry(covidsTemp);

        return covidsCountry;
    }

    public ArrayList<Covid> getCovidFromBeginning(String country) throws IOException {
        covidsDataList.clear();

        URL url = new URL("https://api.covid19api.com/total/country/" + country);
        Covid[] covidsTemp = creatGson(url);

        increaseToListData(covidsTemp);

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

        result = AlgorithmIncrease(result,country);
        result = AlgorithmPredictionsForTomorrow(result);

        return result;
    }

    public Covid getOneCovidDaysFromCountry(String country, Integer days) throws IOException{
        var covidDays = getCovidFromBeginning(country);
        Integer covidBegin = covidDays.size() - 1;
        Integer covidEnd = covidDays.size() - 1 - days;

        Covid[] result1 = new Covid[days];
        Covid result;

        for(int iterator = 0, i = covidBegin; i > covidEnd; i--){
            result1[iterator] = covidDays.get(i);
        }

        result = covidDays.get(days - 1);

        return result;
    }

    public Covid[] AlgorithmIncrease(Covid[] result, String country) throws IOException {

        for(int i = 0; i < result.length; i++){
            if(i == result.length - 1){
                Covid tempCovid = getOneCovidDaysFromCountry(country, result.length + 1);
                result[i].setIncrease(result[i].getConfirmed()  - tempCovid.getConfirmed() );
            }else result[i].setIncrease(result[i].getConfirmed() - result[i + 1].getConfirmed());
        }

        return result;
    }

    public Covid[] AlgorithmPredictionsForTomorrow(Covid[] result) {

        int []increase = new int[result.length];
        
        for(int i = 0; i < result.length; i++){
            if(i == result.length - 1){
                increase[i] = 0;
            }else increase[i] = result[i].getConfirmed() - result[i + 1].getConfirmed();
        }

        float [] percentageOfDailyGain = calculatesPrecentageOfDailyGain(increase, result);

        float average = calculationOfTheAveragePercentageIncrease(percentageOfDailyGain, result);

        int out = (int) ((increase[0] * (100 + (average / 2)) )/100);

        result[0].setTomorrowIncrease(out);

        return result;
    }

    public float calculationOfTheAveragePercentageIncrease(float[] percentageOfDailyGain, Covid[] result){
        float srednia = 0;

        for(int i = 1; i < result.length/2; i++){
            srednia += percentageOfDailyGain[i];
        }

        float out = srednia/(result.length/2);

        return out;
    }

    public float[] calculatesPrecentageOfDailyGain(int[] increase, Covid[] result){
        float [] procenty = new float[result.length];

        for(int i = 2, z = 0; i < result.length; i++){
            if(increase[i-1] <= increase[i]) {
                procenty[z] = (float) (increase[i - 1] * 100) / increase[i];
                procenty[z] = 100 - procenty[z];
            }else{
                procenty[z] = (float) (increase[i] * 100) / increase[i-1];
                procenty[z] = 100 - procenty[z];
            }
            z++;i++;
        }

        return procenty;
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

    //increase to list
    public ArrayList<Covid> increaseToListData(Covid[] covidsTemp){
        for(int i = 0; i < covidsTemp.length; i++) {
            covidsDataList.add(covidsTemp[i]);
        }
        return covidsDataList;
    }
    public ArrayList<CovidCountry> increaseToListCountry(CovidCountry[] covidsTemp){
        for(int i = 0; i < covidsTemp.length; i++) {
            covidsCountry.add(covidsTemp[i]);
        }
        return covidsCountry;
    }

    //increase to list


}


