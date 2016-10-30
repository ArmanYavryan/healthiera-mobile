package com.healthiera.mobile.fragment.healthData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.component.base.BaseToggleButton;

public class Heredity extends Fragment implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener, View.OnTouchListener {

    LinearLayout bulimia;
    LinearLayout diabetes_melitus;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    BaseToggleButton b1, b2;
    Spinner spDiabetTypeFather, spDiabetTypeMother, spDiabetTypeGrandMother, spDiabetTypeGrandFather;
    TextView age_downF, age_upF, age_downM, age_upM, age_downGF, age_upGF, age_downGM, age_upGM;
    EditText et_ageF, et_ageM, et_ageGF, et_ageGM;

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

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heredity, container, false);

        spDiabetTypeFather = (Spinner) view.findViewById(R.id.spinner_diabet_typeF);
        spDiabetTypeMother = (Spinner) view.findViewById(R.id.spinner_diabet_typeM);
        spDiabetTypeGrandMother = (Spinner) view.findViewById(R.id.spinner_diabet_typeGM);
        spDiabetTypeGrandFather = (Spinner) view.findViewById(R.id.spinner_diabet_typeGF);
        spDiabetTypeFather.setOnItemSelectedListener(this);
        spDiabetTypeMother.setOnItemSelectedListener(this);
        spDiabetTypeGrandMother.setOnItemSelectedListener(this);
        spDiabetTypeGrandFather.setOnItemSelectedListener(this);

        age_downF = (TextView) view.findViewById(R.id.age_downF);
        age_upF = (TextView) view.findViewById(R.id.age_upF);
        age_downM = (TextView) view.findViewById(R.id.age_downM);
        age_upM = (TextView) view.findViewById(R.id.age_upM);
        age_downGF = (TextView) view.findViewById(R.id.age_downGF);
        age_upGF = (TextView) view.findViewById(R.id.age_upGF);
        age_downGM = (TextView) view.findViewById(R.id.age_downGM);
        age_upGM = (TextView) view.findViewById(R.id.age_upGM);
        age_downF.setOnTouchListener(this);
        age_downM.setOnTouchListener(this);
        age_downGM.setOnTouchListener(this);
        age_downGF.setOnTouchListener(this);
        age_upF.setOnTouchListener(this);
        age_upM.setOnTouchListener(this);
        age_upGF.setOnTouchListener(this);
        age_upGM.setOnTouchListener(this);

        et_ageF = (EditText) view.findViewById(R.id.et_ageF);
        et_ageM = (EditText) view.findViewById(R.id.et_ageM);
        et_ageGF = (EditText) view.findViewById(R.id.et_ageGF);
        et_ageGM = (EditText) view.findViewById(R.id.et_ageGM);


        bulimia = (LinearLayout) view.findViewById(R.id.bulimia);
        diabetes_melitus = (LinearLayout) view.findViewById(R.id.diabetes_melitus);

        LinearLayout ln = (LinearLayout) view.findViewById(R.id.ln1);
        b1 = new BaseToggleButton(getContext());
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

        LinearLayout ln3 = (LinearLayout) view.findViewById(R.id.ln3);
        ln3.addView(new BaseToggleButton(getContext()));

        LinearLayout ln4 = (LinearLayout) view.findViewById(R.id.ln4);
        ln4.addView(new BaseToggleButton(getContext()));

        checkBox1 = (CheckBox) view.findViewById(R.id.checkBoxF);
        checkBox2 = (CheckBox) view.findViewById(R.id.checkBoxM);
        checkBox3 = (CheckBox) view.findViewById(R.id.checkBoxGM);
        checkBox4 = (CheckBox) view.findViewById(R.id.checkBoxGF);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);

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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked()) {
            if (!b1.selected)
                b1.switchToggle();
        } else if (b1.selected)
            b1.switchToggle();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (spDiabetTypeFather.getSelectedItemPosition() > 0 || spDiabetTypeMother.getSelectedItemPosition() > 0 ||
                spDiabetTypeGrandFather.getSelectedItemPosition() > 0 || spDiabetTypeGrandMother.getSelectedItemPosition() > 0) {
            if (!b2.selected) b2.switchToggle();
        } else if (b2.selected) b2.switchToggle();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.age_upF:
                if (Integer.parseInt(et_ageF.getText().toString()) != 99) {
                    String s = Integer.parseInt(et_ageF.getText().toString()) + 1 + "";
                    et_ageF.setText(s);
                }
                break;
            case R.id.age_downF:
                if (Integer.parseInt(et_ageF.getText().toString()) != 0) {
                    String s = Integer.parseInt(et_ageF.getText().toString()) - 1 + "";
                    et_ageF.setText(s);
                }
                break;

            case R.id.age_upM:
                if (Integer.parseInt(et_ageM.getText().toString()) != 99) {
                    String s = Integer.parseInt(et_ageM.getText().toString()) + 1 + "";
                    et_ageM.setText(s);
                }
                break;
            case R.id.age_downM:
                if (Integer.parseInt(et_ageM.getText().toString()) != 0) {
                    String s = Integer.parseInt(et_ageM.getText().toString()) - 1 + "";
                    et_ageM.setText(s);
                }
                break;

            case R.id.age_upGF:
                if (Integer.parseInt(et_ageGF.getText().toString()) != 99) {
                    String s = Integer.parseInt(et_ageGF.getText().toString()) + 1 + "";
                    et_ageGF.setText(s);
                }
                break;
            case R.id.age_downGF:
                if (Integer.parseInt(et_ageGF.getText().toString()) != 0) {
                    String s = Integer.parseInt(et_ageGF.getText().toString()) - 1 + "";
                    et_ageGF.setText(s);
                }
                break;

            case R.id.age_upGM:
                if (Integer.parseInt(et_ageGM.getText().toString()) != 99) {
                    String s = Integer.parseInt(et_ageGM.getText().toString()) + 1 + "";
                    et_ageGM.setText(s);
                }
                break;
            case R.id.age_downGM:
                if (Integer.parseInt(et_ageGM.getText().toString()) != 0) {
                    String s = Integer.parseInt(et_ageGM.getText().toString()) - 1 + "";
                    et_ageGM.setText(s);
                }
                break;
        }
        return true;
    }

}
