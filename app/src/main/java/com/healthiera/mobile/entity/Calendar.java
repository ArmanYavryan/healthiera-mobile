package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by Davit on 05.08.2016.
 */
@Table(name = "calendar")
public class Calendar extends Model {

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "date_time")
    private Date dateTime;

    public Calendar(Date dateTime, Long eventId) {
        super();
        this.dateTime = dateTime;
        this.eventId = eventId;
    }

    public Calendar() {
        super();
    }

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
}
