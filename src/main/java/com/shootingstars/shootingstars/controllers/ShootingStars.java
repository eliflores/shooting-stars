package com.shootingstars.shootingstars.controllers;

import com.shootingstars.shootingstars.models.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShootingStars {

    // http://localhost:8080/options?lat=12.0&long=13.0&date=2017-12-10
    @RequestMapping(value = "/options", method = RequestMethod.GET, produces = "application/json")
    public Result getOptions(@RequestParam("lat") double latitude, @RequestParam("long") double longitude,
                             @RequestParam("date") String date) {


        return new Result();
    }
}
