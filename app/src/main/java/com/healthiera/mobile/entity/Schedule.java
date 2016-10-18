package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.RepeatType;

/**
 * @author Yengibar Manasyan
 * @date 05.08.2016
 */
@Table(name = "schedule")
public class Schedule extends Model {

    @Column(name = "calendar_id", notNull = true)
    private Calendar calendar;

    @Column(name = "repeat_type", notNull = true)
    private RepeatType repeatType;

    @Column(name = "repeat_count")
    private Integer repeatCount;

    @Column(name = "interval")
    private Integer interval;

    @Column(name = "time")
    private Integer time;

    @Column(name = "weekdays")
    private String weekdays;

    public Schedule() {
        super();
    }

    public Schedule(Calendar calendar, RepeatType repeatType, Integer repeatCount, Integer interval,
                    Integer time, String weekdays) {
        super();
        this.calendar = calendar;
        this.repeatType = repeatType;
        this.repeatCount = repeatCount;
        this.interval = interval;
        this.time = time;
        this.weekdays = weekdays;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(RepeatType repeatType) {
        this.repeatType = repeatType;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }
}
