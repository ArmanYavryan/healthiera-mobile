package com.healthiera.mobile.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.healthiera.mobile.R;
import com.healthiera.mobile.activity.main.MakeGraph;
import com.healthiera.mobile.component.base.BaseEditText;
import com.healthiera.mobile.entity.Doctor;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davit on 19.08.2016.
 */
public class Dashboard extends BaseFragment {

    AutoCompleteTextView sText;
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
        MakeGraph makeHealthStatusGraphGraph = new MakeGraph(healthStatusGraph, "Running", view.getContext(), values,"#FF3020");

        float[] values2 = new float[]{20f, 15f, 18f, 17f, 9.5f, 7.1f, 23f};
        GraphView healthStatusGraph2 = (GraphView) view.findViewById(R.id.gvHealthStatus2);
        MakeGraph makeHealthStatusGraphGraph2 = new MakeGraph(healthStatusGraph2, "Eating", view.getContext(), values2,"#23b04c");


        GraphView healthStatusGraph3 = (GraphView) view.findViewById(R.id.gvHealthStatus3);

        BarGraphSeries<DataPoint> barGraphSeries = new BarGraphSeries<DataPoint>();

        for (int i = 0; i < values.length; i++) {
            barGraphSeries.appendData(new DataPoint(i, values[i]), true, values.length);
        }

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
