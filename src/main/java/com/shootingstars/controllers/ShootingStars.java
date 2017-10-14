package com.shootingstars.controllers;

import com.shootingstars.models.Result;
import com.shootingstars.models.StarShowerResult;
import com.shootingstars.models.WeatherResult;
import com.shootingstars.services.ShootingStarService;
import com.shootingstars.services.WeatherService;
import com.shootingstars.utils.DateUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShootingStars {

    @Autowired
    ShootingStarService shootingStarService;

    @Autowired
    WeatherService weatherService;

    // http://localhost:8080/options?lat=12.0&long=13.0&date=2017-12-10
    @RequestMapping(value = "/options", method = RequestMethod.GET, produces = "application/json")
    public List<Result> getOptions(@RequestParam("lat") double latitude, @RequestParam("long") double longitude,
                                   @RequestParam("date") String date) {
        DateTime formattedDate = DateUtils.fromDateString(date);


        List<StarShowerResult> starShowerResults = shootingStarService.filterStarShowerResults(formattedDate, latitude);
        List<WeatherResult> weatherResults = weatherService.weatherResults(latitude, longitude);
        return new ArrayList<>();
    }
}
