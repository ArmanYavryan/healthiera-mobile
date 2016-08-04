package com.healthiera.mobile.entity;

import java.util.Date;

/**
 * Created by Davit on 05.08.2016.
 */
public class Schedule extends BaseEntity
{
    public Long id;
    public Long eventId;
    public RepeatType repeatType;
    public Integer repeatCount;
    public Integer interval;
    public Date repeatTypeStart;
    public Date repeatTypeEnd;

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
