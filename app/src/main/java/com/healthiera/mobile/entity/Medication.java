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

    @Column(name = "schedule_id", notNull = true)
    private Schedule schedule;

    @Column(name = "dose")
    private Integer dose;

    @Column(name = "manufacturer", notNull = true)
    private String manufacturer;

    @Column(name = "name", notNull = true)
    private String name;

    @Column(name = "code")
    private String code;

    public Medication() {
        super();
    }

    public Medication(Schedule schedule, Integer dose, String manufacturer, String name, String code) {
        super();
        this.schedule = schedule;
        this.dose = dose;
        this.manufacturer = manufacturer;
        this.name = name;
        this.code = code;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
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
