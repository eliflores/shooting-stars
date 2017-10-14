package com.shootingstars.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CsvReader {
    private static final String METEOR_SHOWERS_CSV_FILE = "meteorShowers.csv";

    public static void main(String[] args) {
        new CsvReader().parse();
    }

    public void parse() {
        try {
            Reader in = new FileReader(getClass().getResource(METEOR_SHOWERS_CSV_FILE).getPath());
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
            for (CSVRecord record : records) {
                String name = record.get(0);
                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
