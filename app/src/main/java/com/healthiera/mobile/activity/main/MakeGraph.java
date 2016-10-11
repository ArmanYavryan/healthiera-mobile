package com.healthiera.mobile.activity.main;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;

import com.healthiera.mobile.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

/**
 * Created by USER on 01.10.2016.
 */

public class MakeGraph {
    public View view;
    private float values[];
    int px1;
    private GraphView graphview;
    float average = 0.0f;
    String color;

    public MakeGraph(GraphView graphview, String title, Context context, float[] args, String color) {
        this.graphview = graphview;
        this.color = color;
        px1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, context.getResources().getDisplayMetrics());
        values = args;
        float min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) min = values[i];
        }

        float max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) max = values[i];
        }
        for (int i = 0; i < values.length; i++) {
            average += values[i];
        }
        average = (average) / values.length;
        graphview.setHorizontalScrollBarEnabled(true);
        graphview.setTitle(title + " : average(" + String.format("%.2f", average) + ")");
        graphview.getGridLabelRenderer().setGridColor(Color.parseColor("#14000000"));
        graphview.getGridLabelRenderer().setHighlightZeroLines(false);
        graphview.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graphview.getViewport().setXAxisBoundsManual(true);
        graphview.getViewport().setYAxisBoundsManual(true);
        graphview.getViewport().setMinX(0.0f);
        graphview.getViewport().setMaxX(values.length);
        graphview.getViewport().setMinY(0.0f);
        graphview.getViewport().setMaxY(max);
        DrawAverage();
        DrawChart();
        DrawPoints();

    }

    private void DrawAverage() {
        /// Average Line
        LineGraphSeries<DataPoint> series0 = new LineGraphSeries<DataPoint>();
        series0.appendData(new DataPoint(0, average), true, values.length);
        series0.appendData(new DataPoint(values.length, average), true, values.length);
        Paint paint0 = new Paint();
        paint0.setStrokeWidth(px1);
        paint0.setStyle(Paint.Style.STROKE);
        paint0.setPathEffect(new DashPathEffect(new float[]{2 * px1, 4 * px1}, 2 * px1));
        paint0.setColor(Color.parseColor("#ffff00"));
        series0.setCustomPaint(paint0);
        graphview.addSeries(series0);

    }

    private void DrawChart() {
        /// Chart
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        for (int i = 0; i < values.length; i++) {
            series.appendData(new DataPoint(i, values[i]), true, values.length);
        }
        graphview.addSeries(series);
        Paint paint = new Paint();
        paint.setStrokeWidth(px1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#ffffff"));
        series.setCustomPaint(paint);
    }

    private void DrawPoints() {
        // Points outter
        PointsGraphSeries<DataPoint> series1 = new PointsGraphSeries<DataPoint>();
        graphview.addSeries(series1);
        for (int i = 0; i < values.length; i++) {
            series1.appendData(new DataPoint(i, values[i]), true, values.length);
        }
        series1.setShape(PointsGraphSeries.Shape.POINT);
        series1.setSize(3f * px1);
        series1.setColor(Color.parseColor("#ffffff"));

        // Points inner
        PointsGraphSeries<DataPoint> series2 = new PointsGraphSeries<DataPoint>();
        graphview.addSeries(series2);
        for (int i = 0; i < values.length; i++) {
            series2.appendData(new DataPoint(i, values[i]), true, values.length);
        }
        series2.setShape(PointsGraphSeries.Shape.POINT);
        series2.setSize(2f * px1);
        series2.setColor(Color.parseColor(color));
    }
}
