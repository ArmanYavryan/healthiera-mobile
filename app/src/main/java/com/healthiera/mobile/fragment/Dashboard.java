package com.healthiera.mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.healthiera.mobile.R;
import com.healthiera.mobile.component.base.BaseEditText;
import com.healthiera.mobile.entity.Doctor;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davit on 19.08.2016.
 */
public class Dashboard extends BaseFragment {

    BaseEditText sText;
    ListView pListView;
    List<Doctor> doctors;
    LinearLayout linearLayoutStatus;
    LinearLayout linearLayoutSearch;
    LinearLayout linearLayoutStatusProvider;
    LinearLayout linearLayoutMessageCenter;
    BaseEditText searchProvider;
    private LineGraphSeries<DataPoint> series;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.dashboard, null);

        linearLayoutStatus=(LinearLayout) view.findViewById(R.id.linearLayoutStatus);
        linearLayoutSearch=(LinearLayout) view.findViewById(R.id.linearLayoutSearch);
        linearLayoutStatusProvider=(LinearLayout) view.findViewById(R.id.linearLayoutSearchProvider);
        linearLayoutMessageCenter=(LinearLayout) view.findViewById(R.id.linearLayoutMessageCenter);


        view = healthStatus(view); // drow goals graph

        view = questionsSearch(view); // drow goals graph+

        view = searchProvider(view);

        return view;
    }


    private View healthStatus(View view) {
        double goals, days;
        goals = 0.5;
        GraphView graphview = (GraphView) view.findViewById(R.id.gvHealthStatus);
        series = new LineGraphSeries<DataPoint>();
        for (int i = 0; i < 500; i++) {
            goals = goals + 0.1;
            days = Math.sin(goals);
            series.appendData(new DataPoint(goals, days), true, 500);
        }
        graphview.addSeries(series);
        return view;
    }

    private View questionsSearch(View view) {

        return view;
    }

    private View searchProvider(View view) {
        sText = (BaseEditText) view.findViewById(R.id.etSearchProvider);
        pListView = (ListView) view.findViewById(R.id.lvSearchProvider);

        doctors=new ArrayList<>();
        doctors.add(new Doctor("Andranik","Ortoped","099112233","andrani@gmail.com"));
        doctors.add(new Doctor("Karen","Ginekolog","099569874","Karen@gmail.com"));
        doctors.add(new Doctor("Hayk","Dentist","055693214","Hayk@gmail.com"));
        doctors.add(new Doctor("Anahit","Ortoped","098159753","Anahit@gmail.com"));
//        doctors=new Select()
//                .from(Doctor.class)
//                .execute();

        Log.e("xxxx",""+doctors.size());


        pListView.setAdapter(new BaseEditText.CustomAdapter(this, (ArrayList<Doctor>)doctors));
        sText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    linearLayoutSearch.setVisibility(View.GONE);
                    linearLayoutStatus.setVisibility(View.GONE);
                    linearLayoutMessageCenter.setVisibility(View.GONE);
                    pListView.setVisibility(View.VISIBLE);
                }
            }
        });
        sText.addTextChangedListener(new TextWatcher() {
            //Event when changed word on EditTex

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                ArrayList<Doctor> temp = new ArrayList<Doctor>();
                int textlength = sText.getText().length();
                temp.clear();
                for (int i = 0; i < doctors.size(); i++) {
                    if (textlength <= doctors.get(i).getName().length()) {
                        if (sText.getText().toString().equalsIgnoreCase(
                                (String)
                                        doctors.get(i).getName().subSequence(0,
                                                textlength))) {
                            temp.add(doctors.get(i));
                        }
                    }
                }
                pListView.setAdapter(new BaseEditText.CustomAdapter(Dashboard.this, temp));
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }


        });
        return view;
    }



}
