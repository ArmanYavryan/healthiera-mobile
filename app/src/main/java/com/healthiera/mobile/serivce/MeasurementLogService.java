package com.healthiera.mobile.serivce;

import com.healthiera.mobile.entity.MeasurementLog;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Yengibar Manasyan
 * @date 10/18/16
 */
public class MeasurementLogService {

    public Long createMeasurementLog(MeasurementLog measurementLog) {
        assertThat(measurementLog).isNotNull();
        assertThat(measurementLog.getId()).isNull();
        assertThat(measurementLog.getMeasurement()).isNotNull();
        assertThat(measurementLog.getValue()).isNotNull().isNotEmpty();
        measurementLog.setDateTime(new Date());
        final Long id = measurementLog.save();
        assertThat(id).isNotNull().isGreaterThan(0L);

        return id;
    }
}
