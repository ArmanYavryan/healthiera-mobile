package com.healthiera.mobile.activity.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.healthiera.mobile.R;
import com.healthiera.mobile.fragment.Calendar;
import com.healthiera.mobile.fragment.Dashboard;
import com.healthiera.mobile.fragment.Goals;
import com.healthiera.mobile.fragment.HealthData;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    private AHBottomNavigation bottomNavigation;

//    private EventService eventService = new EventService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final Event event = new Event();
//        event.setStartDateTime(new Date());
//        final Long eventId = eventService.createAppointment(event);
//        final Event foundEvent = eventService.findEventById(eventId);
//
//        final Doctor doc1 = new Doctor("Andranik", "Ortoped", "099112233", "andrani@gmail.com");
//        Doctor doc2 = new Doctor("Karen", "Ginekolog", "099569874", "Karen@gmail.com");
//        Doctor doc3 = new Doctor("Hayk", "Dentist", "055693214", "Hayk@gmail.com");
//        Doctor doc4 = new Doctor("Anahit", "Ortoped", "098159753", "Anahit@gmail.com");
//
//        final Long doctorId = doc1.save();
//        doc2.save();
//        doc3.save();
//        doc4.save();
//        final Doctor doctor1 = Doctor.load(Doctor.class, doctorId);

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.AHBottomNavigation_id);
        bottomNavigation.setOnTabSelectedListener(this);
        createNavItems();
    }

    private void createNavItems() {
        // Create items
        final AHBottomNavigationItem dashboard = new AHBottomNavigationItem(R.string.dashboard, R.drawable.dashboard_icon, R.color.menu);
        final AHBottomNavigationItem healthData = new AHBottomNavigationItem(R.string.healthData, R.drawable.health_data_icon, R.color.menu);
        final AHBottomNavigationItem goals = new AHBottomNavigationItem(R.string.goals, R.drawable.goals_icon, R.color.menu);
        final AHBottomNavigationItem calendar = new AHBottomNavigationItem(R.string.calendar, R.drawable.calendar_icon, R.color.menu);
        final AHBottomNavigationItem medical = new AHBottomNavigationItem(R.string.medical, R.drawable.medical_icon, R.color.menu);
        //final AHBottomNavigationItem medications = new AHBottomNavigationItem(R.string.calendar, R.drawable.calendar_icon, R.color.menu);

        // Add items
        bottomNavigation.addItem(dashboard);
        bottomNavigation.addItem(healthData);
        bottomNavigation.addItem(goals);
        bottomNavigation.addItem(calendar);
        bottomNavigation.addItem(medical);
        // bottomNavigation.addItem(medications);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, new Dashboard()).commit();

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
        if (position == 0) {
            Dashboard dashboard = new Dashboard();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, dashboard).commit();
        } else if (position == 1) {
            HealthData healthData = new HealthData();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, healthData).commit();
        } else if (position == 2) {
            Goals goals = new Goals();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, goals).commit();
        } else if (position == 3) {
            Calendar calendar = new Calendar();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, calendar).commit();
        } else if (position == 4) {
            Calendar calendar = new Calendar();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, calendar).commit();
        }

        return true;
    }
}
