package com.healthiera.mobile.fragment.Event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.healthiera.mobile.R;
import com.healthiera.mobile.component.base.EventListItem;
import com.healthiera.mobile.entity.Calendar;
import com.healthiera.mobile.fragment.BaseFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Davit Ter-Arakelyan
 * @date 02.10.2016
 */

public class EventList extends BaseFragment {
    Bundle bundle;
    ListView listview;
    Calendar[] calendarList;
    TextView tvDate;
    DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");

    public EventList() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.event_list, container, false);
        bundle = getArguments();

        calendarList = getEventListItems(bundle.getString("EventType"), new Date());

        listview = (ListView) view.findViewById(R.id.lvEventList);
        listview.setAdapter(new EventListItem(getContext(), calendarList));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Long eventId = calendarList[position].getId();

                Bundle args = new Bundle();
                args.putString("EventType", bundle.getString("EventType"));
                args.putLong("EventId", eventId);
                EventItemVew eventItemVew = new EventItemVew();
                eventItemVew.setArguments(args);
                getFragmentManager().beginTransaction().replace(R.id.Content_id_, eventItemVew).commit();
            }
        });
        tvDate = (TextView) view.findViewById(R.id.tvDate);
        tvDate.setText(df.format(new Date()));
        Button btnToday = (Button) view.findViewById(R.id.btnToday);
        Button btnTomorrow = (Button) view.findViewById(R.id.btnTomorrow);

        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date d =new Date();
                tvDate.setText(df.format(d));
                calendarList = getEventListItems(bundle.getString("EventType"), d);
                listview.setAdapter(new EventListItem(getContext(), calendarList));
            }
        });

        btnTomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date d =new Date((new Date()).getTime() + (1000 * 60 * 60 * 24));
                tvDate.setText(df.format(d));
                calendarList = getEventListItems(bundle.getString("EventType"), d);
                listview.setAdapter(new EventListItem(getContext(), calendarList));
            }
        });

        return view;
    }

    private Calendar[] getEventListItems(String e, Date d) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        List<Calendar> el = new Select()
                .from(Calendar.class)
                .where("type = ?", e)
                //.orderBy("Name ASC")
                //.where("start_date_time >= ?", d)
                .execute();
        List<Calendar> evByDate = new ArrayList<>();
        for (Calendar ev : el) {
            // TODO replace the logic
//            if (dateFormat.format(ev.getStartDateTime()).equals(dateFormat.format(d))) {
//                evByDate.add(ev);
//            }
        }
        return evByDate.toArray(new Calendar[evByDate.size()]);
    }
}
