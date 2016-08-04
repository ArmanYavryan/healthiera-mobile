package com.healthiera.mobile.entity;

/**
 * Created by Davit on 05.08.2016.
 */
public class Medication  extends BaseEntity {
    public Long id;
    public Long eventId;
    public Integer medicationListId;
    public Integer medicationShapeId;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
