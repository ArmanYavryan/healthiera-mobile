package com.healthiera.mobile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.fragment.healthData.CompAndSymp;
import com.healthiera.mobile.fragment.healthData.Heredity;
import com.healthiera.mobile.fragment.healthData.Status;

/**
 * Created by Davit on 11.09.2016.
 */
public class HealthData extends BaseFragment {
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.tv1:
                    CompAndSymp compAndSymp = new CompAndSymp();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, compAndSymp).commit();
                    break;
                case R.id.tv2:
                    Heredity heredity = new Heredity();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, heredity).commit();
                    break;
                case R.id.tv3:
                    Status status = new Status();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, status).commit();
                    break;
                case R.id.tv4:
                    HealthData healthData = new HealthData();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, healthData).commit();
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.health_data, container, false);

        TextView tv1 = (TextView) rootView.findViewById(R.id.tv1);
        TextView tv2 = (TextView) rootView.findViewById(R.id.tv2);
        TextView tv3 = (TextView) rootView.findViewById(R.id.tv3);
        TextView tv4 = (TextView) rootView.findViewById(R.id.tv4);


        tv1.setOnClickListener(onClickListener);
        tv2.setOnClickListener(onClickListener);
        tv3.setOnClickListener(onClickListener);
        tv4.setOnClickListener(onClickListener);
        View view = inflater.inflate(R.layout.activity_main, container, false);
        return rootView;
    }

}