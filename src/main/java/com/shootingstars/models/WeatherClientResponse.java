package com.shootingstars.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties({"cod", "message", "cnt"})
public class WeatherClientResponse {


    List<WeatherResult> weatherResults;

    public List<WeatherResult> getWeatherResults() {
        return weatherResults;
    }


    @JsonProperty("list")
    public void setWeatherResults(List<WeatherResult> weatherResults) {
        this.weatherResults = weatherResults;
    }
}
