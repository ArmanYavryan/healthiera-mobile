package com.healthiera.mobile.mFragment.healthData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.activity.main.MainActivity;
import com.healthiera.mobile.mFragment.BaseFragment;

public class Heredity extends BaseFragment implements Animation.AnimationListener, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener, View.OnTouchListener {
    TextView b1, b2, b3, b4, b1b, b2b, b3b, b4b;
    boolean visiblity = false;
    TableRow tr = null;
    TextView tv = null;
    boolean visiblity2 = false;
    TableRow tr2 = null;
    TextView tv2 = null;
    Animation slidedown, slideup;
    Animation slidedown2, slideup2;
    Animation slide_left1, slide_right1, fadein1, fadeout1, slide_left2, slide_right2, fadein2, fadeout2,
            slide_left3, slide_right3, fadein3, fadeout3, slide_left4, slide_right4, fadein4, fadeout4;
    boolean onoff1 = false, onoff2 = false, onoff3 = false, onoff4 = false;
    RelativeLayout.LayoutParams param1, param2, param3, param4;
    CheckBox c1, c2, c3, c4;
    TableLayout tl;
    EditText Mage, Fage, GMage, GFage;
    Spinner spinnerF, spinnerM, spinnerGF, spinnerGM;
    ArrayAdapter<CharSequence> arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_heredity);
        spinnerF = (Spinner) getActivity().findViewById(R.id.spinnerF);
        spinnerM = (Spinner) getActivity().findViewById(R.id.spinnerM);
        spinnerGM = (Spinner) getActivity().findViewById(R.id.spinnerGM);
        spinnerGF = (Spinner) getActivity().findViewById(R.id.spinnerGF);
        arrayAdapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.list, R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerF.setAdapter(arrayAdapter);
        spinnerF.setOnItemSelectedListener(this);
        spinnerM.setAdapter(arrayAdapter);
        spinnerM.setOnItemSelectedListener(this);
        spinnerGM.setAdapter(arrayAdapter);
        spinnerGM.setOnItemSelectedListener(this);
        spinnerGF.setAdapter(arrayAdapter);
        spinnerGF.setOnItemSelectedListener(this);
        Mage = (EditText) getActivity().findViewById(R.id.Mage);
        Fage = (EditText) getActivity().findViewById(R.id.Fage);
        GMage = (EditText) getActivity().findViewById(R.id.GMage);
        GFage = (EditText) getActivity().findViewById(R.id.GFage);

        spinnerF.setOnTouchListener(this);
        spinnerM.setOnTouchListener(this);
        spinnerGF.setOnTouchListener(this);
        spinnerGM.setOnTouchListener(this);
        Mage.setText("");
        Fage.setText("");
        GMage.setText("");
        GFage.setText("");
        Mage.setOnFocusChangeListener(this);
        Fage.setOnFocusChangeListener(this);
        GMage.setOnFocusChangeListener(this);
        GFage.setOnFocusChangeListener(this);
        tl = (TableLayout) getActivity().findViewById(R.id.tl);
        b1 = (TextView) getActivity().findViewById(R.id.b1);
        b2 = (TextView) getActivity().findViewById(R.id.b2);
        b3 = (TextView) getActivity().findViewById(R.id.b3);
        b4 = (TextView) getActivity().findViewById(R.id.b4);
        b1b = (TextView) getActivity().findViewById(R.id.b1b);
        b2b = (TextView) getActivity().findViewById(R.id.b2b);
        b3b = (TextView) getActivity().findViewById(R.id.b3b);
        b4b = (TextView) getActivity().findViewById(R.id.b4b);
        b1b.setText("NO");
        b2b.setText("NO");
        b3b.setText("NO");
        b4b.setText("NO");
        b1.setOnClickListener(ifyesonclick);
        b2.setOnClickListener(ifyesonclick);
        b3.setOnClickListener(yesnoOnclick);
        b4.setOnClickListener(yesnoOnclick);
        b1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.callOnClick();
            }
        });
        b2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.callOnClick();
            }
        });
        b3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.callOnClick();
            }
        });
        b4b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b4.callOnClick();
            }
        });
        slide_right1 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_right);
        slide_right2 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_right);
        slide_right3 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_right);
        slide_right4 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_right);
        slide_left1 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_left);
        slide_left2 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_left);
        slide_left3 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_left);
        slide_left4 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_left);
        fadein1 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fadein);
        fadein2 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fadein);
        fadein3 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fadein);
        fadein4 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fadein);
        fadeout1 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fadeout);
        fadeout2 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fadeout);
        fadeout3 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fadeout);
        fadeout4 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fadeout);
        slide_left1.setAnimationListener(this);
        slide_left2.setAnimationListener(this);
        slide_left3.setAnimationListener(this);
        slide_left4.setAnimationListener(this);
        slide_right1.setAnimationListener(this);
        slide_right2.setAnimationListener(this);
        slide_right3.setAnimationListener(this);
        slide_right4.setAnimationListener(this);
        fadein1.setAnimationListener(this);
        fadein2.setAnimationListener(this);
        fadein3.setAnimationListener(this);
        fadein4.setAnimationListener(this);
        param1 = (RelativeLayout.LayoutParams) b1.getLayoutParams();
        param1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param2 = (RelativeLayout.LayoutParams) b2.getLayoutParams();
        param2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param3 = (RelativeLayout.LayoutParams) b3.getLayoutParams();
        param3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param4 = (RelativeLayout.LayoutParams) b4.getLayoutParams();
        param4.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        c1 = (CheckBox) getActivity().findViewById(R.id.checkBoxF);
        c2 = (CheckBox) getActivity().findViewById(R.id.checkBoxM);
        c3 = (CheckBox) getActivity().findViewById(R.id.checkBoxGM);
        c4 = (CheckBox) getActivity().findViewById(R.id.checkBoxGF);
        c1.setOnCheckedChangeListener(changelistener);
        c2.setOnCheckedChangeListener(changelistener);
        c3.setOnCheckedChangeListener(changelistener);
        c4.setOnCheckedChangeListener(changelistener);
        tv = (TextView) getActivity().findViewById(R.id.tvSlide_down);
        tv2 = (TextView) getActivity().findViewById(R.id.tvSlide_down2);
        tr = (TableRow) getActivity().findViewById(R.id.invisible);
        tr2 = (TableRow) getActivity().findViewById(R.id.invisible2);
        tr.setVisibility(View.GONE);
        tr2.setVisibility(View.GONE);
        slidedown = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_down);
        slideup = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_up);
        slidedown2 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_down);
        slideup2 = AnimationUtils.loadAnimation(this.getActivity(), R.anim.slide_up);
        slideup.setAnimationListener(this);
        slidedown.setAnimationListener(this);
        slideup2.setAnimationListener(this);
        slidedown2.setAnimationListener(this);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!visiblity) {
                    tr.setVisibility(View.VISIBLE);
                    tr.startAnimation(slidedown);
                } else {
                    tr.startAnimation(slideup);
                }
                visiblity = !visiblity;
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!visiblity2) {
                    if (b2b.getText() == "NO") {

                        GFage.setText("");
                        GMage.setText("");
                        Fage.setText("");
                        Mage.setText("");
                        spinnerF.setSelection(0);
                        spinnerM.setSelection(0);
                        spinnerGF.setSelection(0);
                        spinnerGM.setSelection(0);
                    }

                    tr2.setVisibility(View.VISIBLE);
                    tr2.startAnimation(slidedown2);

                } else {
                    tr2.startAnimation(slideup2);
                }
                visiblity2 = !visiblity2;
            }
        });


    }

    private View.OnClickListener ifyesonclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.b1:
                    if (b1b.getText().toString() == "NO") {
                        tv.callOnClick();
                    } else {
                        param1.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                        param1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        b1.setLayoutParams(param1);
                        b1.startAnimation(slide_left1);
                        b1b.startAnimation(fadein1);
                        c1.setChecked(false);
                        c2.setChecked(false);
                        c3.setChecked(false);
                        c4.setChecked(false);
                    }
                    break;
                case R.id.b2:
                    if (b2b.getText().toString() == "NO") {
                        tv2.callOnClick();
                    } else {
                        param2.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                        param2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        b2.setLayoutParams(param2);
                        b2.startAnimation(slide_left2);
                        b2b.startAnimation(fadein2);
                    }
                    break;
            }
        }
    };

    private CompoundButton.OnCheckedChangeListener changelistener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (!c1.isChecked() && !c2.isChecked() && !c3.isChecked() && !c4.isChecked()) {
                param1.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                param1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                b1.setLayoutParams(param1);
                b1.startAnimation(slide_left1);
                b1b.startAnimation(fadein1);
            } else {
                if (b1b.getText().toString() == "YES") return;
                param1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                param1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                b1.setLayoutParams(param1);
                b1.startAnimation(slide_right1);
                b1b.startAnimation(fadein1);
            }
        }
    };

    private View.OnClickListener yesnoOnclick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.b4:
                    if (!onoff4) {
                        param4.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                        param4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                        b4.setLayoutParams(param4);
                        b4.startAnimation(slide_right4);
                    } else {
                        param4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        param4.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                        b4.setLayoutParams(param4);
                        b4.startAnimation(slide_left4);
                    }
                    b4b.startAnimation(fadein4);
                    break;
            }
        }
    };

    @Override
    public void onAnimationStart(Animation animation) {

    }


    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == slideup) {
            tr.setVisibility(View.GONE);
        } else if (animation == slideup2) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(Mage.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(Fage.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(GMage.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(GFage.getWindowToken(), 0);
            func();
            tr2.setVisibility(View.GONE);
        } else if (animation == slide_right1) {
            param1.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
            param1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            b1.setLayoutParams(param1);
            onoff1 = !onoff1;
        } else if (animation == slide_left1) {
            param1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            param1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
            b1.setLayoutParams(param1);
            onoff1 = !onoff1;
        } else if (animation == fadein1) {
            if (!onoff1) {
                b1b.startAnimation(fadeout1);
                b1b.setText("YES");
                b1b.setTextColor(Color.parseColor("#d0ffffff"));
                b1b.setShadowLayer(1, 1, 1, Color.parseColor("#a0000000"));
                b1b.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                b1b.setBackgroundResource(R.drawable.switch_yes_back);
            } else {
                b1b.setText("NO");
                b1b.setTextColor(Color.parseColor("#696969"));
                b1b.setShadowLayer(1, 1, 1, Color.parseColor("#ffffff"));
                b1b.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
                b1b.setBackgroundResource(R.drawable.switch_no_back);
            }
        } else if (animation == slide_right2) {
            param2.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
            param2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            b2.setLayoutParams(param2);
            onoff2 = !onoff2;
        } else if (animation == slide_left2) {
            param2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            param2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
            b2.setLayoutParams(param2);
            onoff2 = !onoff2;
        } else if (animation == fadein2) {
            if (!onoff2) {
                b2b.startAnimation(fadeout2);
                b2b.setText("YES");
                b2b.setTextColor(Color.parseColor("#d0ffffff"));
                b2b.setShadowLayer(1, 1, 1, Color.parseColor("#a0000000"));
                b2b.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                b2b.setBackgroundResource(R.drawable.switch_yes_back);
            } else {
                b2b.setText("NO");
                b2b.setTextColor(Color.parseColor("#696969"));
                b2b.setShadowLayer(1, 1, 1, Color.parseColor("#ffffff"));
                b2b.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
                b2b.setBackgroundResource(R.drawable.switch_no_back);
            }
        } else if (animation == slide_right3) {
            param3.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
            param3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            b3.setLayoutParams(param3);
            onoff3 = !onoff3;
        } else if (animation == slide_left3) {
            param3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            param3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
            b3.setLayoutParams(param3);
            onoff3 = !onoff3;
        } else if (animation == fadein3) {
            if (!onoff3) {
                b3b.startAnimation(fadeout3);
                b3b.setText("YES");
                b3b.setTextColor(Color.parseColor("#d0ffffff"));
                b3b.setShadowLayer(1, 1, 1, Color.parseColor("#a0000000"));
                b3b.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                b3b.setBackgroundResource(R.drawable.switch_yes_back);
            } else {
                b3b.setText("NO");
                b3b.setTextColor(Color.parseColor("#696969"));
                b3b.setShadowLayer(1, 1, 1, Color.parseColor("#ffffff"));
                b3b.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
                b3b.setBackgroundResource(R.drawable.switch_no_back);
            }
        } else if (animation == slide_right4) {
            param4.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
            param4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            b4.setLayoutParams(param4);
            onoff4 = !onoff4;
        } else if (animation == slide_left4) {
            param4.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            param4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
            b4.setLayoutParams(param4);
            onoff4 = !onoff4;
        } else if (animation == fadein4) {
            if (!onoff4) {
                b4b.startAnimation(fadeout4);
                b4b.setText("YES");
                b4b.setTextColor(Color.parseColor("#d0ffffff"));
                b4b.setShadowLayer(1, 1, 1, Color.parseColor("#a0000000"));
                b4b.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                b4b.setBackgroundResource(R.drawable.switch_yes_back);
            } else {
                b4b.setText("NO");
                b4b.setTextColor(Color.parseColor("#696969"));
                b4b.setShadowLayer(1, 1, 1, Color.parseColor("#ffffff"));
                b4b.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
                b4b.setBackgroundResource(R.drawable.switch_no_back);
            }
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    private void switchYes(Button view) {
        view.setBackground(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.switch_yes));
        view.setText("YES");
        view.setTextColor(Color.parseColor("#d0ffffff"));
        view.setShadowLayer(1, 1, 1, Color.parseColor("#a0000000"));
        view.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
    }

    private void switchNo(Button view) {
        view.setBackground(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.switch_no));
        view.setText("NO");
        view.setTextColor(Color.parseColor("#696969"));
        view.setShadowLayer(1, 1, 1, Color.parseColor("#ffffff"));
        view.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Intent intent = new Intent(Heredity.this.getActivity(), MainActivity.class);
//            startActivity(intent);
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public void onFocusChange(View view, boolean b) {
        func();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Fage.clearFocus();
        Mage.clearFocus();
        GFage.clearFocus();
        GMage.clearFocus();
        func();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void func() {
        if ((spinnerF.getSelectedItemPosition() != 0 && !Fage.getText().toString().isEmpty()) ||
                (spinnerM.getSelectedItemPosition() != 0 && !Mage.getText().toString().isEmpty()) ||
                (spinnerGM.getSelectedItemPosition() != 0 && !GMage.getText().toString().isEmpty()) ||
                (spinnerGF.getSelectedItemPosition() != 0 && !GFage.getText().toString().isEmpty())) {

            if (b2b.getText() != "YES") {
                param2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                param2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                b2.setLayoutParams(param2);
                b2.startAnimation(slide_right2);
                b2b.startAnimation(fadein2);
            }
        } else if (b2b.getText() != "NO") {
            param2.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
            param2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            b2.setLayoutParams(param2);
            b2.startAnimation(slide_left2);
            b2b.startAnimation(fadein2);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(Mage.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(Fage.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(GMage.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(GFage.getWindowToken(), 0);
        return false;
    }
}