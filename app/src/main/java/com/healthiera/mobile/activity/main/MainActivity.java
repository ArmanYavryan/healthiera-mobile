package com.healthiera.mobile.activity.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.healthiera.mobile.R;
import com.healthiera.mobile.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO remove this or make to work :D
        databaseHelper = new DatabaseHelper(getApplicationContext());
    }
}
