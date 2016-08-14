package com.healthiera.mobile.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.healthiera.mobile.R;
import com.healthiera.mobile.entity.Setting;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // TODO move it to repository
            final Setting st = new Setting("Test_Key", "Test_Value");
            final Long settingId = st.save();
            final Setting loadedSetting = Setting.load(Setting.class, settingId);
            Log.i(loadedSetting.getKey(), loadedSetting.getValue());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
