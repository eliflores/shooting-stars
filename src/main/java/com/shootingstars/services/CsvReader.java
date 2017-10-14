package com.shootingstars.services;

import com.shootingstars.exceptions.ShootingStarsException;
import com.shootingstars.shootingstars.models.Rating;
import com.shootingstars.shootingstars.models.StarShowerResult;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader {
    private static final String METEOR_SHOWERS_CSV_FILE = "meteorShowers.csv";
    public static final int CURRENT_YEAR = 2017;

    public List<StarShowerResult> parse(String filename) {
        try {
            Reader in = new FileReader(getClass().getResource(filename).getPath());
            List<CSVRecord> records = CSVFormat.RFC4180.parse(in).getRecords();
            return readRecords(records);
        } catch (IOException e) {
            throw new ShootingStarsException(e.getMessage(), e.getCause());
        }
    }

    private List<StarShowerResult> readRecords(List<CSVRecord> records) {
        return records.stream().map(record -> {
            StarShowerResult starShowerResult = new StarShowerResult();
            starShowerResult.setName(record.get(0));
            starShowerResult.setStartDate(fromDateString(record.get(1)));
            starShowerResult.setEndDate(fromDateString(record.get(2)));
            starShowerResult.setPeakDate(fromDateString(record.get(3)));
            starShowerResult.setDeclination(Integer.parseInt(record.get(5)));
            starShowerResult.setRating(Rating.fromString(record.get(8)));
            return starShowerResult;
        }).collect(Collectors.toList());
    }

    private DateTime fromDateString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        return formatter.parseDateTime(CURRENT_YEAR + "-" + dateString);
    }

}
