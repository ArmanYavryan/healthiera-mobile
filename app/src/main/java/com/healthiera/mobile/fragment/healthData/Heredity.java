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

public class Heredity extends Fragment implements CompoundButton.OnCheckedChangeListener {

    boolean switched1 = false, switched2 = false;
    LinearLayout bulimia;
    LinearLayout diabetes_melitus;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    BaseToggleButton b1, b2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heredity, container, false);
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
        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked()) {
            if (!b1.selected)
                b1.switchToggle();
        }
        else
        if (b1.selected)
            b1.switchToggle();
    }
}
