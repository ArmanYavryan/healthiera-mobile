package com.healthiera.mobile.serivce;

import com.healthiera.mobile.entity.Calendar;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Yengibar Manasyan
 * @date 10/16/16
 */

public class CalendarService {

    public Long createCalendar(Calendar calendar) {
        final Date currentDate = new Date();
        assertThat(calendar).isNotNull();
        assertThat(calendar.getStartDateTime()).isNotNull().isAfter(currentDate);
        assertThat(calendar.getEndDateTime()).isNotNull().isAfter(currentDate).isAfter(calendar.getStartDateTime());
        assertThat(calendar.getType()).isNotNull();
        assertThat(calendar.getScheduleType()).isNotNull();
        assertThat(calendar.getRemindBeforeMinutes()).isNotNull();
        final Long eventId = calendar.save();
        assertThat(eventId).isNotNull().isGreaterThan(0L);

        return eventId;
    }
}
