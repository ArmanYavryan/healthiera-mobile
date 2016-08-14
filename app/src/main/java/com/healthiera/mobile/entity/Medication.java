package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Davit on 05.08.2016.
 */
@Table(name = "medication")
public class Medication extends Model {

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "medication_list_id")
    private Integer medicationListId;

    @Column(name = "medication_shape_id")
    private Integer medicationShapeId;

    public Medication(Long eventId, Integer medicationListId, Integer medicationShapeId) {
        super();
        this.eventId = eventId;
        this.medicationListId = medicationListId;
        this.medicationShapeId = medicationShapeId;
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

    public Integer getMedicationListId() {
        return medicationListId;
    }

    public void setMedicationListId(Integer medicationListId) {
        this.medicationListId = medicationListId;
    }

    public Integer getMedicationShapeId() {
        return medicationShapeId;
    }

    public void setMedicationShapeId(Integer medicationShapeId) {
        this.medicationShapeId = medicationShapeId;
    }
}
