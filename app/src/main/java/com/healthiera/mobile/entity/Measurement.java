package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.MeasurementType;

/**
 * @author Yengibar Manasyan
 * @date 17.10.2016
 */
@Table(name = "measurement")
public class Measurement extends Model {

    @Column(name = "calendar_id", notNull = true)
    private Calendar calendar;

    @Column(name = "goal_id")
    private Goal goal;

    @Column(name = "type", notNull = true)
    private MeasurementType type;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Measurement() {
        super();
    }

    public Measurement(Calendar calendar, Goal goal, MeasurementType type, String name, String description) {
        super();
        this.calendar = calendar;
        this.goal = goal;
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public MeasurementType getType() {
        return type;
    }

    public void setType(MeasurementType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
