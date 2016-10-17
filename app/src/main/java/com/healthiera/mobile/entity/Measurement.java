package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.healthiera.mobile.entity.enumeration.GoalType;

/**
 * @author Yengibar Manasyan
 * @date 17.10.2016
 */
@Table(name = "measurement")
public class Measurement extends Model {

    @Column(name = "event_id")
    private Event event;

    @Column(name = "goal_id")
    private Goal goal;

    @Column(name = "type")
    private GoalType type;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Measurement() {
        super();
    }

    public Measurement(Event event, Goal goal, GoalType type, String name, String description) {
        super();
        this.event = event;
        this.goal = goal;
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public GoalType getType() {
        return type;
    }

    public void setType(GoalType type) {
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
