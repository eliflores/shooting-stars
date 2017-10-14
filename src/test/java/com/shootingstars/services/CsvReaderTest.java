package com.shootingstars.services;

import com.shootingstars.models.StarShowerResult;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CsvReaderTest {
    @Test
    public void parse() throws Exception {
        CsvReader csvReader = new CsvReader();
        List<StarShowerResult> result = csvReader.parse("meteorShowersTest.csv");
        assertEquals(5, result.size());
        assertThat(result.get(0).getName(), is("Quadrantiden"));
    }
}