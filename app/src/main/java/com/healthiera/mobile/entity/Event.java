package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.EventType;

import java.util.Date;

/**
 * Created by Davit on 05.08.2016.
 */
@Table(name = "event")
public class Event extends Model {

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private EventType type;

    @Column(name = "start_date_time")
    private Date startDateTime;

    @Column(name = "end_date_time")
    private Date endDateTime;

    @Column(name = "location")
    private String location;

    public Event() {
        super();
    }

    public Event(String description, Date endDateTime, String location, Date startDateTime, EventType type) {
        super();
        this.description = description;
        this.endDateTime = endDateTime;
        this.location = location;
        this.startDateTime = startDateTime;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
