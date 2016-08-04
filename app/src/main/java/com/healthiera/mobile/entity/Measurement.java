package com.healthiera.mobile.entity;

/**
 * Created by Davit on 05.08.2016.
 */
public class Measurement extends BaseEntity {
    public Long id;
    public Long eventId;
    public Integer medicationTemplateId;
    public Integer medicationShapeId;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMedicationShapeId() {
        return medicationShapeId;
    }

    public void setMedicationShapeId(Integer medicationShapeId) {
        this.medicationShapeId = medicationShapeId;
    }

    public Integer getMedicationTemplateId() {
        return medicationTemplateId;
    }

    public void setMedicationTemplateId(Integer medicationTemplateId) {
        this.medicationTemplateId = medicationTemplateId;
    }
}
