package com.healthiera.mobile.fragment.healthData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.healthiera.mobile.R;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class ValueSet extends Fragment {
    String sourceText;
    ScrollView scrollView;
    EditText etValue;


    public ValueSet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_value_set, container, false);

        TextView tvSource = (TextView) view.findViewById(R.id.tvSource);
        //tvSource.setText(sourceText);
        TextView tvDate = (TextView) view.findViewById(R.id.tvDate);
        TextView tvTime = (TextView) view.findViewById(R.id.tvTime);

        java.util.Calendar c = java.util.Calendar.getInstance();
        Date d = c.getTime();
        java.text.DateFormat df = android.text.format.DateFormat.getDateFormat(view.getContext());
        String s = df.format(d);
        tvDate.setText(s);

        s = c.getTime().toString();
        s = s.substring(11, 16);
        tvTime.setText(s);
        return view;
    }

}
