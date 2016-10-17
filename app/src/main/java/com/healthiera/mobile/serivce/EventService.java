package com.healthiera.mobile.serivce;

import com.healthiera.mobile.entity.Event;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Yengibar Manasyan
 * @date 10/16/16
 */

public class EventService {

    public Long createEvent(Event event) {
        final Date currentDate = new Date();
        assertThat(event).isNotNull();
        assertThat(event.getStartDateTime()).isNotNull().isAfter(currentDate);
        assertThat(event.getEndDateTime()).isNotNull().isAfter(currentDate).isAfter(event.getStartDateTime());
        assertThat(event.getType()).isNotNull();
        assertThat(event.getScheduleType()).isNotNull();
        assertThat(event.getRemindBeforeMinutes()).isNotNull();
        final Long eventId = event.save();
        assertThat(eventId).isNotNull().isGreaterThan(0L);

        return eventId;
    }
}
