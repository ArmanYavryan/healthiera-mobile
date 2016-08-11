package com.healthiera.mobile.activity.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.healthiera.mobile.R;

//import android.widget.TextView;
//import com.activeandroid.ActiveAndroid;
//import com.activeandroid.Configuration;
//import com.activeandroid.query.Select;
//import com.healthiera.mobile.entity.Settings;

public class MainActivity extends AppCompatActivity {

   // private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActiveAndroid.dispose();
//        Configuration dbConfiguration = new Configuration.Builder(this).setDatabaseName("healthiera.db").create();
//        ActiveAndroid.initialize(dbConfiguration);
//
//        Settings st = new Settings("Test_Key","Test_Value");
//        st.save();
//
//        Settings stTest = getRandom();
//        TextView tv = (TextView) findViewById(R.id.TextTextView);
//        tv.setText(stTest.getValue());
    }

//    public static Settings getRandom() {
//        return new Select().from(Settings.class).executeSingle();
//    }
}
