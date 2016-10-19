package com.healthiera.mobile.serivce;

import com.activeandroid.query.Select;
import com.healthiera.mobile.entity.Schedule;
import com.healthiera.mobile.entity.enumeration.DurationType;
import com.healthiera.mobile.entity.enumeration.RepeatType;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Yengibar Manasyan
 * @date 10/16/16
 */

public class ScheduleService {

    public Long createSchedule(Schedule schedule) {
        final Date currentDate = new Date();
        assertThat(schedule).isNotNull();
        assertThat(schedule.getId()).isNull();
        assertThat(schedule.getStartDate()).isNotNull().isAfter(currentDate);
        assertThat(schedule.getDurationType()).isNotNull();
        if (schedule.getDurationType().equals(DurationType.NUMBER_OF_DAYS)) {
            assertThat(schedule.getNumberOfRepetition()).isNotNull();
        }
        assertThat(schedule.getRepeatType()).isNotNull();
        if (schedule.getRepeatType().equals(RepeatType.SPECIFIC_DAYS)) {
            assertThat(schedule.getDaysOfWeek()).isNotNull().isNotEmpty();
        } else if (schedule.getRepeatType().equals(RepeatType.DAYS_INTERVAL)) {
            assertThat(schedule.getDaysInterval()).isNotNull().isGreaterThan(0);
        }
        assertThat(schedule.getRemindBeforeMinutes()).isNotNull();
        final Long id = schedule.save();
        assertThat(id).isNotNull().isGreaterThan(0L);

        return id;
    }

    public List<Schedule> getAllSchedules() {
        final List<Schedule> schedules = new Select()
                .from(Schedule.class)
                .execute();
        assertThat(schedules).isNotNull();

        return schedules;
    }


    public List<Schedule> getTomorrowSchedules() {
        return null;
    }
}
