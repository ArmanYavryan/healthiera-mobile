package com.healthiera.mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.activity.main.MakeGraph;
import com.healthiera.mobile.component.base.BaseEditText;
import com.healthiera.mobile.entity.Doctor;
import com.jjoe64.graphview.GraphView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davit on 19.08.2016.
 */
public class Dashboard extends BaseFragment implements View.OnClickListener {

    AutoCompleteTextView sText;
    ListView pListView;
    List<Doctor> doctors;
    LinearLayout linearLayoutStatus;
    LinearLayout linearLayoutSearch;
    LinearLayout linearLayoutStatusProvider;
    LinearLayout linearLayoutMessageCenter;
    BaseEditText searchProvider;
    private TextView showAdvanced;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dashboard, null);
        showAdvanced = (TextView) view.findViewById(R.id.show_advanced);
        showAdvanced.setOnClickListener(this);
        linearLayoutStatus = (LinearLayout) view.findViewById(R.id.linearLayoutStatus);
        //linearLayoutSearch=(LinearLayout) view.findViewById(R.id.linearLayoutSearch);
        //linearLayoutStatusProvider = (LinearLayout) view.findViewById(R.id.linearLayoutSearchProvider);
        //linearLayoutMessageCenter=(LinearLayout) view.findViewById(R.id.linearLayoutMessageCenter);

        view = healthStatus(view); // drow goals graph

        view = questionsSearch(view); // drow goals graph+

        //view = searchProvider(view);

        return view;
    }
    ////////////////

    ////////////////

    private View healthStatus(View view) {
        float[] values = new float[]{0.2f, 0.6f, 0.8f, 0.5f, 0.1f, 0.3f, 0.6f, 0.8f, 0.7f, 0.4f, 0.1f};
        GraphView healthStatusGraph = (GraphView) view.findViewById(R.id.gvHealthStatus);
        MakeGraph makeHealthStatusGraphGraph = new MakeGraph(healthStatusGraph, "Running", view.getContext(), values, "#FF3020");

        return view;
    }

    private View questionsSearch(View view) {

        return view;
    }

    private View searchProvider(View view) {
        sText = (AutoCompleteTextView) view.findViewById(R.id.etSearchProvider);
        //pListView = (ListView) view.findViewById(R.id.lvSearchProvider);
        doctors = new ArrayList<>();
        doctors.add(new Doctor("Andranik", "Ortoped", "099112233", "andrani@gmail.com"));
        doctors.add(new Doctor("Karen", "Ginekolog", "099569874", "Karen@gmail.com"));
        doctors.add(new Doctor("Hayk", "Dentist", "055693214", "Hayk@gmail.com"));
        doctors.add(new Doctor("Anahit", "Ortoped", "098159753", "Anahit@gmail.com"));
//        doctors=new Select()
//                .from(Doctor.class)
//                .execute();

        Log.e("xxxx", "" + doctors.size());


        pListView.setAdapter(new BaseEditText.CustomAdapter(this, (ArrayList<Doctor>) doctors));
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
            //CalendarFragment when changed word on EditTex

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

    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction().replace(R.id.Content_id_, new StatusGraph()).commit();
    }
}
