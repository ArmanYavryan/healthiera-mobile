package com.healthiera.mobile.fragment.Event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.healthiera.mobile.R;
import com.healthiera.mobile.component.base.EventItemView;
import com.healthiera.mobile.entity.Measurement;
import com.healthiera.mobile.entity.Medication;
import com.healthiera.mobile.entity.Model.EventViewModel;
import com.healthiera.mobile.entity.Procedure;
import com.healthiera.mobile.fragment.BaseFragment;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Davit on 05.10.2016.
 */

public class EventItemVew extends BaseFragment {
    public EventItemVew() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.event_item_vew, container, false);
        Bundle bundle = getArguments();
        ListView listview = (ListView) view.findViewById(R.id.lvEventItemVew);
        listview.setAdapter(new EventItemView(getContext(), getEventView(bundle.getString("EventType"), bundle.getLong("EventId"))));

        return view;
    }

    private List<EventViewModel> getEventView(String s, Long eventId) {

        List<EventViewModel> e = new ArrayList<EventViewModel>();

        switch (s)
        {
            case "Appointment":
            case "Treatment":
            {
                final Procedure m = new Select().from(Procedure.class).where("event_id = ?", eventId).executeSingle();
                if(m != null) {
                    Class proc = Procedure.class;
                    for (Field field : proc.getDeclaredFields()) {

                        if (field.isAnnotationPresent(com.healthiera.mobile.Annotation.EventField.class)) {

                            Annotation ann = field.getAnnotation(com.healthiera.mobile.Annotation.EventField.class);
                            com.healthiera.mobile.Annotation.EventField eventfild = (com.healthiera.mobile.Annotation.EventField) ann;

                            if (eventfild.isViewable()) {
                                EventViewModel ev = new EventViewModel(eventfild.name(),runGetter(field, m).toString());
                                e.add(ev);
                            }
                        }
                    }
                }
                break;
            }


            case "Measurement":
            {
                final Measurement m = new Select().from(Measurement.class).where("event_id = ?", eventId).executeSingle();
                if(m != null) {
                    Class proc = Measurement.class;
                    for (Field field : proc.getDeclaredFields()) {

                        if (field.isAnnotationPresent(com.healthiera.mobile.Annotation.EventField.class)) {

                            Annotation ann = field.getAnnotation(com.healthiera.mobile.Annotation.EventField.class);
                            com.healthiera.mobile.Annotation.EventField eventfild = (com.healthiera.mobile.Annotation.EventField) ann;

                            if (eventfild.isViewable()) {
                                EventViewModel ev = new EventViewModel(eventfild.name(),runGetter(field, m).toString());
                                e.add(ev);
                            }
                        }
                    }
                }
                break;
            }
            case "Medication":
            {
                final Medication m = new Select().from(Medication.class).where("event_id = ?", eventId).executeSingle();
                if(m != null) {
                    Class proc = Medication.class;
                    for (Field field : proc.getDeclaredFields()) {

                        if (field.isAnnotationPresent(com.healthiera.mobile.Annotation.EventField.class)) {

                            Annotation ann = field.getAnnotation(com.healthiera.mobile.Annotation.EventField.class);
                            com.healthiera.mobile.Annotation.EventField eventfild = (com.healthiera.mobile.Annotation.EventField) ann;

                            if (eventfild.isViewable()) {
                                EventViewModel ev = new EventViewModel(eventfild.name(),runGetter(field, m).toString());
                                e.add(ev);
                            }
                        }
                    }
                }
                break;
            }
            default:
                break;
        }
        return e;
    }

    public static Object runGetter(Field field, Object m)
    {
        // MZ: Find the correct method
        Class o;
        o=m.getClass();
        for (Method method :o.getMethods())
        {
            if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3)))
            {
                if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase()))
                {
                    // MZ: Method found, run it
                    try
                    {
                        return method.invoke(m);
                    }
                    catch (IllegalAccessException e)
                    {
                       // Logger.fatal("Could not determine method: " + method.getName());
                    }
                    catch (InvocationTargetException e)
                    {
                        // Logger.fatal("Could not determine method: " + method.getName());
                    }

                }
            }
        }
        return null;
    }
}
