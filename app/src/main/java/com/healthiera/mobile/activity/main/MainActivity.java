package com.healthiera.mobile.activity.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.fragment.Dashboard;
import com.healthiera.mobile.fragment.Goals;
import com.healthiera.mobile.fragment.HealthData;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //    private EventService eventService = new EventService();
/*

    հին oncreate -մեթոդը

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final Event event = new Event();
//        event.setStartDateTime(new Date());
//        final Long eventId = eventService.createAppointment(event);
//        final Event foundEvent = eventService.findEventById(eventId);
        final Doctor doc1 = new Doctor("Andranik", "Ortoped", "099112233", "andrani@gmail.com");
        Doctor doc2 = new Doctor("Karen", "Ginekolog", "099569874", "Karen@gmail.com");
        Doctor doc3 = new Doctor("Hayk", "Dentist", "055693214", "Hayk@gmail.com");
        Doctor doc4 = new Doctor("Anahit", "Ortoped", "098159753", "Anahit@gmail.com");

        final Long doctorId = doc1.save();
        doc2.save();
        doc3.save();
        doc4.save();
        final Doctor doctor1 = Doctor.load(Doctor.class, doctorId);

        //bottomNavigation = (AHBottomNavigation) findViewById(R.id.AHBottomNavigation_id);
        //bottomNavigation.setOnTabSelectedListener(this);
        //createNavItems();
        getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, new Dashboard()).commit();
    }
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

/// ↓
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().add(R.id.Content_id_, new Dashboard()).commit();

    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.dashboard) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, new Dashboard()).commit();
        } else if (id == R.id.health_data) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, new HealthData()).commit();

        } else if (id == R.id.goals) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, new Goals()).commit();

        } else if (id == R.id.care_plan) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, new CarePlan()).commit();

        } else if (id == R.id.medical_id) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, new MedicalId()).commit();
        } else if (id == R.id.educational_tips) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, new EducationalList()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /*

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
    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        // Show fragments
        if (position == 0) {
            Dashboard dashboard = new Dashboard();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, dashboard).commit();
            toolbarText.setText("Dashboard");
        } else if (position == 1) {
            HealthData healthData = new HealthData();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, healthData).commit();
            toolbarText.setText("HealthData");
        } else if (position == 2) {
            Goals goals = new Goals();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, goals).commit();
            toolbarText.setText("Goals");
        } else if (position == 3) {
            Calendar calendar = new Calendar();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, calendar).commit();
            toolbarText.setText("Calendar");
        } else if (position == 4) {
            Calendar calendar = new Calendar();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id_, calendar).commit();
            toolbarText.setText("Calendar");
        }

        return true;
    }
    public void imageButtonBackEffect(View view){
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
    }
*/
}
