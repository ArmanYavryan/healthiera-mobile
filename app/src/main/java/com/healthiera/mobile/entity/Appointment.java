package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by yengibar on 8/3/16.
 */
@Table(name = "appointment")
public class Appointment extends Model {

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "notification")
    private Integer notification;

    @Column(name = "event_id")
    private Long eventId;

    public Appointment() {
        super();
    }

    public Appointment(Long doctorId, Long eventId, Integer notification) {
        super();
        this.doctorId = doctorId;
        this.eventId = eventId;
        this.notification = notification;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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
