package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Davit on 05.08.2016.
 */
@Table(name = "measurement")
public class Measurement extends Model {

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "medication_template_id")
    private Integer medicationTemplateId;

    @Column(name = "medication_shape_id")
    private Integer medicationShapeId;

    public Measurement() {
        super();
    }

    public Measurement(Long eventId, Integer medicationShapeId, Integer medicationTemplateId) {
        super();
        this.eventId = eventId;
        this.medicationShapeId = medicationShapeId;
        this.medicationTemplateId = medicationTemplateId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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
