package com.healthiera.mobile.entity.Model;

import android.graphics.Bitmap;

import com.activeandroid.query.Select;
import com.healthiera.mobile.entity.Event;
import com.healthiera.mobile.entity.enumeration.EventType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Davit Ter-Arakelyan
 * @date 01.10.2016
 */

public class EventItemModel {

   private byte eventType;
   private String eventName;
   private byte todayEventCount;
   private byte tomorrowEventCount;

    public EventItemModel(byte eventType, String eventName, int image) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    private int image;

    public byte getEventType() {
        return eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public byte getTodayEventCount() {
        byte d=0;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        List<Event> events = new Select()
                .from(Event.class)
                .where("type = ?", eventName)
                .execute();
        for (Event e:   events) {
            if(dateFormat.format(e.getStartDateTime()).equals(dateFormat.format(date)))
            {
                d++;
            }
        }
//        todayEventCount=(byte)(new Select()
//                .from(Event.class)
//                .where("type = ?", eventName)
//                .where("start_date_time >= ?", dateFormat.format(date))
//                .execute()).size();

        return todayEventCount=d;
    }

    public byte getTomorrowEventCount() {
        byte d=0;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date((new Date()).getTime() + (1000 * 60 * 60 * 24));
        List<Event> events = new Select()
                .from(Event.class)
                .where("type = ?", eventName)
                .execute();
        for (Event e:   events) {
            if(dateFormat.format(e.getStartDateTime()).equals(dateFormat.format(date)))
            {
                d++;
            }
        }
        return tomorrowEventCount=d;
    }
}
