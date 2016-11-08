package com.healthiera.mobile.fragment.healthData;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.healthiera.mobile.R;
import com.healthiera.mobile.entity.HealthDate;
import com.healthiera.mobile.entity.enumeration.HealthDateType;
import com.healthiera.mobile.entity.enumeration.Hormone;
import com.healthiera.mobile.serivce.HealthDateService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Davit Ter-Arakelyan
 * @date 02.11.2016
 */

public class AnamnesisVitae extends Fragment implements CompoundButton.OnCheckedChangeListener {

    Spinner sphormone;
    Button btnSave;
    EditText etStartDate,etEndDate;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    CheckBox cbHypertension, cbGlucocorticoidsintake;
    LinearLayout lGlucocorticoidsintake;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anamnesis_vitae, container, false);

        sphormone = (Spinner) view.findViewById(R.id.sphormone);
        sphormone.setAdapter(new ArrayAdapter<Hormone>(getContext(), android.R.layout.simple_list_item_single_choice, Hormone.values()));

        etStartDate =(EditText) view.findViewById(R.id.etStartDate);
        etEndDate =(EditText) view.findViewById(R.id.etEndDate);

        cbGlucocorticoidsintake =(CheckBox) view.findViewById(R.id.cbGlucocorticoidsintake);
        cbGlucocorticoidsintake.setOnCheckedChangeListener(this);

        lGlucocorticoidsintake =(LinearLayout) view.findViewById(R.id.lGlucocorticoidsintake);

        List<HealthDate> g = new HealthDateService().findGlucocorticoidsIntake();

        if(g.size()==3)
        {
            cbGlucocorticoidsintake.setChecked(true);
            lGlucocorticoidsintake.setVisibility(View.VISIBLE);
            switch (g.get(0).getValue())
            {
                case "Prednizalone":
                    sphormone.setSelection(0);
                    break;
                case "Dexamethazone":
                    sphormone.setSelection(1);
                    break;
                case "Hydrocortizone":
                    sphormone.setSelection(2);
                    break;
            }
                etStartDate.setText(g.get(1).getValue());
                etEndDate.setText(g.get(2).getValue());
            }
        else if(g.size()==1)
        {
            cbGlucocorticoidsintake.setChecked(false);
        }
            btnSave =(Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(onClickListener);

        cbHypertension =(CheckBox) view.findViewById(R.id.cbHypertension);
        cbHypertension.setOnCheckedChangeListener(this);

        HealthDate hd= new HealthDateService().findHealthDatesByType(HealthDateType.Hypertension);
        if(hd!=null) cbHypertension.setChecked(Boolean.valueOf(hd.getValue()));
        return  view;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Date sd = new Date();
            Date ed = new Date();
            if (!etStartDate.getText().toString().isEmpty())
            {
                try {
                    sd = sdf.parse(etStartDate.getText().toString());
                    ed = etEndDate.getText().toString().isEmpty()? null:  sdf.parse(etEndDate.getText().toString());
                } catch (ParseException pe)
                {}
                 new HealthDateService().createGlucocorticoidsIntake(sd, ed, Hormone.values()[sphormone.getSelectedItemPosition()]);
            }
        }};

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId()==R.id.cbHypertension)
        {
        HealthDate healthDate = new HealthDate();
        healthDate.setValue(String.valueOf(isChecked));
        healthDate.setHealthDateType(HealthDateType.Hypertension);
        new HealthDateService().createHealthDate(healthDate);
        }
        else
        if (buttonView.getId()==R.id.cbGlucocorticoidsintake)
        {
            if(isChecked)
                lGlucocorticoidsintake.setVisibility(View.VISIBLE);
            else
            {
                HealthDate healthDate = new HealthDate();
                healthDate.setValue(String.valueOf(isChecked));
                healthDate.setHealthDateType(HealthDateType.Glucocriticoids_intake);
                new HealthDateService().createHealthDate(healthDate);
                lGlucocorticoidsintake.setVisibility(View.GONE);
            }
        }



          }
}
