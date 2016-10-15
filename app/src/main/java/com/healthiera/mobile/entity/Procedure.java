package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * @author Davit Ter-Arakelyan
 * @date 8/3/16
 */
@Table(name = "procedure")
public class Procedure extends Model {

    @Column(name = "doctor_id")
    private Long doctorId;

    @com.healthiera.mobile.Annotation.EventField(isViewable = true, name = "Doctor Name")
    private String doctorName;

    @Column(name = "notification")
    private int notification;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "code")
    private String code;

    @Column(name = "desc")
    @com.healthiera.mobile.Annotation.EventField(isViewable = true, name = "Description")
    private String desc;

    public Procedure(Long eventId, Long doctorId, int notification, String code, String desc) {
        super();
        this.doctorId = doctorId;
        this.notification = notification;
        this.eventId = eventId;
        this.code = code;
        this.desc = desc;
    }

    public Procedure() {
        super();
    }
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {

        Doctor g = new Select().from(Doctor.class).executeSingle();
        return g.getName();
    }

    public Integer getNotification() {
        return notification;
    }

    public void setNotification(Integer notification) {
        this.notification = notification;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
