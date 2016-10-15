package com.healthiera.mobile.serivce;

import com.healthiera.mobile.entity.Procedure;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by yengibar on 8/14/16.
 */
public class AppointmentService {

    public Long createAppointment(Procedure procedure) {
        assertThat(procedure).isNotNull();
        assertThat(procedure.getId()).isNull();
        assertThat(procedure.getDoctorId()).isNotNull();
        assertThat(procedure.getEvent()).isNotNull();

        final Long createdAppointmentId = procedure.save();

        assertThat(createdAppointmentId).isGreaterThan(0L);

        return createdAppointmentId;
    }

    public Procedure findAppointmentById(Long id) {
        assertThat(id).isNotNull().isGreaterThan(0);
        final Procedure procedure = Procedure.load(Procedure.class, id);
        assertThat(procedure).isNotNull();

        return procedure;
    }
}
