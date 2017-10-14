package com.shootingstars.utils;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DateUtilsTest {
    @Test
    public void formatDateString() throws Exception {
        String dateString = "2017-06-22";
        DateTime dateTime = DateUtils.fromDateString(dateString);
        DateTime expectedDate = new DateTime(2017, 06, 22, 0, 0);
        assertThat(expectedDate, is(dateTime));
    }

}