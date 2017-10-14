package com.shootingstars.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherClient {
    private static final String WEATHER_API_URL = "http://api.openweathermap.org/";
    private static final String CURRENT_WEATHER_PATH = "/data/2.5/weather";
    private static final String CURRENT_WEATHER_PARAMS= "lat=%s&lon=%s&appid=%s";

    // Example of URL request: http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&APPID=apiKey

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherClient() {

    }
}
