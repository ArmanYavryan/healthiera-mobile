package com.healthiera.mobile.serivce;

import com.activeandroid.query.Select;
import com.healthiera.mobile.entity.Schedule;
import com.healthiera.mobile.entity.ScheduleTime;
import com.healthiera.mobile.entity.ScheduleTimeLog;
import com.healthiera.mobile.entity.enumeration.DurationType;
import com.healthiera.mobile.entity.enumeration.RepeatType;
import com.healthiera.mobile.entity.enumeration.ScheduleStatus;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Yengibar Manasyan
 * @date 10/18/16
 */
public class ScheduleTimeService {

    private static final int WEEK_DAYS_COUNT = 7;

    private static final ScheduleService SCHEDULE_SERVICE = new ScheduleService();

    private static final ScheduleTimeLogService SCHEDULE_TIME_LOG_SERVICE = new ScheduleTimeLogService();

    public Long createSchedule(ScheduleTime scheduleTime) {
        assertThat(scheduleTime).isNotNull();
        assertThat(scheduleTime.getId()).isNull();
        assertThat(scheduleTime.getSchedule()).isNotNull();
        assertThat(scheduleTime.getTime()).isNotNull();
        final Long id = scheduleTime.save();
        assertThat(id).isNotNull().isGreaterThan(0L);

        return id;
    }

    public List<ScheduleTime> getByScheduleId(Long scheduleId) {
        assertThat(scheduleId).isNotNull();
        final List<ScheduleTime> scheduleTimes = new Select()
                .from(ScheduleTime.class)
                .where("schedule_id = ?", scheduleId)
                .execute();
        assertThat(scheduleTimes).isNotNull();

        return scheduleTimes;
    }

    public List<ScheduleTime> getDateNotDoneScheduleTimes(LocalDate date) {
        assertThat(date).isNotNull();
        final List<Schedule> schedules = SCHEDULE_SERVICE.getAllSchedules();
        final List<ScheduleTime> todayScheduleTimes = new ArrayList<>();
        for (Schedule schedule : schedules) {
            final LocalDate startDate = new LocalDate(schedule.getStartDate());
            if (schedule.getDurationType().equals(DurationType.NUMBER_OF_DAYS)) {
                final int daysToAdd;
                if (schedule.getRepeatType().equals(RepeatType.EVERY_DAY)) {
                    daysToAdd = schedule.getNumberOfRepetition();
                } else if (schedule.getRepeatType().equals(RepeatType.DAYS_INTERVAL)) {
                    daysToAdd = schedule.getNumberOfRepetition() * schedule.getDaysInterval();
                } else {
                    daysToAdd = schedule.getNumberOfRepetition() * WEEK_DAYS_COUNT;
                }
                if (startDate.plusDays(daysToAdd).isAfter(date)) {
                    continue;
                }
            }

            boolean checkTime = false;
            if (schedule.getRepeatType().equals(RepeatType.EVERY_DAY)) {
                checkTime = true;
            } else if (schedule.getRepeatType().equals(RepeatType.DAYS_INTERVAL)) {
                for (int i = 0; i < schedule.getNumberOfRepetition(); i++) {
                    if (startDate.plusDays(i * schedule.getDaysInterval()).isEqual(date)) {
                        checkTime = true;
                    }
                }
            } else {
                final String[] weekDays = schedule.getDaysOfWeek().split(",");
                if (Arrays.asList(weekDays).contains(String.valueOf(date.getDayOfWeek()))) {
                    checkTime = true;
                }
            }

            if (checkTime) {
                final List<ScheduleTime> scheduleTimes = getByScheduleId(schedule.getId());
                final DateTime currentTime = DateTime.now();
                for (ScheduleTime scheduleTime : scheduleTimes) {
                    if (currentTime.isBefore(date.toDateTimeAtStartOfDay().plusMinutes(scheduleTime.getTime()))) {
                        todayScheduleTimes.add(scheduleTime);
                    } else {
                        final List<ScheduleTimeLog> scheduleTimeLogs = SCHEDULE_TIME_LOG_SERVICE
                                .getByScheduleTimeIdAndDate(scheduleTime.getId(), date);
                        boolean addToList = true;
                        for (ScheduleTimeLog scheduleTimeLog : scheduleTimeLogs) {
                            final ScheduleStatus scheduleStatus = scheduleTimeLog.getScheduleStatus();
                            if (scheduleStatus.equals(ScheduleStatus.DONE) ||
                                    scheduleStatus.equals(ScheduleStatus.CANCELLED) ||
                                    scheduleStatus.equals(ScheduleStatus.DELETED)) {
                                addToList = false;
                            }
                        }
                        if (addToList) {
                            todayScheduleTimes.add(scheduleTime);
                        }
                    }
                }
            }
        }

        return todayScheduleTimes;
    }
}
