package com.healthiera.mobile.fragment.healthData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.activeandroid.query.Select;
import com.healthiera.mobile.R;
import com.healthiera.mobile.entity.HealthDate;
import com.healthiera.mobile.entity.enumeration.HealthDateType;
import com.healthiera.mobile.serivce.HealthDateService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Complains extends Fragment implements Animation.AnimationListener, View.OnClickListener {

    private boolean
            obesty = false,
            thirsty = false,
            profuseSweating = false,
            nocturia = false,
            polyuria = false,
            polydipsia = false,
            bulimia = false;

    private Animation
            obesty_toggle_on,
            obesty_toggle_off,
            thirsty_toggle_on,
            thirsty_toggle_off,
            profuseSweating_toggle_on,
            profuseSweating_toggle_off,
            nocturia_toggle_on,
            nocturia_toggle_off,
            polyuria_toggle_on,
            polyuria_toggle_off,
            polydipsia_toggle_on,
            polydipsia_toggle_off,
            bulimia_toggle_on,
            bulimia_toggle_off;

    private ImageView
            obesty_thumb,
            obesty_track,
            thirsty_thumb,
            thirsty_track,
            profuseSweating_thumb,
            profuseSweating_track,
            nocturia_thumb,
            nocturia_track,
            polyuria_thumb,
            polyuria_track,
            polydipsia_thumb,
            polydipsia_track,
            bulimia_thumb,
            bulimia_track;
    LinearLayout urination;
    EditText nocturia_text_input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complains, container, false);

        initializeView(view);

        ImageView add = (ImageView) view.findViewById(R.id.nocturia_add);
        nocturia_text_input = (EditText) view.findViewById(R.id.nocturia_text_input);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerForToggle4();
                if (nocturia_text_input.getText().toString().length() != 0) {
                    if (!nocturia) {
                        nocturia_thumb.startAnimation(nocturia_toggle_on);
                        nocturia = true;
                    }
                } else {
                    if (nocturia) {
                        nocturia_thumb.startAnimation(nocturia_toggle_off);
                        nocturia = false;

                    }
                }
                HealthDate healthDate = new HealthDate();
                healthDate.setHealthDateType(HealthDateType.Nocturia);
                healthDate.setValue(nocturia_text_input.getText().toString());
                healthDate.save();
            }
        });

        return view;
    }

    private void initializeView(View view) {

        urination = (LinearLayout) view.findViewById(R.id.urination);
        obesty_track = (ImageView) view.findViewById(R.id.obesty_track);
        obesty_thumb = (ImageView) view.findViewById(R.id.obesty_thumb);
        HealthDate hd = new HealthDateService().findHealthDatesByType(HealthDateType.Obesty);
        if(hd!=null && hd.getValue().equals("true"))
        {
           obesty_track.setImageResource(R.drawable.switch_track);
           obesty_thumb.setImageResource(R.drawable.switch_thumb);
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) obesty_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            obesty = !obesty;
        }
        int toX = obesty_track.getLayoutParams().width - obesty_thumb.getLayoutParams().width;
        int to_X = obesty_thumb.getLayoutParams().width - obesty_track.getLayoutParams().width;

        obesty_toggle_on = new TranslateAnimation(0, toX, 0, 0);
        obesty_toggle_on.setInterpolator(new LinearInterpolator());
        obesty_toggle_on.setFillAfter(true);
        obesty_toggle_on.setDuration(200);
        obesty_toggle_off = new TranslateAnimation(0, to_X, 0, 0);
        obesty_toggle_off.setInterpolator(new LinearInterpolator());
        obesty_toggle_off.setFillAfter(true);
        obesty_toggle_off.setDuration(200);
        obesty_toggle_on.setAnimationListener(this);
        obesty_toggle_off.setAnimationListener(this);
        obesty_track.setOnClickListener(this);
        obesty_thumb.setOnClickListener(this);
        ////

        thirsty_track = (ImageView) view.findViewById(R.id.thirsty_track);
        thirsty_thumb = (ImageView) view.findViewById(R.id.thirsty_thumb);

        hd = new HealthDateService().findHealthDatesByType(HealthDateType.Thirsty);
        if(hd!=null && hd.getValue().equals("true"))
        {
            thirsty_track.setImageResource(R.drawable.switch_track);
            thirsty_thumb.setImageResource(R.drawable.switch_thumb);
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thirsty_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            thirsty = !thirsty;
        }

        thirsty_toggle_on = new TranslateAnimation(0, toX, 0, 0);
        thirsty_toggle_on.setInterpolator(new LinearInterpolator());
        thirsty_toggle_on.setFillAfter(true);
        thirsty_toggle_on.setDuration(200);
        thirsty_toggle_off = new TranslateAnimation(0, to_X, 0, 0);
        thirsty_toggle_off.setInterpolator(new LinearInterpolator());
        thirsty_toggle_off.setFillAfter(true);
        thirsty_toggle_off.setDuration(200);
        thirsty_toggle_on.setAnimationListener(this);
        thirsty_toggle_off.setAnimationListener(this);
        thirsty_track.setOnClickListener(this);
        thirsty_thumb.setOnClickListener(this);
        ////
        profuseSweating_track = (ImageView) view.findViewById(R.id.profuseSweating_track);
        profuseSweating_thumb = (ImageView) view.findViewById(R.id.profuseSweating_thumb);
        hd = new HealthDateService().findHealthDatesByType(HealthDateType.Profuse_Sweating);
        if(hd!=null && hd.getValue().equals("true"))
        {
            profuseSweating_track.setImageResource(R.drawable.switch_track);
            profuseSweating_thumb.setImageResource(R.drawable.switch_thumb);
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) profuseSweating_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            profuseSweating = !profuseSweating;
        }
        profuseSweating_toggle_on = new TranslateAnimation(0, toX, 0, 0);
        profuseSweating_toggle_on.setInterpolator(new LinearInterpolator());
        profuseSweating_toggle_on.setFillAfter(true);
        profuseSweating_toggle_on.setDuration(200);
        profuseSweating_toggle_off = new TranslateAnimation(0, to_X, 0, 0);
        profuseSweating_toggle_off.setInterpolator(new LinearInterpolator());
        profuseSweating_toggle_off.setFillAfter(true);
        profuseSweating_toggle_off.setDuration(200);
        profuseSweating_toggle_on.setAnimationListener(this);
        profuseSweating_toggle_off.setAnimationListener(this);
        profuseSweating_track.setOnClickListener(this);
        profuseSweating_thumb.setOnClickListener(this);
////
        nocturia_track = (ImageView) view.findViewById(R.id.nocturia_track);
        nocturia_thumb = (ImageView) view.findViewById(R.id.nocturia_thumb);

        hd = new HealthDateService().findHealthDatesByType(HealthDateType.Nocturia);
        if(hd!=null && !hd.getValue().equals(""))
        {
            nocturia_track.setImageResource(R.drawable.switch_track);
            nocturia_thumb.setImageResource(R.drawable.switch_thumb);
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) nocturia_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            nocturia = !nocturia;
            EditText nocturia_text_input= (EditText) view.findViewById(R.id.nocturia_text_input);
            nocturia_text_input.setText(hd.getValue());
        }

        nocturia_toggle_on = new TranslateAnimation(0, toX, 0, 0);
        nocturia_toggle_on.setInterpolator(new LinearInterpolator());
        nocturia_toggle_on.setFillAfter(true);
        nocturia_toggle_on.setDuration(200);
        nocturia_toggle_off = new TranslateAnimation(0, to_X, 0, 0);
        nocturia_toggle_off.setInterpolator(new LinearInterpolator());
        nocturia_toggle_off.setFillAfter(true);
        nocturia_toggle_off.setDuration(200);
        nocturia_toggle_on.setAnimationListener(this);
        nocturia_toggle_off.setAnimationListener(this);
        nocturia_track.setOnClickListener(this);
        nocturia_thumb.setOnClickListener(this);
////
        polyuria_track = (ImageView) view.findViewById(R.id.polyuria_track);
        polyuria_thumb = (ImageView) view.findViewById(R.id.polyuria_thumb);
        hd = new HealthDateService().findHealthDatesByType(HealthDateType.Polyuria);
        if(hd!=null && hd.getValue().equals("true"))
        {
            polyuria_track.setImageResource(R.drawable.switch_track);
            polyuria_thumb.setImageResource(R.drawable.switch_thumb);
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) polyuria_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            polyuria = !polyuria;
        }
        polyuria_toggle_on = new TranslateAnimation(0, toX, 0, 0);
        polyuria_toggle_on.setInterpolator(new LinearInterpolator());
        polyuria_toggle_on.setFillAfter(true);
        polyuria_toggle_on.setDuration(200);
        polyuria_toggle_off = new TranslateAnimation(0, to_X, 0, 0);
        polyuria_toggle_off.setInterpolator(new LinearInterpolator());
        polyuria_toggle_off.setFillAfter(true);
        polyuria_toggle_off.setDuration(200);
        polyuria_toggle_on.setAnimationListener(this);
        polyuria_toggle_off.setAnimationListener(this);
        polyuria_track.setOnClickListener(this);
        polyuria_thumb.setOnClickListener(this);
////
        polydipsia_track = (ImageView) view.findViewById(R.id.polydipsia_track);
        polydipsia_thumb = (ImageView) view.findViewById(R.id.polydipsia_thumb);

        hd = new HealthDateService().findHealthDatesByType(HealthDateType.Polydipsia);
        if(hd!=null && hd.getValue().equals("true"))
        {
            polydipsia_track.setImageResource(R.drawable.switch_track);
            polydipsia_thumb.setImageResource(R.drawable.switch_thumb);
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) polydipsia_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            polydipsia = !polydipsia;
        }
        polydipsia_toggle_on = new TranslateAnimation(0, toX, 0, 0);
        polydipsia_toggle_on.setInterpolator(new LinearInterpolator());
        polydipsia_toggle_on.setFillAfter(true);
        polydipsia_toggle_on.setDuration(200);
        polydipsia_toggle_off = new TranslateAnimation(0, to_X, 0, 0);
        polydipsia_toggle_off.setInterpolator(new LinearInterpolator());
        polydipsia_toggle_off.setFillAfter(true);
        polydipsia_toggle_off.setDuration(200);
        polydipsia_toggle_on.setAnimationListener(this);
        polydipsia_toggle_off.setAnimationListener(this);
        polydipsia_track.setOnClickListener(this);
        polydipsia_thumb.setOnClickListener(this);
////
        bulimia_track = (ImageView) view.findViewById(R.id.bulimia_track);
        bulimia_thumb = (ImageView) view.findViewById(R.id.bulimia_thumb);

        hd = new HealthDateService().findHealthDatesByType(HealthDateType.Bulimia);
        if(hd!=null && hd.getValue().equals("true"))
        {
            bulimia_track.setImageResource(R.drawable.switch_track);
            bulimia_thumb.setImageResource(R.drawable.switch_thumb);
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) bulimia_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            bulimia = !bulimia;
        }

        bulimia_toggle_on = new TranslateAnimation(0, toX, 0, 0);
        bulimia_toggle_on.setInterpolator(new LinearInterpolator());
        bulimia_toggle_on.setFillAfter(true);
        bulimia_toggle_on.setDuration(200);
        bulimia_toggle_off = new TranslateAnimation(0, to_X, 0, 0);
        bulimia_toggle_off.setInterpolator(new LinearInterpolator());
        bulimia_toggle_off.setFillAfter(true);
        bulimia_toggle_off.setDuration(200);
        bulimia_toggle_on.setAnimationListener(this);
        bulimia_toggle_off.setAnimationListener(this);
        bulimia_track.setOnClickListener(this);
        bulimia_thumb.setOnClickListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        if (animation == obesty_toggle_on) {
            obesty_thumb.setClickable(false);
            obesty_track.setClickable(false);
            obesty_thumb.setImageResource(R.drawable.switch_thumb);
            obesty_track.setImageResource(R.drawable.switch_track);
        } else if (animation == obesty_toggle_off) {
            obesty_thumb.setClickable(false);
            obesty_track.setClickable(false);
            obesty_thumb.setImageResource(R.drawable.switch_thumb_off);
            obesty_track.setImageResource(R.drawable.switch_track_off);
        } else if (animation == thirsty_toggle_on) {
            thirsty_thumb.setClickable(false);
            thirsty_track.setClickable(false);
            thirsty_thumb.setImageResource(R.drawable.switch_thumb);
            thirsty_track.setImageResource(R.drawable.switch_track);
        } else if (animation == thirsty_toggle_off) {
            thirsty_thumb.setClickable(false);
            thirsty_track.setClickable(false);
            thirsty_thumb.setImageResource(R.drawable.switch_thumb_off);
            thirsty_track.setImageResource(R.drawable.switch_track_off);
        } else if (animation == profuseSweating_toggle_on) {
            profuseSweating_thumb.setClickable(false);
            profuseSweating_track.setClickable(false);
            profuseSweating_thumb.setImageResource(R.drawable.switch_thumb);
            profuseSweating_track.setImageResource(R.drawable.switch_track);
        } else if (animation == profuseSweating_toggle_off) {
            profuseSweating_thumb.setClickable(false);
            profuseSweating_track.setClickable(false);
            profuseSweating_thumb.setImageResource(R.drawable.switch_thumb_off);
            profuseSweating_track.setImageResource(R.drawable.switch_track_off);
        } else if (animation == nocturia_toggle_on) {
            nocturia_thumb.setClickable(false);
            nocturia_track.setClickable(false);
            nocturia_thumb.setImageResource(R.drawable.switch_thumb);
            nocturia_track.setImageResource(R.drawable.switch_track);
        } else if (animation == nocturia_toggle_off) {
            nocturia_thumb.setClickable(false);
            nocturia_track.setClickable(false);
            nocturia_thumb.setImageResource(R.drawable.switch_thumb_off);
            nocturia_track.setImageResource(R.drawable.switch_track_off);
        } else if (animation == polyuria_toggle_on) {
            polyuria_thumb.setClickable(false);
            polyuria_track.setClickable(false);
            polyuria_thumb.setImageResource(R.drawable.switch_thumb);
            polyuria_track.setImageResource(R.drawable.switch_track);
        } else if (animation == polyuria_toggle_off) {
            polyuria_thumb.setClickable(false);
            polyuria_track.setClickable(false);
            polyuria_thumb.setImageResource(R.drawable.switch_thumb_off);
            polyuria_track.setImageResource(R.drawable.switch_track_off);
        } else if (animation == polydipsia_toggle_on) {
            polydipsia_thumb.setClickable(false);
            polydipsia_track.setClickable(false);
            polydipsia_thumb.setImageResource(R.drawable.switch_thumb);
            polydipsia_track.setImageResource(R.drawable.switch_track);
        } else if (animation == polydipsia_toggle_off) {
            polydipsia_thumb.setClickable(false);
            polydipsia_track.setClickable(false);
            polydipsia_thumb.setImageResource(R.drawable.switch_thumb_off);
            polydipsia_track.setImageResource(R.drawable.switch_track_off);
        }
        else if (animation == bulimia_toggle_on) {
            bulimia_thumb.setClickable(false);
            bulimia_track.setClickable(false);
            bulimia_thumb.setImageResource(R.drawable.switch_thumb);
            bulimia_track.setImageResource(R.drawable.switch_track);
        } else if (animation == bulimia_toggle_off) {
            bulimia_thumb.setClickable(false);
            bulimia_track.setClickable(false);
            bulimia_thumb.setImageResource(R.drawable.switch_thumb_off);
            bulimia_track.setImageResource(R.drawable.switch_track_off);
        }

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (animation == obesty_toggle_on) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) obesty_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            obesty_thumb.setLayoutParams(layout);
            obesty_thumb.clearAnimation();
            obesty_thumb.setClickable(true);
            obesty_track.setClickable(true);

        } else if (animation == obesty_toggle_off) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) obesty_thumb.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            obesty_thumb.setLayoutParams(layout);
            obesty_thumb.clearAnimation();
            obesty_thumb.setClickable(true);
            obesty_track.setClickable(true);
        } else if (animation == thirsty_toggle_on) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thirsty_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            thirsty_thumb.setLayoutParams(layout);
            thirsty_thumb.clearAnimation();
            thirsty_thumb.setClickable(true);
            thirsty_track.setClickable(true);

        } else if (animation == thirsty_toggle_off) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thirsty_thumb.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            thirsty_thumb.setLayoutParams(layout);
            thirsty_thumb.clearAnimation();
            thirsty_thumb.setClickable(true);
            thirsty_track.setClickable(true);
        } else if (animation == profuseSweating_toggle_on) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) profuseSweating_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            profuseSweating_thumb.setLayoutParams(layout);
            profuseSweating_thumb.clearAnimation();
            profuseSweating_thumb.setClickable(true);
            profuseSweating_track.setClickable(true);

        } else if (animation == profuseSweating_toggle_off) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) profuseSweating_thumb.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            profuseSweating_thumb.setLayoutParams(layout);
            profuseSweating_thumb.clearAnimation();
            profuseSweating_thumb.setClickable(true);
            profuseSweating_track.setClickable(true);
        } else if (animation == nocturia_toggle_on) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) nocturia_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            nocturia_thumb.setLayoutParams(layout);
            nocturia_thumb.clearAnimation();
            nocturia_thumb.setClickable(true);
            nocturia_track.setClickable(true);

        } else if (animation == nocturia_toggle_off) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) nocturia_thumb.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            nocturia_thumb.setLayoutParams(layout);
            nocturia_thumb.clearAnimation();
            nocturia_thumb.setClickable(true);
            nocturia_track.setClickable(true);
        } else if (animation == polyuria_toggle_on) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) polyuria_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            polyuria_thumb.setLayoutParams(layout);
            polyuria_thumb.clearAnimation();
            polyuria_thumb.setClickable(true);
            polyuria_track.setClickable(true);

        } else if (animation == polyuria_toggle_off) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) polyuria_thumb.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            polyuria_thumb.setLayoutParams(layout);
            polyuria_thumb.clearAnimation();
            polyuria_thumb.setClickable(true);
            polyuria_track.setClickable(true);
        } else if (animation == polydipsia_toggle_on) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) polydipsia_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            polydipsia_thumb.setLayoutParams(layout);
            polydipsia_thumb.clearAnimation();
            polydipsia_thumb.setClickable(true);
            polydipsia_track.setClickable(true);

        } else if (animation == polydipsia_toggle_off) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) polydipsia_thumb.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            polydipsia_thumb.setLayoutParams(layout);
            polydipsia_thumb.clearAnimation();
            polydipsia_thumb.setClickable(true);
            polydipsia_track.setClickable(true);
        } else if (animation == bulimia_toggle_on) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) bulimia_thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            bulimia_thumb.setLayoutParams(layout);
            bulimia_thumb.clearAnimation();
            bulimia_thumb.setClickable(true);
            bulimia_track.setClickable(true);

        } else if (animation == bulimia_toggle_off) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) bulimia_thumb.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            bulimia_thumb.setLayoutParams(layout);
            bulimia_thumb.clearAnimation();
            bulimia_thumb.setClickable(true);
            bulimia_track.setClickable(true);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onClick(View v) {
        HealthDate healthDate = new HealthDate();
        switch (v.getId()) {
            case R.id.obesty_track:
            case R.id.obesty_thumb:
                if (!obesty) {
                    obesty_thumb.startAnimation(obesty_toggle_on);
                } else
                    obesty_thumb.startAnimation(obesty_toggle_off);
                obesty = !obesty;
                healthDate.setValue(String.valueOf(obesty));
                healthDate.setHealthDateType(HealthDateType.Obesty);
                break;
            case R.id.thirsty_track:
            case R.id.thirsty_thumb:
                if (!thirsty)
                    thirsty_thumb.startAnimation(thirsty_toggle_on);
                else
                    thirsty_thumb.startAnimation(thirsty_toggle_off);
                thirsty=!thirsty;
                healthDate.setValue(String.valueOf(thirsty));
                healthDate.setHealthDateType(HealthDateType.Thirsty);
                break;
            case R.id.profuseSweating_track:
            case R.id.profuseSweating_thumb:
                if (!profuseSweating)
                    profuseSweating_thumb.startAnimation(profuseSweating_toggle_on);
                else
                    profuseSweating_thumb.startAnimation(profuseSweating_toggle_off);
                profuseSweating = !profuseSweating;
                healthDate.setValue(String.valueOf(profuseSweating));
                healthDate.setHealthDateType(HealthDateType.Profuse_Sweating);
                break;
            case R.id.nocturia_track:
            case R.id.nocturia_thumb:
                handlerForToggle4();
                break;
            case R.id.polyuria_track:
            case R.id.polyuria_thumb:
                if (!polyuria)
                    polyuria_thumb.startAnimation(polyuria_toggle_on);
                else
                    polyuria_thumb.startAnimation(polyuria_toggle_off);
                polyuria = !polyuria;
                healthDate.setValue(String.valueOf(polyuria));
                healthDate.setHealthDateType(HealthDateType.Polyuria);
                break;
            case R.id.polydipsia_track:
            case R.id.polydipsia_thumb:
                if (!polydipsia)
                    polydipsia_thumb.startAnimation(polydipsia_toggle_on);
                else
                    polydipsia_thumb.startAnimation(polydipsia_toggle_off);
                polydipsia = !polydipsia;
                healthDate.setValue(String.valueOf(polydipsia));
                healthDate.setHealthDateType(HealthDateType.Polydipsia);
                break;

            case R.id.bulimia_track:
            case R.id.bulimia_thumb:
                if (!bulimia)
                    bulimia_thumb.startAnimation(bulimia_toggle_on);
                else
                    bulimia_thumb.startAnimation(bulimia_toggle_off);
                bulimia = !bulimia;
                healthDate.setValue(String.valueOf(bulimia));
                healthDate.setHealthDateType(HealthDateType.Bulimia);
                break;
        }
            new HealthDateService().createHealthDate(healthDate);
    }

    private void handlerForToggle4() {
        if (urination.getVisibility() == View.GONE) {
            expand(urination);
        } else
            collapse(urination);
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

    private List<HealthDate> getLastRecord(List<HealthDate> healthDate,HealthDateType type)
    {
        List<HealthDate> healthDateObesty = new ArrayList<>();
        for(HealthDate h :healthDate)
        {
            if(h.getHealthDateType()==type)
                healthDateObesty.add(h);
        }

        return healthDateObesty;
    }
}