package com.shootingstars.controllers;

import com.shootingstars.models.Result;
import com.shootingstars.models.StarShowerResult;
import com.shootingstars.models.WeatherResult;
import com.shootingstars.services.ResultCalculator;
import com.shootingstars.services.ShootingStarService;
import com.shootingstars.services.WeatherService;
import com.shootingstars.utils.DateUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Collections.emptyList;

@RestController
public class ShootingStarsController {
    private final ShootingStarService shootingStarService;
    private final WeatherService weatherService;
    private final ResultCalculator resultCalculator;

    @Autowired
    public ShootingStarsController(ShootingStarService shootingStarService, WeatherService weatherService, ResultCalculator resultCalculator) {
        this.shootingStarService = shootingStarService;
        this.weatherService = weatherService;
        this.resultCalculator = resultCalculator;
    }


    // http://localhost:8080/options?lat=12.0&long=13.0&date=2017-12-10
    @CrossOrigin
    @RequestMapping(value = "/options", method = RequestMethod.GET, produces = "application/json")
    public List<Result> getOptions(@RequestParam("lat") double latitude, @RequestParam("long") double longitude,
                                   @RequestParam("date") String date) {
        DateTime formattedDate = DateUtils.fromDateString(date);


        StarShowerResult showerResult = shootingStarService.filterStarShowerResults(formattedDate, latitude);

        if (showerResult == null) {
            return emptyList();
        }

        List<List<WeatherResult>> weatherResults = weatherService.weatherResults(latitude, longitude);
        if (weatherResults.isEmpty()) {
            return emptyList();
        }

        return resultCalculator.getResult(showerResult, weatherResults);
    }
}
