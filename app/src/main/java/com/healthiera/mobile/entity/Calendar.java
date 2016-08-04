package com.healthiera.mobile.entity;

import java.util.Date;

/**
 * Created by Davit on 05.08.2016.
 */
public class Calendar  extends BaseEntity {
    public Long id;
    public Long eventId;
    public Date dateTime;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
