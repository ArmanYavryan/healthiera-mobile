package com.healthiera.mobile.fragment.healthData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.healthiera.mobile.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Devices extends Fragment implements View.OnClickListener {
    TextView tv1, tv2;

    public Devices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_devices, container, false);
        tv1 = (TextView) view.findViewById(R.id.tv1);
        tv2 = (TextView) view.findViewById(R.id.tv2);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                getFragmentManager().beginTransaction().replace(R.id.Content_id_, new ValueSet()).commit();
                break;
            case R.id.tv2:
                getFragmentManager().beginTransaction().replace(R.id.Content_id_, new ValueSet()).commit();
                break;
        }
    }
}
