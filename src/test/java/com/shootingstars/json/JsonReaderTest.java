package com.shootingstars.json;

import com.shootingstars.models.WeatherClientResponse;
import com.shootingstars.models.WeatherResult;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonReaderTest {
    @Test
    public void fromJson() throws Exception {

        InputStream jsonAsStream = getClass().getResourceAsStream("weatherAPIresponse.json");
        WeatherClientResponse weatherClientResponse = JsonReader.fromJson(IOUtils.toString(jsonAsStream, "UTF-8"), WeatherClientResponse.class);
        List<WeatherResult> weatherResults = weatherClientResponse.getWeatherResults();
        assertThat(weatherResults.size(), is(2));
        assertThat(weatherResults.get(0).getClouds().getPercentage(), is(100));
        //assertThat(weatherResults.get(0).getDateTime(), is("2017-10-14 21:00:00"));
        assertThat(weatherResults.get(0).getDateTime(), is(new DateTime(2017, 10, 14, 21, 00, 00)));

    }

}