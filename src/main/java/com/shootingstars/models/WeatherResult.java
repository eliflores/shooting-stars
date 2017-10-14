package com.shootingstars.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shootingstars.utils.DateUtils;
import org.joda.time.DateTime;

@JsonIgnoreProperties({"dt", "main", "weather", "wind", "rain", "sys"})
public class WeatherResult {

    Clouds clouds;
    String dateTimeString;
    Coordinates coordinates;

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public DateTime getDateTime() {
        return DateUtils.fromDateStringWithTime(dateTimeString);
    }

    @JsonProperty("dt_txt")
    public void setDateTime(String dateTime) {
        this.dateTimeString = dateTime;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


}
