package com.InfApp.InfApp.Components.CovidService;

public class Covid{

    private String Country;
    private String CountryCode;
    private String Province;
    private String City;
    private String CityCode;
    private String Lat;
    private String Lon;
    private Integer Confirmed;
    private Integer Deaths;
    private Integer Recovered;
    private Integer Active;
    private String Date;


    public Covid(String Country, String CountryCode, String Province, String City, String CityCode, String Lat, String Lon,
                 Integer Confirmed, Integer Deaths, Integer Recovered, Integer Active, String Date, Integer DayOne) {

        this.Country = Country;
        this.Province = Province;
        this.City = City;
        this.CityCode = CityCode;
        this.Lat = Lat;
        this.Lon = Lon;
        this.Confirmed = Confirmed;
        this.Deaths = Deaths;
        this.Recovered = Recovered;
        this.Active = Active;
        this.Date = Date;
        this.CountryCode = CountryCode;

    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCountryCode() { return CountryCode; }

    public void setCountryCode(String countryCode) { CountryCode = countryCode; }

    public String getProvince() { return Province; }

    public void setProvince(String province) { Province = province; }

    public String getCity() { return City; }

    public void setCity(String city) { City = city; }

    public String getCityCode() { return CityCode; }

    public void setCityCode(String cityCode) { CityCode = cityCode; }

    public String getLat() { return Lat; }

    public void setLat(String lat) { Lat = lat; }

    public String getLon() { return Lon; }

    public void setLon(String lon) { Lon = lon; }

    public Integer getConfirmed() { return Confirmed; }

    public void setConfirmed(Integer confirmed) { Confirmed = confirmed; }

    public Integer getDeaths() { return Deaths; }

    public void setDeaths(Integer deaths) { Deaths = deaths; }

    public Integer getRecovered() { return Recovered; }

    public void setRecovered(Integer recovered) { Recovered = recovered; }

    public Integer getActive() { return Active; }

    public void setActive(Integer active) { Active = active; }

    public String getDate() { return Date; }

    public void setDate(String date) { Date = date; }
}

