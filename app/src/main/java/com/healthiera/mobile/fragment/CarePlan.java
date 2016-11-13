package com.healthiera.mobile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.healthiera.mobile.R;
import com.healthiera.mobile.fragment.Schedule.Appointment;
import com.healthiera.mobile.fragment.Schedule.Measurement;
import com.healthiera.mobile.fragment.Schedule.Medication;
import com.healthiera.mobile.fragment.Schedule.Treatment;


public class CarePlan extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_care_plan, container, false);


        final FloatingActionButton fabMeasurement = (FloatingActionButton) v.findViewById(R.id.fab_measurement);
        final FloatingActionButton fabMedication = (FloatingActionButton) v.findViewById(R.id.fab_medication);
        final FloatingActionButton fabAppointment = (FloatingActionButton) v.findViewById(R.id.fab_appointment);
        final FloatingActionButton fabTreatment = (FloatingActionButton) v.findViewById(R.id.fab_treatment);

        fabAppointment.setOnClickListener(this);
        fabMeasurement.setOnClickListener(this);
        fabMedication.setOnClickListener(this);
        fabTreatment.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.fab_treatment:
                Intent intent = new Intent(getActivity(), Treatment.class);
                startActivity(intent);
                break;

            case R.id.fab_appointment:
                intent = new Intent(getActivity(), Appointment.class);
                startActivity(intent);
                break;

            case R.id.fab_medication:
                intent = new Intent(getActivity(), Medication.class);
                startActivity(intent);
                break;

            case R.id.fab_measurement:
                intent = new Intent(getActivity(), Measurement.class);
                startActivity(intent);
                break;
        }
    }
}
