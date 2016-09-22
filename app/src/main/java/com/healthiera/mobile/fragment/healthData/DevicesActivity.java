package com.healthiera.mobile.fragment.healthData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.activity.main.MainActivity;
import com.healthiera.mobile.fragment.BaseFragment;

public class DevicesActivity extends BaseFragment {

    private TextView tv1;

    private TextView tv2;

    private TextView back;

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Intent intent = new Intent(DevicesActivity.this.getActivity(), MainActivity.class);
//            startActivity(intent);
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }
private View.OnClickListener onClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final Intent intent = new Intent(DevicesActivity.this.getActivity(), EtValueActivity.class);
        String s = "null";
        String s2 = "null";
        switch (view.getId()) {
            case R.id.tv1:
                s = "Glucose tolerance test";
                s2 = "Integer";
                break;
            case R.id.tv2:
                s = "Glucose level in urine";
                s2 = "Integer";
                break;
        }
        intent.putExtra("SourceText", s);
        intent.putExtra("InputType", s2);
        startActivity(intent);
    }
};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_devices);
        tv1 = (TextView) getActivity().findViewById(R.id.tv1);
        tv2 = (TextView) getActivity().findViewById(R.id.tv2);
        tv1.setOnClickListener(onClickListener);
        tv2.setOnClickListener(onClickListener);

        final Intent intent = getActivity().getIntent();
        final String sourceText = intent.getStringExtra("SourceText");
        String value = intent.getStringExtra("Value");
        if (sourceText != null) {
            switch (sourceText) {
                case "Glucose tolerance test":
                    tv1.setText(value);
                    break;

                case "Glucose level in urine":
                    tv2.setText(value);
                    break;
            }
        }
    }
}