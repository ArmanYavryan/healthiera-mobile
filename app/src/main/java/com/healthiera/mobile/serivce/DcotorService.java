package com.healthiera.mobile.serivce;

import com.activeandroid.query.Select;
import com.healthiera.mobile.entity.Doctor;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Yengibar Manasyan
 * @date 10/18/16
 */
public class DcotorService {

    public Long createDoctor(Doctor doctor) {
        assertThat(doctor).isNotNull();
        assertThat(doctor.getId()).isNull();
        assertThat(doctor.getSpecification()).isNotNull().isNotEmpty();
        assertThat(doctor.getName()).isNotNull().isNotEmpty();
        final Long id = doctor.save();
        assertThat(id).isNotNull().isGreaterThan(0L);

        return id;
    }

    public Doctor findDoctorByName(String namePattern) {
        assertThat(namePattern).isNotNull().isNotEmpty();
        final Doctor doctor = new Select()
                .from(Doctor.class)
                .where("name like ?%")
                .executeSingle();
        assertThat(doctor).isNotNull();

        return doctor;
    }
}
