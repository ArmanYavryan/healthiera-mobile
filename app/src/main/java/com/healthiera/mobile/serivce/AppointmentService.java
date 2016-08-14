package com.healthiera.mobile.serivce;

import com.healthiera.mobile.entity.Appointment;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by yengibar on 8/14/16.
 */
public class AppointmentService {

    public Long createAppointment(Appointment appointment) {
        assertThat(appointment).isNotNull();
        assertThat(appointment.getId()).isNull();
        assertThat(appointment.getDoctorId()).isNotNull();
        assertThat(appointment.getEvent()).isNotNull();

        final Long createdAppointmentId = appointment.save();

        assertThat(createdAppointmentId).isGreaterThan(0L);

        return createdAppointmentId;
    }

    public Appointment findAppointmentById(Long id) {
        assertThat(id).isNotNull().isGreaterThan(0);
        final Appointment appointment = Appointment.load(Appointment.class, id);
        assertThat(appointment).isNotNull();

        return appointment;
    }
}
