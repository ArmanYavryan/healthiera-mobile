package com.healthiera.mobile.serivce;

import com.healthiera.mobile.entity.Measurement;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Yengibar Manasyan
 * @date 10/18/16
 */
public class MeasurementService {

    public Long createMeasurement(Measurement measurement) {
        assertThat(measurement).isNotNull();
        assertThat(measurement.getId()).isNull();
        assertThat(measurement.getType()).isNull();
        final Long id = measurement.save();
        assertThat(id).isNotNull().isGreaterThan(0L);

        return id;
    }
}
