package com.healthiera.mobile.fragment.healthData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.healthiera.mobile.R;
import com.healthiera.mobile.component.base.BaseToggleButton;
import com.healthiera.mobile.entity.HealthDate;
import com.healthiera.mobile.entity.enumeration.HealthDateType;
import com.healthiera.mobile.serivce.HealthDateService;

import java.util.List;

public class Heredity extends Fragment implements CompoundButton.OnCheckedChangeListener {

    boolean switched1 = false, switched2 = false;
    LinearLayout bulimia;
    LinearLayout diabetes_melitus;
    CheckBox checkBoxF,
             checkBoxM,
             checkBoxGM,
             checkBoxGF;

    CheckBox checkBoxF2,
            checkBoxM2,
            checkBoxGM2,
            checkBoxGF2;
    BaseToggleButton b1,
                     b2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heredity, container, false);
        checkBoxF = (CheckBox) view.findViewById(R.id.checkBoxF);
        checkBoxM = (CheckBox) view.findViewById(R.id.checkBoxM);
        checkBoxGM = (CheckBox) view.findViewById(R.id.checkBoxGM);
        checkBoxGF = (CheckBox) view.findViewById(R.id.checkBoxGF);

        checkBoxF2 = (CheckBox) view.findViewById(R.id.checkBoxF2);
        checkBoxM2 = (CheckBox) view.findViewById(R.id.checkBoxM2);
        checkBoxGM2 = (CheckBox) view.findViewById(R.id.checkBoxGM2);
        checkBoxGF2 = (CheckBox) view.findViewById(R.id.checkBoxGF2);

        bulimia = (LinearLayout) view.findViewById(R.id.bulimia);
        diabetes_melitus = (LinearLayout) view.findViewById(R.id.diabetes_melitus);
        LinearLayout ln = (LinearLayout) view.findViewById(R.id.ln1);
        b1 = new BaseToggleButton(getContext());
        //////////
        HealthDate hd;
        hd= new HealthDateService().findHealthDatesByType(HealthDateType.Bulimia_Father);
        if(hd!=null) checkBoxF.setChecked(Boolean.valueOf(hd.getValue()));
        hd= new HealthDateService().findHealthDatesByType(HealthDateType.Bulimia_Mother);
        if(hd!=null) checkBoxM.setChecked(Boolean.valueOf(hd.getValue()));
        hd= new HealthDateService().findHealthDatesByType(HealthDateType.Bulimia_GF);
        if(hd!=null) checkBoxGF.setChecked(Boolean.valueOf(hd.getValue()));
        hd= new HealthDateService().findHealthDatesByType(HealthDateType.Bulimia_GM);
        if(hd!=null) checkBoxGM.setChecked(Boolean.valueOf(hd.getValue()));

        hd= new HealthDateService().findHealthDatesByType(HealthDateType.Diabet_Melitus_Father);
        if(hd!=null) checkBoxF2.setChecked(Boolean.valueOf(hd.getValue()));
        hd= new HealthDateService().findHealthDatesByType(HealthDateType.Diabet_Melitus_Mother);
        if(hd!=null) checkBoxM2.setChecked(Boolean.valueOf(hd.getValue()));
        hd= new HealthDateService().findHealthDatesByType(HealthDateType.Diabet_Melitus_GF);
        if(hd!=null) checkBoxGF2.setChecked(Boolean.valueOf(hd.getValue()));
        hd= new HealthDateService().findHealthDatesByType(HealthDateType.Diabet_Melitus_GM);
        if(hd!=null) checkBoxGM2.setChecked(Boolean.valueOf(hd.getValue()));
        //////////
        ln.addView(b1);
        b1.thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerForToggle1();
            }
        });
        b1.track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerForToggle1();
            }
        });

        LinearLayout ln2 = (LinearLayout) view.findViewById(R.id.ln2);
        b2 = new BaseToggleButton(getContext());
        ln2.addView(b2);
        b2.thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerForToggle2();
            }
        });
        b2.track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerForToggle2();
            }
        });


        checkBoxF.setOnCheckedChangeListener(this);
        checkBoxM.setOnCheckedChangeListener(this);
        checkBoxGM.setOnCheckedChangeListener(this);
        checkBoxGF.setOnCheckedChangeListener(this);

        checkBoxF2.setOnCheckedChangeListener(this);
        checkBoxM2.setOnCheckedChangeListener(this);
        checkBoxGM2.setOnCheckedChangeListener(this);
        checkBoxGF2.setOnCheckedChangeListener(this);

        return view;
    }

    private void handlerForToggle1() {
        if (bulimia.getVisibility() == View.GONE) {
            expand(bulimia);
        } else
            collapse(bulimia);
    }

    private void handlerForToggle2() {
        if (diabetes_melitus.getVisibility() == View.GONE) {
            expand(diabetes_melitus);
        } else
            collapse(diabetes_melitus);
    }

    public static void expand(final View v) {
        v.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            public void setDuration(long durationMillis) {
                super.setDuration(300);
            }

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            public void setDuration(long durationMillis) {
                super.setDuration(300);
            }

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (checkBoxF.isChecked() || checkBoxM.isChecked() || checkBoxGM.isChecked() || checkBoxGF.isChecked()) {
            if (!b1.selected)
                b1.switchToggle();
            HealthDate healthDate = new HealthDate();
            switch (buttonView.getId())
            {
                case R.id.checkBoxF:
                    healthDate.setValue(String.valueOf(isChecked));
                    healthDate.setHealthDateType(HealthDateType.Bulimia_Father);
                    new HealthDateService().createHealthDate(healthDate);
                    break;
                case R.id.checkBoxM:
                    healthDate.setValue(String.valueOf(isChecked));
                    healthDate.setHealthDateType(HealthDateType.Bulimia_Mother);
                    new HealthDateService().createHealthDate(healthDate);
                    break;
                case R.id.checkBoxGF:
                    healthDate.setValue(String.valueOf(isChecked));
                    healthDate.setHealthDateType(HealthDateType.Bulimia_GF);
                    new HealthDateService().createHealthDate(healthDate);
                    break;
                case R.id.checkBoxGM:
                    healthDate.setValue(String.valueOf(isChecked));
                    healthDate.setHealthDateType(HealthDateType.Bulimia_GM);
                    new HealthDateService().createHealthDate(healthDate);
                    break;
            }
        }
        else
        if (b1.selected)
            b1.switchToggle();

    if (checkBoxF2.isChecked() || checkBoxM2.isChecked() || checkBoxGM2.isChecked() || checkBoxGF2.isChecked()) {
        if (!b2.selected)
            b2.switchToggle();
        HealthDate healthDate = new HealthDate();
        switch (buttonView.getId())
        {
            case R.id.checkBoxF2:
                healthDate.setValue(String.valueOf(isChecked));
                healthDate.setHealthDateType(HealthDateType.Diabet_Melitus_Father);
                new HealthDateService().createHealthDate(healthDate);
                break;
            case R.id.checkBoxM2:
                healthDate.setValue(String.valueOf(isChecked));
                healthDate.setHealthDateType(HealthDateType.Diabet_Melitus_Mother);
                new HealthDateService().createHealthDate(healthDate);
                break;
            case R.id.checkBoxGF2:
                healthDate.setValue(String.valueOf(isChecked));
                healthDate.setHealthDateType(HealthDateType.Diabet_Melitus_GF);
                new HealthDateService().createHealthDate(healthDate);
                break;
            case R.id.checkBoxGM2:
                healthDate.setValue(String.valueOf(isChecked));
                healthDate.setHealthDateType(HealthDateType.Diabet_Melitus_GM);
                new HealthDateService().createHealthDate(healthDate);
                break;
        }
    }
    else
            if (b2.selected)
            b2.switchToggle();
}
}
