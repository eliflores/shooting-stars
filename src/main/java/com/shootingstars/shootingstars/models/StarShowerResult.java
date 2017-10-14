package com.shootingstars.shootingstars.models;

import org.joda.time.DateTime;

public class StarShowerResult {

    private String name;
    private DateTime startDate;
    private DateTime endDate;
    private DateTime peakDate;
    private int declination;
    private Rating rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public DateTime getPeakDate() {
        return peakDate;
    }

    public void setPeakDate(DateTime peakDate) {
        this.peakDate = peakDate;
    }

    public int getDeclination() {
        return declination;
    }

    public void setDeclination(int declination) {
        this.declination = declination;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
