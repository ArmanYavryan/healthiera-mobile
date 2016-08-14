package com.healthiera.mobile.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.healthiera.mobile.R;
import com.healthiera.mobile.entity.Appointment;
import com.healthiera.mobile.entity.Event;
import com.healthiera.mobile.entity.Setting;
import com.healthiera.mobile.serivce.AppointmentService;
import com.healthiera.mobile.serivce.EventService;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EventService eventService = new EventService();

    private AppointmentService appointmentService = new AppointmentService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // TODO delete it, just a demo
            final Setting st = new Setting("Test_Key", "Test_Value");
            final Long settingId = st.save();
            final Setting loadedSetting = Setting.load(Setting.class, settingId);
            Log.i(loadedSetting.getKey(), loadedSetting.getValue());
            final Event event = new Event();
            event.setDescription("Event description");
            event.setStartDateTime(new Date());
            eventService.createAppointment(event);
            final Appointment appointment = new Appointment();
            appointment.setDoctorId(55L);
            appointment.setEvent(event);
            final Long savedAppointmentId = appointmentService.createAppointment(appointment);
            final Appointment foundAppointment = appointmentService.findAppointmentById(savedAppointmentId);
            System.out.println(foundAppointment.getDoctorId() + " " + appointment.getEvent().getDescription());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
