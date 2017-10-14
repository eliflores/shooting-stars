package com.shootingstars.services;

import com.shootingstars.clients.WeatherClient;
import com.shootingstars.models.StarShowerResult;
import com.shootingstars.utils.CsvReader;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShootingStarService {
    private static final String METEOR_SHOWERS_CSV_FILE = "meteorShowers.csv";

    private final WeatherClient weatherClient;

    @Autowired
    public ShootingStarService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public void weatherResults() {
        weatherClient.getWeatherResults();
    }

    public List<StarShowerResult> filterStarShowerResults(DateTime date, double lat) {
        CsvReader reader = new CsvReader();
        List<StarShowerResult> listOfStarShowerResult = reader.parse(METEOR_SHOWERS_CSV_FILE);
        listOfStarShowerResult = filterStarShowerResultsByDate(date, listOfStarShowerResult);
        listOfStarShowerResult = filterStarShowerResultsByHemisphere(lat, listOfStarShowerResult);
        return listOfStarShowerResult;

    }

    private List<StarShowerResult> filterStarShowerResultsByDate(DateTime date, List<StarShowerResult> listOfStarshowerResults) {
        List<StarShowerResult> filteredList = new ArrayList<>();
        DateTime upperRangeDate = date.plusDays(10);
        DateTime lowerRangeDate = getLowerRangeDate(date);

        for (StarShowerResult starShowerResult : listOfStarshowerResults) {
            DateTime startDate = starShowerResult.getStartDate();
            DateTime endDate = starShowerResult.getEndDate();
            if ((upperRangeDate.isAfter(startDate) || upperRangeDate.isEqual(startDate))
                    && (lowerRangeDate.isBefore(endDate) || lowerRangeDate.isEqual(endDate))) {
                filteredList.add(starShowerResult);
            }
        }
        return filteredList;
    }

    private List<StarShowerResult> filterStarShowerResultsByHemisphere(double lat, List<StarShowerResult> listOfStarshowerResults) {
        List<StarShowerResult> filteredList = new ArrayList<>();
        for (StarShowerResult starShowerResult : listOfStarshowerResults) {
            if (starShowerResult.getDeclination() * lat >= 0)
                filteredList.add(starShowerResult);
        }
        return filteredList;
    }

    private DateTime getLowerRangeDate(DateTime date) {
        int numberOfDays = 10;
        DateTime lowerRangeDate = date.minusDays(numberOfDays);
        while (lowerRangeDate.isBefore(DateTime.now())) {
            lowerRangeDate = date.minusDays(--numberOfDays);
        }
        return lowerRangeDate;
    }
}
