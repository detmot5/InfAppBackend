package com.InfApp.InfApp.Components.CovidService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@RestController
public class CovidController {

    @Autowired
    private  CovidService covidService;

    @GetMapping("/covids")
    public ArrayList<Covid> getAllCovids() throws IOException {
        return covidService.getAllCovids();
    }

    @GetMapping("/covids/countries")
    public ArrayList<CovidCountry> getAllCountriesCovids() throws IOException {
        // Getting information about name and Slug countries
        return covidService.getAllCountriesCovids();
    }

    @GetMapping("/covid/{country}")
    public ArrayList<Covid> getCovidFromBeginning(@PathVariable String country) throws IOException {
        // Getting information about one country from beginning to today
        return covidService.getCovidFromBeginning(country);
    }

    @PostMapping(value = "/covids")
    public void addCovid(@RequestBody Covid covid){
        covidService.addCovid(covid);
    }


}
