package com.InfApp.InfApp.Components.CovidService;

public class CovidCountries {
    private  String Country;
    private  String Slug;
    private  String ISO2;

    public CovidCountries(String country, String slug, String ISO2) {
        Country = country;
        Slug = slug;
        this.ISO2 = ISO2;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        this.Slug = slug;
    }

    public String getISO2() {
        return ISO2;
    }

    public void setISO2(String ISO2) {
        this.ISO2 = ISO2;
    }
}
