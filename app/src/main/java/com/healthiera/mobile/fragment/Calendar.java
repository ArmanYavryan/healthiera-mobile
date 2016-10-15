package com.healthiera.mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.serivce.Event.EventBase;

/**
 * Created by Davit on 19.08.2016.
 */
public class Calendar extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.calendar,container,false);
//        TextView TextTextView=(TextView)rootView.findViewById(R.id.TextTextView);
//        EventBase ev = new EventBase();
//        ev.Create();
//        com.healthiera.mobile.entity.Procedure ap = (com.healthiera.mobile.entity.Procedure)ev.Read();
//        TextTextView.setText(ap.getDoctorId().toString());



        return rootView;
    }
}