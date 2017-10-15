package com.shootingstars.controllers;

import com.shootingstars.models.Result;
import com.shootingstars.models.StarShowerResult;
import com.shootingstars.models.WeatherResult;
import com.shootingstars.services.ShootingStarService;
import com.shootingstars.services.WeatherService;
import com.shootingstars.utils.DateUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

//TODO Move to a better place
@CrossOrigin(origins = "http://localhost:3000")
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

        //for testing
        Result result1 = new Result();
        result1.setDateTime(formattedDate);
        result1.setLatitude(latitude);
        result1.setLongitude(longitude);

        Result result2 = new Result();
        result2.setDateTime(formattedDate.plusDays(2));
        result2.setLatitude(latitude + 0.5);
        result2.setLongitude(longitude);

        Result result3 = new Result();
        result3.setDateTime(formattedDate.plusDays(4));
        result3.setLatitude(latitude);
        result3.setLongitude(longitude + 1.0);

        Result result4 = new Result();
        result4.setDateTime(formattedDate.plusDays(8));
        result4.setLatitude(latitude -1.5);
        result4.setLongitude(longitude + 0.5);

        return asList(result1, result2, result3, result4);
    }
}
