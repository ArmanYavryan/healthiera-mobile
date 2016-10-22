package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.HealthDateType;

/**
 * @author Davit Ter-Arakelyan
 * @date 22.10.2016
 */
@Table(name = "health_date")
public class HealthDate extends Model {

    @Column(name = "health_date_type", index = true, notNull = true)
    private HealthDateType healthDateType;

    @Column(name = "value", notNull = true)
    private String value;

    public HealthDate() {
        super();
    }

    public HealthDate(HealthDateType healthDateType, String value) {
        super();
        this.healthDateType = healthDateType;
        this.value = value;
    }
}
