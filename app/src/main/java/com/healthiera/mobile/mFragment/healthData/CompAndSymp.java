package com.healthiera.mobile.mFragment.healthData;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.activity.main.MainActivity;
import com.healthiera.mobile.mFragment.BaseFragment;
import com.healthiera.mobile.mFragment.HealthData;

public class CompAndSymp extends Fragment implements Animation.AnimationListener {
    Bundle b = new Bundle();
    int i;
    boolean visiblity = false;
    TableRow tr = null;
    TextView tv = null;
    Animation slidedown, slideup;
    EditText howmanytimes;
    TextView b1, b1b, b2, b2b, b3, b3b, b4, b4b, b5, b5b, b6, b6b, b7, b7b;
    RelativeLayout.LayoutParams param1, param2, param3, param4, param5, param6, param7;
    Animation slide_left1, slide_right1, fadein1, fadeout1, slide_left2, slide_right2, fadein2, fadeout2, slide_left3, slide_right3, fadein3, fadeout3,
            slide_left4, slide_right4, fadein4, fadeout4, slide_left5, slide_right5, fadein5, fadeout5, slide_left6, slide_right6, fadein6, fadeout6,
            slide_left7, slide_right7, fadein7, fadeout7;
    boolean onoff1 = false, onoff2 = false, onoff3 = false, onoff4 = false, onoff5 = false, onoff6 = false, onoff7 = false;



//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Intent intent = new Intent(CompAndSymp.this, HealthData.class);
//            startActivity(intent);
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }

    public void onClickBack(View v){
        getActivity().onBackPressed();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_comp_and_symp);

        b1 = (TextView) getActivity().findViewById(R.id.b1);
        b2 = (TextView) getActivity().findViewById(R.id.b2);
        b3 = (TextView) getActivity().findViewById(R.id.b3);
        b4 = (TextView) getActivity().findViewById(R.id.b4);
        b5 = (TextView) getActivity().findViewById(R.id.b5);
        b6 = (TextView) getActivity().findViewById(R.id.b6);
        b7 = (TextView) getActivity().findViewById(R.id.b7);
        b1b = (TextView) getActivity().findViewById(R.id.b1b);
        b2b = (TextView) getActivity().findViewById(R.id.b2b);
        b3b = (TextView) getActivity().findViewById(R.id.b3b);
        b4b = (TextView) getActivity().findViewById(R.id.b4b);
        b5b = (TextView) getActivity().findViewById(R.id.b5b);
        b6b = (TextView) getActivity().findViewById(R.id.b6b);
        b7b = (TextView) getActivity().findViewById(R.id.b7b);
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
        b5b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b5.callOnClick();
            }
        });
        b6b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b6.callOnClick();
            }
        });
        b7b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b7.callOnClick();
            }
        });
        b1b.setText("NO");
        b1.setOnClickListener(yesnoOnclick);
        b2b.setText("NO");
        b2.setOnClickListener(yesnoOnclick);
        b3b.setText("NO");
        b3.setOnClickListener(yesnoOnclick);
        b4b.setText("NO");
        b4.setOnClickListener(ifyesonclick);
        b5b.setText("NO");
        b5.setOnClickListener(yesnoOnclick);
        b6b.setText("NO");
        b6.setOnClickListener(yesnoOnclick);
        b7b.setText("NO");
        b7.setOnClickListener(yesnoOnclick);

        slide_right1 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right);
        slide_right2 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right);
        slide_right3 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right);
        slide_right4 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right);
        slide_right5 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right);
        slide_right6 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right);
        slide_right7 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right);

        slide_left1 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left);
        slide_left2 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left);
        slide_left3 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left);
        slide_left4 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left);
        slide_left5 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left);
        slide_left6 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left);
        slide_left7 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left);

        fadein1 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);
        fadein2 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);
        fadein3 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);
        fadein4 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);
        fadein5 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);
        fadein6 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);
        fadein7 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);
        fadeout1 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);
        fadeout2 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);
        fadeout3 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);
        fadeout4 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);
        fadeout5 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);
        fadeout6 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);
        fadeout7 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);
        slide_left1.setAnimationListener(this);
        slide_left2.setAnimationListener(this);
        slide_left3.setAnimationListener(this);
        slide_left4.setAnimationListener(this);
        slide_left5.setAnimationListener(this);
        slide_left6.setAnimationListener(this);
        slide_left7.setAnimationListener(this);
        slide_right1.setAnimationListener(this);
        slide_right2.setAnimationListener(this);
        slide_right3.setAnimationListener(this);
        slide_right4.setAnimationListener(this);
        slide_right5.setAnimationListener(this);
        slide_right6.setAnimationListener(this);
        slide_right7.setAnimationListener(this);
        fadein1.setAnimationListener(this);
        fadein2.setAnimationListener(this);
        fadein3.setAnimationListener(this);
        fadein4.setAnimationListener(this);
        fadein5.setAnimationListener(this);
        fadein6.setAnimationListener(this);
        fadein7.setAnimationListener(this);
        fadeout1.setAnimationListener(this);
        fadeout2.setAnimationListener(this);
        fadeout3.setAnimationListener(this);
        fadeout4.setAnimationListener(this);
        fadeout5.setAnimationListener(this);
        fadeout6.setAnimationListener(this);
        fadeout7.setAnimationListener(this);
        param1 = (RelativeLayout.LayoutParams) b1.getLayoutParams();
        param1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param2 = (RelativeLayout.LayoutParams) b2.getLayoutParams();
        param2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param3 = (RelativeLayout.LayoutParams) b3.getLayoutParams();
        param3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param4 = (RelativeLayout.LayoutParams) b4.getLayoutParams();
        param4.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param5 = (RelativeLayout.LayoutParams) b5.getLayoutParams();
        param5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param6 = (RelativeLayout.LayoutParams) b6.getLayoutParams();
        param6.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param7 = (RelativeLayout.LayoutParams) b7.getLayoutParams();
        param7.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        howmanytimes = (EditText) getActivity().findViewById(R.id.howmanytimes);
        TextView add = (TextView) getActivity().findViewById(R.id.comp_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.callOnClick();
                String s = howmanytimes.getText().toString();
                if (b4b.getText().toString() == "YES") return;
                else if (!s.isEmpty() && s != null && s.matches("[1-9]*")) {

                    param4.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    param4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                    b4.setLayoutParams(param4);
                    b4.startAnimation(slide_right4);
                    b4b.startAnimation(fadein4);
                } else {
                    howmanytimes.setText("");
                }

            }
        });


        TextView back = (TextView) getActivity().findViewById(R.id.comp_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        tv = (TextView) getActivity().findViewById(R.id.tvSlide_down);
        tr = (TableRow) getActivity().findViewById(R.id.invisible);
        slidedown = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        slideup = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up);
        slideup.setAnimationListener(this);
        slidedown.setAnimationListener(this);

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
    }

    private View.OnClickListener ifyesonclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (b4b.getText().toString() == "NO") {
                tv.callOnClick();
            } else {
                //b4 switch yes
                param4.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                param4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                b4.setLayoutParams(param4);
                b4.startAnimation(slide_left4);
                b4b.startAnimation(fadein4);
                howmanytimes.setText("");
            }
        }



    };


    private View.OnClickListener yesnoOnclick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.b1:
                    if (!onoff1) {
                        param1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                        param1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                        b1.setLayoutParams(param1);
                        b1.startAnimation(slide_right1);
                    } else {
                        param1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        param1.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                        b1.setLayoutParams(param1);
                        b1.startAnimation(slide_left1);
                    }
                    b1b.startAnimation(fadein1);
                    break;
                case R.id.b2:
                    if (!onoff2) {
                        param2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                        param2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                        b2.setLayoutParams(param2);
                        b2.startAnimation(slide_right2);
                    } else {
                        param2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        param2.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                        b2.setLayoutParams(param2);
                        b2.startAnimation(slide_left2);
                    }
                    b2b.startAnimation(fadein2);
                    break;
                case R.id.b3:
                    if (!onoff3) {
                        param3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                        param3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                        b3.setLayoutParams(param3);
                        b3.startAnimation(slide_right3);
                    } else {
                        param3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        param3.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                        b3.setLayoutParams(param3);
                        b3.startAnimation(slide_left3);
                    }
                    b3b.startAnimation(fadein3);
                    break;
                case R.id.b5:
                    if (!onoff5) {
                        param5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                        param5.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                        b5.setLayoutParams(param5);
                        b5.startAnimation(slide_right5);
                    } else {
                        param5.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        param5.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                        b5.setLayoutParams(param5);
                        b5.startAnimation(slide_left5);
                    }
                    b5b.startAnimation(fadein5);
                    break;
                case R.id.b6:
                    if (!onoff6) {
                        param6.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                        param6.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                        b6.setLayoutParams(param6);
                        b6.startAnimation(slide_right6);
                    } else {
                        param6.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        param6.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                        b6.setLayoutParams(param6);
                        b6.startAnimation(slide_left6);
                    }
                    b6b.startAnimation(fadein6);
                    break;
                case R.id.b7:
                    if (!onoff7) {
                        param7.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                        param7.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                        b7.setLayoutParams(param7);
                        b7.startAnimation(slide_right7);
                    } else {
                        param7.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        param7.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
                        b7.setLayoutParams(param7);
                        b7.startAnimation(slide_left7);
                    }
                    b7b.startAnimation(fadein7);
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
            visiblity = false;
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(howmanytimes.getWindowToken(), 0);
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
        }
        else if (animation == slide_right4) {
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
        } else if (animation == slide_right5) {
            param5.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
            param5.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            b5.setLayoutParams(param5);
            onoff5 = !onoff5;
        } else if (animation == slide_left5) {
            param5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            param5.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
            b5.setLayoutParams(param5);
            onoff5 = !onoff5;
        } else if (animation == fadein5) {
            if (!onoff5) {
                b5b.startAnimation(fadeout5);
                b5b.setText("YES");
                b5b.setTextColor(Color.parseColor("#d0ffffff"));
                b5b.setShadowLayer(1, 1, 1, Color.parseColor("#a0000000"));
                b5b.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                b5b.setBackgroundResource(R.drawable.switch_yes_back);
            } else {
                b5b.setText("NO");
                b5b.setTextColor(Color.parseColor("#696969"));
                b5b.setShadowLayer(1, 1, 1, Color.parseColor("#ffffff"));
                b5b.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
                b5b.setBackgroundResource(R.drawable.switch_no_back);
            }
        } else if (animation == slide_right6) {
            param6.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
            param6.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            b6.setLayoutParams(param6);
            onoff6 = !onoff6;
        } else if (animation == slide_left6) {
            param6.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            param6.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
            b6.setLayoutParams(param6);
            onoff6 = !onoff6;
        } else if (animation == fadein6) {
            if (!onoff6) {
                b6b.startAnimation(fadeout6);
                b6b.setText("YES");
                b6b.setTextColor(Color.parseColor("#d0ffffff"));
                b6b.setShadowLayer(1, 1, 1, Color.parseColor("#a0000000"));
                b6b.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                b6b.setBackgroundResource(R.drawable.switch_yes_back);
            } else {
                b6b.setText("NO");
                b6b.setTextColor(Color.parseColor("#696969"));
                b6b.setShadowLayer(1, 1, 1, Color.parseColor("#ffffff"));
                b6b.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
                b6b.setBackgroundResource(R.drawable.switch_no_back);
            }
        } else if (animation == slide_right7) {
            param7.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
            param7.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            b7.setLayoutParams(param7);
            onoff7 = !onoff7;
        } else if (animation == slide_left7) {
            param7.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            param7.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
            b7.setLayoutParams(param7);
            onoff7 = !onoff7;
        } else if (animation == fadein7) {
            if (!onoff7) {
                b7b.startAnimation(fadeout7);
                b7b.setText("YES");
                b7b.setTextColor(Color.parseColor("#d0ffffff"));
                b7b.setShadowLayer(1, 1, 1, Color.parseColor("#a0000000"));
                b7b.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                b7b.setBackgroundResource(R.drawable.switch_yes_back);
            } else {
                b7b.setText("NO");
                b7b.setTextColor(Color.parseColor("#696969"));
                b7b.setShadowLayer(1, 1, 1, Color.parseColor("#ffffff"));
                b7b.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
                b7b.setBackgroundResource(R.drawable.switch_no_back);
            }
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
