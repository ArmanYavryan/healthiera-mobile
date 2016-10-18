package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.ScheduleStatus;

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
    private ScheduleStatus scheduleStatus;

    @Column(name = "date_time", notNull = true)
    private Date dateTime;

    @Column(name = "reason")
    private String reason;

    public ScheduleLog() {
        super();
    }

    public ScheduleLog(Schedule schedule, ScheduleStatus scheduleStatus, Date dateTime, String reason) {
        super();
        this.schedule = schedule;
        this.scheduleStatus = scheduleStatus;
        this.dateTime = dateTime;
        this.reason = reason;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public ScheduleStatus getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(ScheduleStatus scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
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
