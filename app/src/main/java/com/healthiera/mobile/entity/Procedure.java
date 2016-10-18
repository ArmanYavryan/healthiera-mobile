package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * @author Yengibar Manasyan
 * @date 17.10.2016
 */
@Table(name = "procedure")
public class Procedure extends Model {

    @Column(name = "calendar_id", notNull = true)
    private Calendar calendar;

    @Column(name = "doctor_id", notNull = true)
    private Doctor doctor;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    public Procedure() {
        super();
    }

    public Procedure(Calendar calendar, Doctor doctor, String code, String description) {
        super();
        this.calendar = calendar;
        this.doctor = doctor;
        this.code = code;
        this.description = description;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
