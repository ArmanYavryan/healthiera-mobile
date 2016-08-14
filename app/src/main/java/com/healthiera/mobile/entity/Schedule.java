package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.RepeatType;

import java.util.Date;

/**
 * Created by Davit on 05.08.2016.
 */
@Table(name = "schedule")
public class Schedule extends Model {

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "repeat_type")
    private RepeatType repeatType;

    @Column(name = "repeat_count")
    private Integer repeatCount;

    @Column(name = "interval")
    private Integer interval;

    @Column(name = "repeat_type_start")
    private Date repeatTypeStart;

    @Column(name = "repeat_type_end")
    private Date repeatTypeEnd;

    public Schedule() {
        super();
    }

    public Schedule(Long eventId, Integer interval, Integer repeatCount, RepeatType repeatType, Date repeatTypeEnd, Date repeatTypeStart) {
        this.eventId = eventId;
        this.interval = interval;
        this.repeatCount = repeatCount;
        this.repeatType = repeatType;
        this.repeatTypeEnd = repeatTypeEnd;
        this.repeatTypeStart = repeatTypeStart;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(RepeatType repeatType) {
        this.repeatType = repeatType;
    }

    public Date getRepeatTypeEnd() {
        return repeatTypeEnd;
    }

    public void setRepeatTypeEnd(Date repeatTypeEnd) {
        this.repeatTypeEnd = repeatTypeEnd;
    }

    public Date getRepeatTypeStart() {
        return repeatTypeStart;
    }

    public void setRepeatTypeStart(Date repeatTypeStart) {
        this.repeatTypeStart = repeatTypeStart;
    }
}
