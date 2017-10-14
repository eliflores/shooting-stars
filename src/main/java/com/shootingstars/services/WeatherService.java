package com.shootingstars.services;

import com.shootingstars.clients.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private WeatherClient weatherClient;

    public void weatherResults() {
        weatherClient.getWeatherResults();
    }

}
