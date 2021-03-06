package com.InfApp.InfApp.Components.CovidService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
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

    private Integer Increase;

    private Integer TomorrowIncrease;

}

