package com.healthiera.mobile.entity;

/**
 * Created by yengibar on 8/3/16.
 */
public class Appointment extends BaseEntity {

    private Long eventId;

    private Long doctorId;

    private Integer notification;

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
