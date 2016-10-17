package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * @author Yengibar Manasyan
 * @date 10/17/16
 */
@Table(name = "measurement_log")
public class MeasurementLog extends Model {

    @Column(name = "measurement_id", notNull = true)
    private Measurement measurement;

    @Column(name = "value", notNull = true)
    private String value;

    @Column(name = "date_time", notNull = true)
    private Date dateTime;

    public MeasurementLog() {
        super();
    }

    public MeasurementLog(Measurement measurement, String value, Date dateTime) {
        super();
        this.measurement = measurement;
        this.value = value;
        this.dateTime = dateTime;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
