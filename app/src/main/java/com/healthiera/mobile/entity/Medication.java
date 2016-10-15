package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * @author Davit Ter-Arakelyan
 * @date 05.08.2016
 */
@Table(name = "medication")
public class Medication extends Model {

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "dose")
    @com.healthiera.mobile.Annotation.EventField(isViewable = true, name = "Dose")
    private Integer dose;

    @Column(name = "manufacturer")
    @com.healthiera.mobile.Annotation.EventField(isViewable = true, name = "Manufacturer")
    private String manufacturer;

    @Column(name = "name")
    @com.healthiera.mobile.Annotation.EventField(isViewable = true, name = "Name")
    private String name;

    @Column(name = "code")
    @com.healthiera.mobile.Annotation.EventField(isViewable = true, name = "Code")
    private String code;

    public Medication(Long eventId, Integer dose, String manufacturer, String name, String code) {
        super();
        this.eventId = eventId;
        this.dose = dose;
        this.manufacturer = manufacturer;
        this.name = name;
        this.code = code;
    }

    public Medication() {
        super();
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
