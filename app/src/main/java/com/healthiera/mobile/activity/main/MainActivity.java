package com.healthiera.mobile.activity.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.healthiera.mobile.R;
import com.healthiera.mobile.entity.Appointment;
import com.healthiera.mobile.entity.Event;
import com.healthiera.mobile.entity.Setting;
import com.healthiera.mobile.mFragment.*;
import com.healthiera.mobile.serivce.AppointmentService;
import com.healthiera.mobile.serivce.EventService;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    private EventService eventService = new EventService();

    private AppointmentService appointmentService = new AppointmentService();

    AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
//            // TODO delete it, just a demo
//            final Setting st = new Setting("Test_Key", "Test_Value");
//            final Long settingId = st.save();
//            final Setting loadedSetting = Setting.load(Setting.class, settingId);
//            Log.i(loadedSetting.getKey(), loadedSetting.getValue());
//            final Event event = new Event();
//            event.setDescription("Event description");
//            event.setStartDateTime(new Date());
//            eventService.createAppointment(event);
//            final Appointment appointment = new Appointment();
//            appointment.setDoctorId(55L);
//            appointment.setEvent(event);
//            final Long savedAppointmentId = appointmentService.createAppointment(appointment);
//            final Appointment foundAppointment = appointmentService.findAppointmentById(savedAppointmentId);
//            System.out.println(foundAppointment.getDoctorId() + " " + appointment.getEvent().getDescription());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }



        //********************************************

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.AHBottomNavigation_id);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();

        //********************************************

    }

    private void createNavItems()
    {
        // Create items
        AHBottomNavigationItem Dashboard = new AHBottomNavigationItem(R.string.dashboard, R.drawable.dashboard_icon,R.color.menu);
        AHBottomNavigationItem Calendar = new AHBottomNavigationItem(R.string.calendar, R.drawable.calendar_icon,R.color.menu);
        AHBottomNavigationItem Goals = new AHBottomNavigationItem(R.string.goals, R.drawable.goals_icon,R.color.menu);

        // Add items
        bottomNavigation.addItem(Dashboard);
        bottomNavigation.addItem(Calendar);
        bottomNavigation.addItem(Goals);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

    }

    /**
     * Called when a tab has been selected (clicked)
     *
     * @param position    int: Position of the selected tab
     * @param wasSelected boolean: true if the tab was already selected
     * @return boolean: true for updating the tab UI, false otherwise
     */
    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        // Show fragments

        if(position==0)
        {
            Dashboard dashboard =new Dashboard();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id,dashboard).commit();
        }
        else
        if(position==1)
        {
            Calendar calendar =new Calendar();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id,calendar).commit();
        }
        else
        if(position==2)
        {
            Goals goals =new Goals();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id,goals).commit();
        }

        return true;
    }
}
