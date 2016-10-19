package com.healthiera.mobile.component.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.healthiera.mobile.R;
import com.healthiera.mobile.entity.Schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Davit on 04.10.2016.
 */

public class EventListItem extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context context;
    Schedule[] data;
    DateFormat df = new SimpleDateFormat("HH:mm");

    public EventListItem(Context context, Schedule[] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static String getDateDiff(Date date1, Date date2) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        long diffInMillies = date2.getTime() - date1.getTime();
        Long t = timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if (t < 60)
            return t.toString() + " min";
        else
            return Long.toString(t / 60 - 2) + " hr";
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
            vi = inflater.inflate(R.layout.event_list_item, null);
        TextView tvEventCategoryName = (TextView) vi.findViewById(R.id.tvEventListItemName);
        tvEventCategoryName.setText(data[position].getTitle());
        TextView tvEventListItemDesc = (TextView) vi.findViewById(R.id.tvEventListItemDesc);
        tvEventListItemDesc.setText(data[position].getDescription());
        TextView tvEventListItemTime = (TextView) vi.findViewById(R.id.tvEventListItemTime);
        tvEventListItemTime.setText(df.format(data[position].getStartDate()));
        TextView tvEventListItemRemainedTime = (TextView) vi.findViewById(R.id.tvEventListItemRemainedTime);
        if (data[position].getStartDate().before(new Date())) {
            tvEventListItemRemainedTime.setText(getDateDiff(data[position].getStartDate(), new Date()));
        }
        ImageView ivEventStatus = (ImageView) vi.findViewById(R.id.ivEventStatus);

        // TODO add service call
//        switch (data[position].getStatus())
//        {
//            case Active:
//               // ivEventStatus.setImageBitmap(BitmapFactory.decodeResource(vi.getResources(), 10));
//                break;
//            case Done:
//                break;
//            case Deleted:
//                break;
//            case Delayed:
//                break;
//            case Cancelled:
//                break;
//
//        }

        return vi;
    }
}