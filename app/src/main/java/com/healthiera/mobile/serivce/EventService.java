package com.healthiera.mobile.serivce;

import com.healthiera.mobile.entity.Event;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yengibar on 8/14/16.
 */
public class EventService {

    public Long createAppointment(Event event) {
        assertThat(event).isNotNull();
        assertThat(event.getId()).isNull();
        assertThat(event.getStartDateTime()).isNotNull();

        final Long createdEventId = event.save();

        assertThat(createdEventId).isGreaterThan(0L);

        return createdEventId;
    }

    public Event findEventById(Long id) {
        assertThat(id).isNotNull().isGreaterThan(0);
        final Event event = Event.load(Event.class, id);
        assertThat(event).isNotNull();

        return event;
    }
}
