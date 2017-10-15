package com.shootingstars.services;

import com.shootingstars.models.Coordinates;
import com.shootingstars.models.Result;
import com.shootingstars.models.StarShowerResult;
import com.shootingstars.models.WeatherResult;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultCalculator {


    public List<Result> getResult(StarShowerResult starShowerResult, List<List<WeatherResult>> weatherResults) {

        List<WeatherResult> listOfBestResultsPerLocation = new ArrayList<>();

        for (List<WeatherResult> weatherResultsForOneLocation : weatherResults) {
            WeatherResult bestWeatherResultForOneLocation = getBestWeatherResult(weatherResultsForOneLocation, starShowerResult.getPeakDate());
            if (bestWeatherResultForOneLocation != null) {
                listOfBestResultsPerLocation.add(bestWeatherResultForOneLocation);
            }
        }

        return transformToListOfResults(listOfBestResultsPerLocation);
    }

    private List<Result> transformToListOfResults(List<WeatherResult> listOfBestResultsPerLocation) {
        List<Result> finalResults = new ArrayList<>();
        for (WeatherResult weatherResult : listOfBestResultsPerLocation) {
            Coordinates coordinates = weatherResult.getCoordinates();

            if (coordinates != null) {
                DateTime dateTime = weatherResult.getDateTime();

                Result result = new Result();
                result.setLatitude(coordinates.getLatitude());
                result.setLatitude(coordinates.getLongitude());
                result.setDateTime(dateTime);

                finalResults.add(result);
            }

        }
        return finalResults;
    }


    private WeatherResult getBestWeatherResult(List<WeatherResult> weatherResultsForOneLocation, DateTime starShowerResultsDate) {
        WeatherResult resultClosestToPeakdate = null;
        if (weatherResultsForOneLocation.size() == 1) {
            return weatherResultsForOneLocation.get(0);
        }

        for (int i = 0; i < 16; i++) {
            resultClosestToPeakdate = getResultWithDistanceToPeak(i, weatherResultsForOneLocation, starShowerResultsDate);

            if (resultClosestToPeakdate != null) {
                return resultClosestToPeakdate;
            }
        }
        return resultClosestToPeakdate;
    }


    private WeatherResult getResultWithDistanceToPeak(int minimumDistanceToPeakDate, List<WeatherResult> weatherResultsForOneLocation, DateTime starShowerResultsDate) {
        for (WeatherResult weatherResultForOneDay : weatherResultsForOneLocation) {
            if (starShowerResultsDate.plus(minimumDistanceToPeakDate).isAfter(weatherResultForOneDay.getDateTime())
                    || starShowerResultsDate.minus(minimumDistanceToPeakDate).isBefore(weatherResultForOneDay
                    .getDateTime())) {
                return weatherResultForOneDay;
            }
        }
        return null;
    }
}
