package com.healthiera.mobile.mFragment.healthData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.activity.main.MainActivity;
import com.healthiera.mobile.mFragment.BaseFragment;

public class Status extends BaseFragment {
    TextView tv1, tv2, tv3, tv4, tv5, tv6;

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Intent intent = new Intent(Status.this, MainActivity.class);
//            startActivity(intent);
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_status);

        tv1 = (TextView) getActivity().findViewById(R.id.tv1);
        tv2 = (TextView) getActivity().findViewById(R.id.tv2);
        tv3 = (TextView) getActivity().findViewById(R.id.tv3);
        tv4 = (TextView) getActivity().findViewById(R.id.tv4);
        tv5 = (TextView) getActivity().findViewById(R.id.tv5);
        tv6 = (TextView) getActivity().findViewById(R.id.tv6);
        tv1.setOnClickListener(onClickListener);
        tv2.setOnClickListener(onClickListener);
        tv3.setOnClickListener(onClickListener);
        tv4.setOnClickListener(onClickListener);
        tv5.setOnClickListener(onClickListener);
        tv6.setOnClickListener(onClickListener);


        Intent intent = getActivity().getIntent();
        String sourcetext = intent.getStringExtra("SourceText");
        String value = intent.getStringExtra("Value");
        if (sourcetext != null) {
            switch (sourcetext) {
                case "Weight":
                    tv1.setText(value);
                    break;
                case "Height":
                    tv2.setText(value);
                    break;
                case "body mass index":
                    tv3.setText(value);
                    break;
                case "thalium/hips":
                    tv4.setText(value);
                    break;
                case "Pulse":
                    tv5.setText(value);
                    break;

                case "Blood presure":
                    tv6.setText(value);
                    break;
            }
        }

        TextView back = (TextView) getActivity().findViewById(R.id.status_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Status.this.getActivity(), MainActivity.class));
            }
        });
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Status.this.getActivity(), etValueActivity.class);
            String s = "null";
            String s2 = "null";
            switch (view.getId()) {
                case R.id.tv1:
                    s = ((TextView) getActivity().findViewById(R.id.status1)).getText().toString();
                    s2 = "Integer";
                    break;
                case R.id.tv2:
                    s = ((TextView) getActivity().findViewById(R.id.status2)).getText().toString();
                    s2 = "Integer";
                    break;
                case R.id.tv3:
                    s = "body mass index";
                    s2 = "Decimal";
                    break;
                case R.id.tv4:
                    s = "thalium/hips";
                    s2 = "Decimal";
                    break;
                case R.id.tv5:
                    s = ((TextView) getActivity().findViewById(R.id.status5)).getText().toString();
                    s2 = "Integer";
                    break;
                case R.id.tv6:
                    s = ((TextView) getActivity().findViewById(R.id.status6)).getText().toString();
                    s2 = "Integer";
                    break;

            }
            intent.putExtra("SourceText", s);
            intent.putExtra("InputType", s2);
            startActivity(intent);
        }
    };
}
