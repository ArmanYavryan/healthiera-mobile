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

    @Column(name = "calendar_id", notNull = true)
    private Calendar calendar;

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

    public Medication(Calendar calendar, Integer dose, String manufacturer, String name, String code) {
        super();
        this.calendar = calendar;
        this.dose = dose;
        this.manufacturer = manufacturer;
        this.name = name;
        this.code = code;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
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
