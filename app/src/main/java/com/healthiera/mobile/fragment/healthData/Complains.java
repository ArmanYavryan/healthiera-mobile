package com.healthiera.mobile.fragment.healthData;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.healthiera.mobile.R;

public class Complains extends Fragment implements Animation.AnimationListener, View.OnClickListener {
    private boolean obesty = false, obesty2 = false, obesty3 = false, obesty4 = false, obesty5 = false, obesty6 = false, obesty7 = false;
    private Animation toggle_on, toggle_off, toggle_on2, toggle_off2, toggle_on3, toggle_off3, toggle_on4, toggle_off4, toggle_on5, toggle_off5,
            toggle_on6, toggle_off6, toggle_on7, toggle_off7;
    private ImageView thumb, track, thumb2, track2, thumb3, track3, thumb4, track4, thumb5, track5, thumb6, track6, thumb7, track7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complains, container, false);

        track = (ImageView) view.findViewById(R.id.track);
        thumb = (ImageView) view.findViewById(R.id.thumb);

        int toX = track.getLayoutParams().width - thumb.getLayoutParams().width;
        int to_X = thumb.getLayoutParams().width - track.getLayoutParams().width;

        toggle_on = new TranslateAnimation(0, toX, 0, 0);
        toggle_on.setInterpolator(new LinearInterpolator());
        toggle_on.setFillAfter(true);
        toggle_on.setDuration(200);
        toggle_off = new TranslateAnimation(0, to_X, 0, 0);
        toggle_off.setInterpolator(new LinearInterpolator());
        toggle_off.setFillAfter(true);
        toggle_off.setDuration(200);
        toggle_on.setAnimationListener(this);
        toggle_off.setAnimationListener(this);
        track.setOnClickListener(this);
        thumb.setOnClickListener(this);
        ////
        track2 = (ImageView) view.findViewById(R.id.track2);
        thumb2 = (ImageView) view.findViewById(R.id.thumb2);
        toggle_on2 = new TranslateAnimation(0, toX, 0, 0);
        toggle_on2.setInterpolator(new LinearInterpolator());
        toggle_on2.setFillAfter(true);
        toggle_on2.setDuration(200);
        toggle_off2 = new TranslateAnimation(0, to_X, 0, 0);
        toggle_off2.setInterpolator(new LinearInterpolator());
        toggle_off2.setFillAfter(true);
        toggle_off2.setDuration(200);
        toggle_on2.setAnimationListener(this);
        toggle_off2.setAnimationListener(this);
        track2.setOnClickListener(this);
        thumb2.setOnClickListener(this);
        ////
        track3 = (ImageView) view.findViewById(R.id.track3);
        thumb3 = (ImageView) view.findViewById(R.id.thumb3);
        toggle_on3 = new TranslateAnimation(0, toX, 0, 0);
        toggle_on3.setInterpolator(new LinearInterpolator());
        toggle_on3.setFillAfter(true);
        toggle_on3.setDuration(200);
        toggle_off3 = new TranslateAnimation(0, to_X, 0, 0);
        toggle_off3.setInterpolator(new LinearInterpolator());
        toggle_off3.setFillAfter(true);
        toggle_off3.setDuration(200);
        toggle_on3.setAnimationListener(this);
        toggle_off3.setAnimationListener(this);
        track3.setOnClickListener(this);
        thumb3.setOnClickListener(this);
////
        track4 = (ImageView) view.findViewById(R.id.track4);
        thumb4 = (ImageView) view.findViewById(R.id.thumb4);
        toggle_on4 = new TranslateAnimation(0, toX, 0, 0);
        toggle_on4.setInterpolator(new LinearInterpolator());
        toggle_on4.setFillAfter(true);
        toggle_on4.setDuration(200);
        toggle_off4 = new TranslateAnimation(0, to_X, 0, 0);
        toggle_off4.setInterpolator(new LinearInterpolator());
        toggle_off4.setFillAfter(true);
        toggle_off4.setDuration(200);
        toggle_on4.setAnimationListener(this);
        toggle_off4.setAnimationListener(this);
        track4.setOnClickListener(this);
        thumb4.setOnClickListener(this);
////
        track5 = (ImageView) view.findViewById(R.id.track5);
        thumb5 = (ImageView) view.findViewById(R.id.thumb5);
        toggle_on5 = new TranslateAnimation(0, toX, 0, 0);
        toggle_on5.setInterpolator(new LinearInterpolator());
        toggle_on5.setFillAfter(true);
        toggle_on5.setDuration(200);
        toggle_off5 = new TranslateAnimation(0, to_X, 0, 0);
        toggle_off5.setInterpolator(new LinearInterpolator());
        toggle_off5.setFillAfter(true);
        toggle_off5.setDuration(200);
        toggle_on5.setAnimationListener(this);
        toggle_off5.setAnimationListener(this);
        track5.setOnClickListener(this);
        thumb5.setOnClickListener(this);
////
        track6 = (ImageView) view.findViewById(R.id.track6);
        thumb6 = (ImageView) view.findViewById(R.id.thumb6);
        toggle_on6 = new TranslateAnimation(0, toX, 0, 0);
        toggle_on6.setInterpolator(new LinearInterpolator());
        toggle_on6.setFillAfter(true);
        toggle_on6.setDuration(200);
        toggle_off6 = new TranslateAnimation(0, to_X, 0, 0);
        toggle_off6.setInterpolator(new LinearInterpolator());
        toggle_off6.setFillAfter(true);
        toggle_off6.setDuration(200);
        toggle_on6.setAnimationListener(this);
        toggle_off6.setAnimationListener(this);
        track6.setOnClickListener(this);
        thumb6.setOnClickListener(this);
////
        track7 = (ImageView) view.findViewById(R.id.track7);
        thumb7 = (ImageView) view.findViewById(R.id.thumb7);
        toggle_on7 = new TranslateAnimation(0, toX, 0, 0);
        toggle_on7.setInterpolator(new LinearInterpolator());
        toggle_on7.setFillAfter(true);
        toggle_on7.setDuration(200);
        toggle_off7 = new TranslateAnimation(0, to_X, 0, 0);
        toggle_off7.setInterpolator(new LinearInterpolator());
        toggle_off7.setFillAfter(true);
        toggle_off7.setDuration(200);
        toggle_on7.setAnimationListener(this);
        toggle_off7.setAnimationListener(this);
        track7.setOnClickListener(this);
        thumb7.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        if (animation == toggle_on || animation == toggle_off) {
            thumb.setClickable(false);
            track.setClickable(false);
        } else if (animation == toggle_on2 || animation == toggle_off2) {
            thumb2.setClickable(false);
            track2.setClickable(false);
        } else if (animation == toggle_on3 || animation == toggle_off3) {
            thumb3.setClickable(false);
            track3.setClickable(false);
        } else if (animation == toggle_on4 || animation == toggle_off4) {
            thumb4.setClickable(false);
            track4.setClickable(false);
        } else if (animation == toggle_on5 || animation == toggle_off5) {
            thumb5.setClickable(false);
            track5.setClickable(false);
        } else if (animation == toggle_on6 || animation == toggle_off6) {
            thumb6.setClickable(false);
            track6.setClickable(false);
        } else if (animation == toggle_on7 || animation == toggle_off7) {
            thumb7.setClickable(false);
            track7.setClickable(false);
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (animation == toggle_on) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            thumb.setLayoutParams(layout);
            thumb.clearAnimation();
            thumb.setClickable(true);
            track.setClickable(true);

        } else if (animation == toggle_off) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            thumb.setLayoutParams(layout);
            thumb.clearAnimation();
            thumb.setClickable(true);
            track.setClickable(true);
        } else if (animation == toggle_on2) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb2.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            thumb2.setLayoutParams(layout);
            thumb2.clearAnimation();
            thumb2.setClickable(true);
            track2.setClickable(true);

        } else if (animation == toggle_off2) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb2.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            thumb2.setLayoutParams(layout);
            thumb2.clearAnimation();
            thumb2.setClickable(true);
            track2.setClickable(true);
        } else if (animation == toggle_on3) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb3.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            thumb3.setLayoutParams(layout);
            thumb3.clearAnimation();
            thumb3.setClickable(true);
            track3.setClickable(true);

        } else if (animation == toggle_off3) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb3.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            thumb3.setLayoutParams(layout);
            thumb3.clearAnimation();
            thumb3.setClickable(true);
            track3.setClickable(true);
        } else if (animation == toggle_on4) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb4.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            thumb4.setLayoutParams(layout);
            thumb4.clearAnimation();
            thumb4.setClickable(true);
            track4.setClickable(true);

        } else if (animation == toggle_off4) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb4.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            thumb4.setLayoutParams(layout);
            thumb4.clearAnimation();
            thumb4.setClickable(true);
            track4.setClickable(true);
        } else if (animation == toggle_on5) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb5.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            thumb5.setLayoutParams(layout);
            thumb5.clearAnimation();
            thumb5.setClickable(true);
            track5.setClickable(true);

        } else if (animation == toggle_off5) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb5.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            thumb5.setLayoutParams(layout);
            thumb5.clearAnimation();
            thumb5.setClickable(true);
            track5.setClickable(true);
        } else if (animation == toggle_on6) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb6.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            thumb6.setLayoutParams(layout);
            thumb6.clearAnimation();
            thumb6.setClickable(true);
            track6.setClickable(true);

        } else if (animation == toggle_off6) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb6.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            thumb6.setLayoutParams(layout);
            thumb6.clearAnimation();
            thumb6.setClickable(true);
            track6.setClickable(true);
        } else if (animation == toggle_on7) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb7.getLayoutParams();
            layout.gravity = Gravity.RIGHT;
            thumb7.setLayoutParams(layout);
            thumb7.clearAnimation();
            thumb7.setClickable(true);
            track7.setClickable(true);

        } else if (animation == toggle_off7) {
            FrameLayout.LayoutParams layout = (FrameLayout.LayoutParams) thumb7.getLayoutParams();
            layout.gravity = Gravity.LEFT;
            thumb7.setLayoutParams(layout);
            thumb7.clearAnimation();
            thumb7.setClickable(true);
            track7.setClickable(true);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.track:
            case R.id.thumb:
                if (!obesty) {
                    thumb.startAnimation(toggle_on);
                } else
                    thumb.startAnimation(toggle_off);
                obesty = !obesty;
                break;
            case R.id.track2:
            case R.id.thumb2:
                if (!obesty2)
                    thumb2.startAnimation(toggle_on2);
                else
                    thumb2.startAnimation(toggle_off2);
                obesty2 = !obesty2;
                break;
            case R.id.track3:
            case R.id.thumb3:
                if (!obesty3)
                    thumb3.startAnimation(toggle_on3);
                else
                    thumb3.startAnimation(toggle_off3);
                obesty3 = !obesty3;
                break;
            case R.id.track4:
            case R.id.thumb4:
                if (!obesty4)
                    thumb4.startAnimation(toggle_on4);
                else
                    thumb4.startAnimation(toggle_off4);
                obesty4 = !obesty4;
                break;
            case R.id.track5:
            case R.id.thumb5:
                if (!obesty5)
                    thumb5.startAnimation(toggle_on5);
                else
                    thumb5.startAnimation(toggle_off5);
                obesty5 = !obesty5;
                break;
            case R.id.track6:
            case R.id.thumb6:
                if (!obesty6)
                    thumb6.startAnimation(toggle_on6);
                else
                    thumb6.startAnimation(toggle_off6);
                obesty6 = !obesty6;
                break;

            case R.id.track7:
            case R.id.thumb7:
                if (!obesty7)
                    thumb7.startAnimation(toggle_on7);
                else
                    thumb7.startAnimation(toggle_off7);
                obesty7 = !obesty7;
                break;
        }
    }
}
