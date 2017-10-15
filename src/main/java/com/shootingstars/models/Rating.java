package com.shootingstars.models;

public enum Rating {

    STARK("Stark"), MITTEL("Mittel"), SCHWACH("Schwach");

    String stringValue;

    Rating(String stringValue) {
        this.stringValue = stringValue;
    }

    String getStringValue() {
        return this.stringValue;
    }

    public static Rating fromString(String stringValue) {
        for (Rating rating: Rating.values()) {
            if (rating.stringValue.equalsIgnoreCase(stringValue)) {
                return rating;
            }
        }
        return null;
    }
}
