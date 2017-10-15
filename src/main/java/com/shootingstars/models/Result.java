package com.shootingstars.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shootingstars.utils.DateUtils;
import org.joda.time.DateTime;

public class Result {
    private double latitude;
    private double longitude;
    private DateTime dateTime;
    private String date;

    @JsonIgnore
    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDate() {
        return DateUtils.formatDate(dateTime);
    }
}
