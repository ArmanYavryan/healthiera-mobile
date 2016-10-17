package com.healthiera.mobile.serivce;

import com.healthiera.mobile.entity.Procedure;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Yengibar Manasyan
 * @date 8/14/16
 */
public class AppointmentService {

    public Long createAppointment(Procedure procedure) {
        assertThat(procedure).isNotNull();
        assertThat(procedure.getId()).isNull();
        assertThat(procedure.getDoctor()).isNotNull();
        assertThat(procedure.getEvent()).isNotNull();
        final Long id = procedure.save();
        assertThat(id).isGreaterThan(0L);

        return id;
    }

    public Procedure findAppointmentById(Long id) {
        assertThat(id).isNotNull().isGreaterThan(0);
        final Procedure procedure = Procedure.load(Procedure.class, id);
        assertThat(procedure).isNotNull();

        return procedure;
    }
}
