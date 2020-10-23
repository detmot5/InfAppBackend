package com.InfApp.InfApp.Components.CovidService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@RestController
public class CovidController {

    @Autowired
    private  CovidService covidService;

    @RequestMapping("/covids")
    public ArrayList<Covid> getAllCovids() throws IOException {
        return covidService.getAllCovids();
    }

    @RequestMapping("/covids/countries")
    public ArrayList<CovidCountries> getAllCountriesCovids() throws IOException {
        return covidService.getAllCountriesCovids();
    }

    @RequestMapping("/covids/{country}")
    public Covid getCovid(@PathVariable String country) throws IOException {
    return covidService.getCovid(country);
    }


}
