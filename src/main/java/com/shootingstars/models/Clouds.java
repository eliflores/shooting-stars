package com.shootingstars.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {

    int percentage;

    public int getPercentage() {
        return percentage;
    }

    @JsonProperty("all")
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
