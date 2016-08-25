package com.healthiera.mobile.activity.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.healthiera.mobile.R;
import com.healthiera.mobile.mFragment.Calendar;
import com.healthiera.mobile.mFragment.Dashboard;
import com.healthiera.mobile.mFragment.Goals;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    private AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.AHBottomNavigation_id);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();
    }

    private void createNavItems() {
        // Create items
        final AHBottomNavigationItem dashboard = new AHBottomNavigationItem(R.string.dashboard, R.drawable.dashboard_icon, R.color.menu);
        final AHBottomNavigationItem calendar = new AHBottomNavigationItem(R.string.calendar, R.drawable.calendar_icon, R.color.menu);
        final AHBottomNavigationItem goals = new AHBottomNavigationItem(R.string.goals, R.drawable.goals_icon, R.color.menu);

        // Add items
        bottomNavigation.addItem(dashboard);
        bottomNavigation.addItem(calendar);
        bottomNavigation.addItem(goals);

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
        if (position == 0) {
            final Dashboard dashboard = new Dashboard();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id, dashboard).commit();
        } else if (position == 1) {
            Calendar calendar = new Calendar();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id, calendar).commit();
        } else if (position == 2) {
            Goals goals = new Goals();
            getSupportFragmentManager().beginTransaction().replace(R.id.Content_id, goals).commit();
        }

        return true;
    }
}
