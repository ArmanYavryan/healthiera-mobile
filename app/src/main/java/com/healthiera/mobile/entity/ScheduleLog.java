package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.EventStatus;

import java.util.Date;

/**
 * @author Yengibar Manasyan
 * @date 10/17/16
 */
@Table(name = "schedule_log")
public class ScheduleLog extends Model {

    @Column(name = "schedule_id", notNull = true)
    private Schedule schedule;

    @Column(name = "status", notNull = true)
    private EventStatus eventStatus;

    @Column(name = "date_time", notNull = true)
    private Date dateTime;

    @Column(name = "reason")
    private String reason;

    public ScheduleLog() {
        super();
    }

    public ScheduleLog(Schedule schedule, EventStatus eventStatus, Date dateTime, String reason) {
        super();
        this.schedule = schedule;
        this.eventStatus = eventStatus;
        this.dateTime = dateTime;
        this.reason = reason;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
