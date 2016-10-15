package com.healthiera.mobile.component.base;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.healthiera.mobile.entity.Model.EventItemModel;
import com.healthiera.mobile.serivce.Dictionary;

import com.healthiera.mobile.R;

/**
 * Created by Davit on 01.10.2016.
 * @author Davit Ter-Arakelyan
 * @date 01.10.2016
 */

public class EventItem extends BaseAdapter {

    Context context;
    EventItemModel[] data;
    private static LayoutInflater inflater = null;

    public EventItem(Context context, EventItemModel[] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.event_item, null);
        ImageView ivEventIcon =(ImageView) vi.findViewById(R.id.ivEventIcon);
        TextView tvEventCategoryName = (TextView) vi.findViewById(R.id.tvEventCategoryName);
        TextView tvEventCount = (TextView) vi.findViewById(R.id.tvEventCount);
        ivEventIcon.setImageBitmap(BitmapFactory.decodeResource(vi.getResources(), data[position].getImage()));
        tvEventCategoryName.setText(data[position].getEventName());
        tvEventCount.setText(
                (data[position].getTodayEventCount()==0 && data[position].getTomorrowEventCount()==0)?Dictionary.No_Event:
                        (
                                (data[position].getTodayEventCount()!=0?Dictionary.Today+data[position].getTodayEventCount():"")+
                                ((data[position].getTodayEventCount()==0 || data[position].getTomorrowEventCount()==0)?"":", ")+
                                (data[position].getTomorrowEventCount()!=0?Dictionary.Tomorrow+data[position].getTomorrowEventCount():"")
                        )
        );

        return vi;
    }
}