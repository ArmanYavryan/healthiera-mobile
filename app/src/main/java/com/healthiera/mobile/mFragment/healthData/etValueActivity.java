package com.healthiera.mobile.mFragment.healthData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.mFragment.BaseFragment;

import java.util.Date;

public class etValueActivity extends BaseFragment implements Animation.AnimationListener {
    String month, day, sourceText;
    RelativeLayout.LayoutParams param;
    Window w;
    ScrollView scrollView;
    Animation delay;
    EditText etValue;
    boolean banim = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_et_value);
        final Intent intent = getActivity().getIntent();
        sourceText = intent.getExtras().getString("SourceText");
        String inputType = intent.getExtras().getString("InputType");
        scrollView = (ScrollView) getActivity().findViewById(R.id.scroll);
        delay = AnimationUtils.loadAnimation(this.getActivity(), R.anim.delay);
        etValue = (EditText) getActivity().findViewById(R.id.etValue);
        if (inputType.equals("Decimal"))
            etValue.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        else
            etValue.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);


        TextView tvSource = (TextView) getActivity().findViewById(R.id.tvSource);
        tvSource.setText(sourceText);
        TextView tvid = (TextView) getActivity().findViewById(R.id.tvid);
        tvid.setText(sourceText);

        TextView tvDate = (TextView) getActivity().findViewById(R.id.tvDate);
        TextView tvTime = (TextView) getActivity().findViewById(R.id.tvTime);
        java.util.Calendar c = java.util.Calendar.getInstance();
        Date d = c.getTime();
        java.text.DateFormat df = android.text.format.DateFormat.getDateFormat(getActivity().getApplicationContext());
        String s = df.format(d);
        tvDate.setText(s);

        s = c.getTime().toString();
        s = s.substring(11, 16);
        tvTime.setText(s);

        TextView back = (TextView) getActivity().findViewById(R.id.setvalue_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sourceText.equals("Glucose tolerance test") || sourceText.equals("Glucose level in urine"))
                    startActivity(new Intent(etValueActivity.this.getActivity(), DevicesActivity.class));
                else
                    startActivity(new Intent(etValueActivity.this.getActivity(), Status.class));
            }
        });

        final TextView add = (TextView) getActivity().findViewById(R.id.setvalue_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                Intent intent1;
                if (sourceText.equals("Glucose tolerance test") || sourceText.equals("Glucose level in urine"))
                    intent1 = new Intent(etValueActivity.this.getActivity(), DevicesActivity.class);
                else
                    intent1 = new Intent(etValueActivity.this.getActivity(), Status.class);
                intent1.putExtra("SourceText", intent.getExtras().getString("SourceText"));
                intent1.putExtra("Value", etValue.getText().toString());
                startActivity(intent1);
            }
        });
        etValue.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                banim = false;
                return false;
            }
        });
        etValue.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                });
                if (!banim) {
                    scrollView.startAnimation(delay);
                    banim = !banim;
                }
                if (i == KeyEvent.KEYCODE_BACK) {
                    banim = !banim;
                }
                return false;
            }
        });
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//
//            if (sourceText.equals("Glucose tolerance test") || sourceText.equals("Glucose level in urine"))
//                startActivity(new Intent(etValueActivity.this.getActivity(), DevicesActivity.class));
//            else
//                startActivity(new Intent(etValueActivity.this.getActivity(), Status.class));
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }

    private static String theMonth(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == delay) {
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
