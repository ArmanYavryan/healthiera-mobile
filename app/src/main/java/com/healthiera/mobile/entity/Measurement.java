package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.healthiera.mobile.entity.enumeration.GoalType;

/**
 * @author Davit Ter-Arakelyan
 * @date 05.08.2016
 */
@Table(name = "measurement")
public class Measurement extends Model {

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "goal_id")
    private Long goalId;

    @com.healthiera.mobile.Annotation.EventField(isViewable = true, name = "Goal Name")
    private String goalName;

    @Column(name = "value")
    private String value;

    @Column(name = "desc")
    @com.healthiera.mobile.Annotation.EventField(isViewable = true, name = "Description")
    private String desc;

    @Column(name = "name")
    @com.healthiera.mobile.Annotation.EventField(isViewable = true, name = "Name")
    private String name;

    @Column(name = "type")
    private GoalType type;

    public Measurement(Long eventId, Long goalId, String value, String desc, String name, GoalType type) {
        super();
        this.eventId = eventId;
        this.goalId = goalId;
        this.value = value;
        this.desc = desc;
        this.name = name;
        this.type = type;
    }

    public Measurement() {
        super();
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goal) {
        this.goalId = goal;
    }

    public String getGoalName() {
        Goals g = new Select().from(Goals.class).executeSingle();
        return g.getName();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoalType getType() {
        return type;
    }

    public void setType(GoalType type) {
        this.type = type;
    }
}
