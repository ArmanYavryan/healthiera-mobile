package com.healthiera.mobile.htComponents;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Davit on 12.08.2016.
 */
public class htTextView extends TextView
{
    public htTextView(Context context) {
        super(context);
    }


    public htTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public htTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);


    }
}
