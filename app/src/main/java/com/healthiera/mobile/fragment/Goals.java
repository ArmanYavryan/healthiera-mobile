package com.healthiera.mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.activeandroid.query.Select;
import com.healthiera.mobile.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davit on 19.08.2016.
 */
public class Goals extends BaseFragment {

    private EditText editTextWight;
    private EditText editTextHeight;
    private EditText editTextMass;
    private EditText editTextThalliumHip;
    private EditText editTextBloodPressureSystolic;
    private EditText editTextBloodPressureDiastolic;
    private EditText editTextPulse;
    private Button editButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//test
        View rootView = inflater.inflate(R.layout.goals,container,false);
        editTextWight=(EditText)rootView.findViewById(R.id.editTextWight);
        editTextHeight=(EditText)rootView.findViewById(R.id.editTextHeight);
        editTextMass=(EditText)rootView.findViewById(R.id.editTextMass);
        editTextThalliumHip=(EditText)rootView.findViewById(R.id.editTextThalliumHip);
        editTextBloodPressureSystolic=(EditText)rootView.findViewById(R.id.editTextBloodPressureSystolic);
        editTextBloodPressureDiastolic=(EditText)rootView.findViewById(R.id.editTextBloodPressureDiastolic);
        editButton=(Button) rootView.findViewById(R.id.buttonEdit);
        editTextPulse=(EditText)rootView.findViewById(R.id.editTextPulse);

//        List<com.healthiera.mobile.entity.Goals> g;// = new ArrayList<>();
//        g=new Select()
//                .from(com.healthiera.mobile.entity.Goals.class)
//                .execute();

        final com.healthiera.mobile.entity.Goals g = new Select().from(com.healthiera.mobile.entity.Goals.class).orderBy("ID DESC").executeSingle();
if(g !=null) {
    editTextWight.setText(g.getWeight()!=null?g.getWeight().toString():"");
    editTextHeight.setText(g.getHeight()!=null?g.getHeight().toString():"");
    editTextMass.setText(g.getBim()!=null?g.getBim().toString():"");
    editTextThalliumHip.setText(g.getRatioThalliumHips()!=null?g.getRatioThalliumHips().toString():"");
    editTextBloodPressureSystolic.setText(g.getBloodPressureSys()!=null?g.getBloodPressureSys().toString():"");
    editTextBloodPressureDiastolic.setText(g.getBloodPressureDia()!=null?g.getBloodPressureDia().toString():"");
    editTextPulse.setText(g.getPulse()!=null?g.getPulse().toString():"");
}
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonEdit();
            }
        });
        return rootView;
    }


    public void onClickButtonEdit(){

        String buttonText=(String) editButton.getText();

        if(buttonText.equals("Edit")){

            editButton.setText("Save");

            editTextWight.setEnabled(true);
            editTextWight.setInputType(InputType.TYPE_CLASS_NUMBER);
            editTextWight.setFocusable(true);
            editTextWight.setFocusableInTouchMode(true);



            editTextHeight.setEnabled(true);
            editTextHeight.setFocusable(true);
            editTextHeight.setInputType(InputType.TYPE_CLASS_NUMBER);
            editTextHeight.setFocusableInTouchMode(true);

            editTextMass.setEnabled(true);
            editTextMass.setFocusable(true);
            editTextMass.setInputType(InputType.TYPE_CLASS_NUMBER);
            editTextMass.setFocusableInTouchMode(true);

            editTextPulse.setEnabled(true);
            editTextPulse.setFocusable(true);
            editTextPulse.setInputType(InputType.TYPE_CLASS_NUMBER);
            editTextPulse.setFocusableInTouchMode(true);

            editTextThalliumHip.setEnabled(true);
            editTextThalliumHip.setFocusable(true);
            editTextThalliumHip.setInputType(InputType.TYPE_CLASS_NUMBER);
            editTextThalliumHip.setFocusableInTouchMode(true);

            editTextBloodPressureSystolic.setEnabled(true);
            editTextBloodPressureSystolic.setFocusable(true);
            editTextBloodPressureSystolic.setInputType(InputType.TYPE_CLASS_NUMBER);
            editTextBloodPressureSystolic.setFocusableInTouchMode(true);

            editTextBloodPressureDiastolic.setEnabled(true);
            editTextBloodPressureDiastolic.setFocusable(true);
            editTextBloodPressureDiastolic.setInputType(InputType.TYPE_CLASS_NUMBER);
            editTextBloodPressureDiastolic.setFocusableInTouchMode(true);
        }else{
            editButton.setText("Edit");

            editTextWight.setEnabled(false);
            editTextWight.setFocusable(false);

            editTextHeight.setEnabled(false);
            editTextHeight.setFocusable(false);

            editTextMass.setEnabled(false);
            editTextMass.setFocusable(false);

            editTextPulse.setEnabled(false);
            editTextPulse.setFocusable(false);

            editTextThalliumHip.setEnabled(false);
            editTextThalliumHip.setFocusable(false);

            editTextBloodPressureSystolic.setEnabled(false);
            editTextBloodPressureSystolic.setFocusable(false);

            editTextBloodPressureDiastolic.setEnabled(false);
            editTextBloodPressureDiastolic.setFocusable(false);


            com.healthiera.mobile.entity.Goals g= new com.healthiera.mobile.entity.Goals();
            g.setWeight(!editTextWight.getText().toString().matches("")? Integer.parseInt(editTextWight.getText().toString()):null);
            g.setHeight(!editTextHeight.getText().toString().matches("")? Integer.parseInt(editTextHeight.getText().toString()):null);
            g.setBim(!editTextMass.getText().toString().matches("")? Integer.parseInt(editTextMass.getText().toString()):null);
            g.setRatioThalliumHips(!editTextThalliumHip.getText().toString().matches("")? Integer.parseInt(editTextThalliumHip.getText().toString()):null);
            g.setBloodPressureSys(!editTextBloodPressureSystolic.getText().toString().matches("")? Integer.parseInt(editTextBloodPressureSystolic.getText().toString()):null);
            g.setBloodPressureDia(!editTextBloodPressureDiastolic.getText().toString().matches("")? Integer.parseInt(editTextBloodPressureDiastolic.getText().toString()):null);
            g.setPulse(!editTextPulse.getText().toString().matches("")? Integer.parseInt(editTextPulse.getText().toString()):null);
            g.save();
        }
    }
}