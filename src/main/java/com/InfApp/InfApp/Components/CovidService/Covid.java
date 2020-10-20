package com.InfApp.InfApp.Components.CovidService;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;



public class Covid extends CovidController{
        

    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("CountryCode")
    @Expose
    private String countryCode;
    @SerializedName("Province")
    @Expose
    private String province;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("CityCode")
    @Expose
    private String cityCode;
    @SerializedName("Lat")
    @Expose
    private String lat;
    @SerializedName("Lon")
    @Expose
    private String lon;
    @SerializedName("Confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("Deaths")
    @Expose
    private Integer deaths;
    @SerializedName("Recovered")
    @Expose
    private Integer recovered;
    @SerializedName("Active")
    @Expose
    private Integer active;
    @SerializedName("Date")
    @Expose
    private String date;

    /// ==========MY Json===========
    @SerializedName("DayOne")
    @Expose
    private Integer dayOne;
    /// ==========MY Json===========

    public Covid(String country, String countryCode, int confirmed, int deaths, int recovered, int active, int dayOne, String date) {
        super();
        this.country = country;
        this.countryCode = countryCode;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.deaths = recovered;
        this.active = active;
        this.date = date;
        this.dayOne = dayOne;
    }

    public Integer getDayOne()  {
        dayOne =  covidsList.get(9).getConfirmed() - covidsList.get(8).getConfirmed();
        return  dayOne;
    }

    public void getDayOne(Integer dayOne) {
        this.dayOne = dayOne;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

