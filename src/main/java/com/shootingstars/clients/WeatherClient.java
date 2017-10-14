package com.shootingstars.clients;

import com.shootingstars.http.HttpClient;
import com.shootingstars.json.JsonReader;
import com.shootingstars.models.WeatherResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherClient {
    private static final String WEATHER_API_URL = "http://api.openweathermap.org/";
    private static final String CURRENT_WEATHER_PATH = "data/2.5/weather";
    private static final String FORECAST_WEATHER_PATH = "data/2.5/forecast";
    private static final String QUERY_PARAMS = "?lat=%s&lon=%s&appid=%s";

    // Example of URL request: http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&APPID=apiKey

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherClient() {

    }

    public void getWeatherResults() {
        String requestParams = String.format(QUERY_PARAMS, 35, 139, apiKey);
        String request = WEATHER_API_URL + FORECAST_WEATHER_PATH + requestParams;
        String response = new HttpClient().sendGetRequest(request);
        List<WeatherResult> listOfWeatherResults = JsonReader.fromJsonList(response, WeatherResult.class);
        System.out.println(response);
    }
}