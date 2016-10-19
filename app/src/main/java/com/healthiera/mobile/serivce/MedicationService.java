package com.healthiera.mobile.serivce;

import com.activeandroid.query.Select;
import com.healthiera.mobile.entity.Medication;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Yengibar Manasyan
 * @date 10/18/16
 */
public class MedicationService {

    public Long createMedication(Medication medication) {
        assertThat(medication).isNotNull();
        assertThat(medication.getId()).isNull();
        assertThat(medication.getSchedule()).isNotNull();
        assertThat(medication.getManufacturer()).isNotNull().isNotEmpty();
        assertThat(medication.getName()).isNotNull().isNotEmpty();
        final Long id = medication.save();
        assertThat(id).isNotNull().isGreaterThan(0L);

        return id;
    }

    public Medication findMedicationByName(String namePattern) {
        assertThat(namePattern).isNotNull().isNotEmpty();
        final Medication medication = new Select()
                .from(Medication.class)
                .where("name like ?%")
                .executeSingle();
        assertThat(medication).isNotNull();

        return medication;
    }
}
