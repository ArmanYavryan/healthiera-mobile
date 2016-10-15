package com.healthiera.mobile.entity.enumeration;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.healthiera.mobile.R;
import com.healthiera.mobile.entity.Model.EventItemModel;

/**
 * Created by Davit on 05.08.2016.
 */
public enum EventType {
    Appointment (new EventItemModel((byte)1, "Appointment", R.drawable.appointment)),
    Medication (new EventItemModel((byte)2, "Medication", R.drawable.medication)),
    Measurement (new EventItemModel((byte)3, "Measurement", R.drawable.messurment)),
    Treatment (new EventItemModel((byte)4, "Treatment", R.drawable.treatment));

    private byte event;
    private String eventName;
    private int eventIcon;

    public byte getEvent() {
        return event;
    }

    public String getEventName() {
        return eventName;
    }

    public int getEventIcon() {
        return eventIcon;
    }

    EventType(EventItemModel model) {
          event = model.getEventType();
          eventName = model.getEventName();
          eventIcon = model.getImage();
      }
    }
