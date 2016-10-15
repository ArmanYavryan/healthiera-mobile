package com.healthiera.mobile.component.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.healthiera.mobile.R;
import com.healthiera.mobile.entity.Event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Davit on 04.10.2016.
 */

public class EventListItem extends BaseAdapter {

    Context context;
    Event[] data;
    private static LayoutInflater inflater = null;
    DateFormat df = new SimpleDateFormat("HH:mm");

    public EventListItem(Context context, Event[] data) {
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
            vi = inflater.inflate(R.layout.event_list_item, null);
        TextView tvEventCategoryName = (TextView) vi.findViewById(R.id.tvEventListItemName);
        tvEventCategoryName.setText(data[position].getTitle());
        TextView tvEventListItemDesc = (TextView) vi.findViewById(R.id.tvEventListItemDesc);
        tvEventListItemDesc.setText(data[position].getDescription());
        TextView tvEventListItemTime = (TextView) vi.findViewById(R.id.tvEventListItemTime);
        tvEventListItemTime.setText(df.format(data[position].getStartDateTime()));
        TextView tvEventListItemRemainedTime = (TextView) vi.findViewById(R.id.tvEventListItemRemainedTime);
        if(data[position].getStartDateTime().after(new Date()))
        tvEventListItemRemainedTime.setText(data[position].getTitle());

        return vi;
    }
}