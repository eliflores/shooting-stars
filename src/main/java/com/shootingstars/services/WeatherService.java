package com.shootingstars.services;

import com.shootingstars.clients.WeatherClient;
import com.shootingstars.models.Coordinates;
import com.shootingstars.models.WeatherResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherClient weatherClient;

    public List<List<WeatherResult>> weatherResults(double latitude, double longitude) {

        List<Coordinates> coordinates = getRelevantCoordinates(latitude, longitude);
        List<List<WeatherResult>> weatherResultsWithGoodVisibilityForAllLocations = new ArrayList<>();
        for (Coordinates coordinate : coordinates) {
            List<WeatherResult> weatherResultsForOneLocation = weatherClient.getWeatherResults(coordinate);
            if (!weatherResultsForOneLocation.isEmpty()) {
                weatherResultsWithGoodVisibilityForAllLocations.add(weatherResultsForOneLocation);
            }

        }

        return weatherResultsWithGoodVisibilityForAllLocations;
    }

    private List<Coordinates> getRelevantCoordinates(double longitude, double latitude) {
        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(longitude, latitude));
        double distance = 0.5;
        double maximalDistance = 1.5;
        for (double i = -maximalDistance; i <= maximalDistance; i+=distance) {
            if (i != 0) {
               coordinates.add(new Coordinates(longitude + i, latitude));
               coordinates.add(new Coordinates(longitude, latitude + i));
               coordinates.add(new Coordinates(longitude + i, latitude + i));
               coordinates.add(new Coordinates(longitude - i, latitude + i));
            }
        }
        return coordinates;
    }

}
