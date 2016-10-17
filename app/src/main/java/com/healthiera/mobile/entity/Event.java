package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.EventType;
import com.healthiera.mobile.entity.enumeration.ScheduleType;
import com.healthiera.mobile.entity.enumeration.StatusType;

import java.util.Date;

/**
 * @author Yengibar Manasyan
 * @date 17.10.2016
 */
@Table(name = "event")
public class Event extends Model {

    @Column(name = "start_date_time", notNull = true)
    private Date startDateTime;

    @Column(name = "end_date_time", notNull = true)
    private Date endDateTime;

    @Column(name = "type")
    private EventType type;

    @Column(name = "schedule_type")
    private ScheduleType scheduleType;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private StatusType status;

    @Column(name = "location")
    private String location;

    @Column(name = "remind_before_minutes")
    private Integer remindBeforeMinutes;

    public Event() {
        super();
    }

    public Event(Date startDateTime, Date endDateTime, EventType type, ScheduleType scheduleType,
                 String title, String description, StatusType status, String location, Integer remindBeforeMinutes) {
        super();
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.type = type;
        this.scheduleType = scheduleType;
        this.title = title;
        this.description = description;
        this.status = status;
        this.location = location;
        this.remindBeforeMinutes = remindBeforeMinutes;
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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRemindBeforeMinutes() {
        return remindBeforeMinutes;
    }

    public void setRemindBeforeMinutes(Integer remindBeforeMinutes) {
        this.remindBeforeMinutes = remindBeforeMinutes;
    }
}
