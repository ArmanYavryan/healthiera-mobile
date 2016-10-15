package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.EventType;
import com.healthiera.mobile.entity.enumeration.ScheduleType;

import java.util.Date;

/**
 * @author Davit Ter-Arakelyan
 * @date 05.08.2016
 */
@Table(name = "event")
public class Event extends Model {

    public Event(String description, String title, String status, EventType type, Date startDateTime, Date endDateTime, String location, ScheduleType scheduleType, int remindeBeforeMinutes) {
        super();
        this.description = description;
        this.title = title;
        this.status = status;
        this.type = type;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.scheduleType = scheduleType;
        this.remindeBeforeMinutes =remindeBeforeMinutes;
    }

    public Event() {
        super();
    }

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private EventType type;

    @Column(name = "start_date_time")
    private Date startDateTime;

    @Column(name = "end_date_time")
    private Date endDateTime;

    @Column(name = "location")
    private String location;

    @Column(name = "schedule_type")
    private ScheduleType scheduleType;

    @Column(name = "reminde_before_minutes")
    private int remindeBeforeMinutes;

    public int getRemindeBeforeMinutes() {
        return remindeBeforeMinutes;
    }

    public void setRemindeBeforeMinutes(int remindeBeforeMinutes) {
        this.remindeBeforeMinutes = remindeBeforeMinutes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
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

    public ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }
}
