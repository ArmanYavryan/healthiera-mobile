package com.healthiera.mobile.component.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.healthiera.mobile.R;

/**
 * Created by USER on 08.10.2016.
 */

public class BaseToggleButton extends FrameLayout implements View.OnClickListener, Animation.AnimationListener {
    ImageView thumb, track;
    Animation toggle_on, toggle_off;
    Boolean selected = false;

    public BaseToggleButton(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        int px1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, context.getResources().getDisplayMetrics());

        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        track = new ImageView(context);
        track.setLayoutParams(new LayoutParams(px1 * 60, LinearLayout.LayoutParams.WRAP_CONTENT));
        track.setImageResource(R.drawable.switch_track);
        thumb = new ImageView(context);
        thumb.setLayoutParams(new LayoutParams(px1 * 20, LinearLayout.LayoutParams.WRAP_CONTENT));
        thumb.setImageResource(R.drawable.switch_thumb);
        track.setOnClickListener(this);
        thumb.setOnClickListener(this);

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
        addView(track);
        addView(thumb);
    }

    public BaseToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public void onClick(View v) {
        if (!selected)
            thumb.startAnimation(toggle_on);
        else
            thumb.startAnimation(toggle_off);
        selected = !selected;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        thumb.setClickable(false);
        track.setClickable(false);
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
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
