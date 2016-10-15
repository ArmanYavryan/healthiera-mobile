package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by yengibar on 8/3/16.
 */
@Table(name = "procedure")
public class Procedure extends Model {

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "notification")
    private Integer notification;

    @Column(name = "event_id")
    private Event event;

    public Procedure() {
        super();
    }

    public Procedure(Long doctorId, Integer notification, Event event) {
        super();
        this.doctorId = doctorId;
        this.notification = notification;
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getNotification() {
        return notification;
    }

    public void setNotification(Integer notification) {
        this.notification = notification;
    }
}
