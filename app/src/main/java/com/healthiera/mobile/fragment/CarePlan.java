package com.healthiera.mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.activeandroid.query.Delete;
import com.healthiera.mobile.R;
import com.healthiera.mobile.component.base.EventItem;
import com.healthiera.mobile.entity.Calendar;
import com.healthiera.mobile.entity.Doctor;
import com.healthiera.mobile.entity.Measurement;
import com.healthiera.mobile.entity.Medication;
import com.healthiera.mobile.entity.enumeration.EventType;
import com.healthiera.mobile.entity.model.EventItemModel;
import com.healthiera.mobile.fragment.Event.EventList;

/**
 * @author Davit Ter-Arakelyan
 * @date 19.08.2016
 */
public class CarePlan extends BaseFragment {
    @Nullable

    ListView listview;

    private static EventItemModel[] getEventitems() {
        EventItemModel[] items = new EventItemModel[EventType.values().length];

        // var a= EnumSet.allOf( EventType.class );
        //EnumSet.allOf( EventType.class );
        int index = 0;
        for (EventType dir : EventType.values()) {
            items[index] = new EventItemModel(dir.getEvent(), dir.getEventName(), dir.getEventIcon());
            index++;
        }
        return items;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.calendar, container, false);

//---------- T E S T ------------
        new Delete().from(Calendar.class).execute();
        new Delete().from(com.healthiera.mobile.entity.Procedure.class).execute();
        new Delete().from(Measurement.class).execute();
        new Delete().from(Medication.class).execute();
        new Delete().from(Doctor.class).execute();
        new Delete().from(com.healthiera.mobile.entity.Goal.class).execute();

//        CalendarFragment ev1 = new CalendarFragment("Event1 Desc", "AppointmEntvent1", StatusType.Active, EventType.Appointment, new Date("10/15/2016"), new Date("11/05/2016"), "111111111", ScheduleType.CONTINOUS, 111);
//        CalendarFragment ev2 = new CalendarFragment("Event2 Desc", "MeasurementEvent2", StatusType.Active, EventType.Measurement, new Date("10/15/2016"), new Date("11/05/2016"), "222222222", ScheduleType.Type2, 111);
//        CalendarFragment ev3 = new CalendarFragment("Event3 Desc", "MedicationEventTitle3", StatusType.Active, EventType.Medication, new Date("10/16/2016"), new Date("11/05/2016"), "33333333333", ScheduleType.Type3, 111);
//        CalendarFragment ev4 = new CalendarFragment("Event4 Desc", "TreatmentEventTitle4", StatusType.Active, EventType.Treatment, new Date("10/16/2016"), new Date("11/05/2016"), "33333333333", ScheduleType.Type3, 111);
//        CalendarFragment ev5 = new CalendarFragment("Event5 Desc", "MedicationEventTitle5", StatusType.Active, EventType.Medication, new Date("10/15/2016"), new Date("11/05/2016"), "33333333333", ScheduleType.Type3, 111);
//        CalendarFragment ev6 = new CalendarFragment("Event6 Desc", "MedicationEventTitle6", StatusType.Active, EventType.Medication, new Date("10/16/2016"), new Date("11/05/2016"), "33333333333", ScheduleType.Type3, 111);
//
//        Procedure md1 = new Procedure(ev1.save(), new Doctor("Armen", "Ortoped", "armen@xx.xx", "05555555").save(), "sdf2ss", "Nerarkum");
//        Measurement md2 = new Measurement(ev2.save(), new Goals("Mass", "85").save(), "80", "Qashi chapum", "chapum", MeasurementType.Type1);
//        Medication md3 = new Medication(ev3.save(), 10, "Alfa Farm", "Aspirin", "G65HD9");
//        Medication md5 = new Medication(ev5.save(), 8, "Beta Farm", "Pinicilin", "sd4f5");
//        Medication md6 = new Medication(ev6.save(), 2, "Gama Farm", "Insulin", "6sdf6d");
//        Procedure md4 = new Procedure(ev4.save(), new Doctor("Karen", "Ortoped", "karkar@xddx.xx", "08888888").save(), 10, "sa56d4", "Handipum");

//        md1.save();
//        md2.save();
//        md3.save();
//        md4.save();
//        md5.save();
//        md6.save();
//----------E N D    T E S T ------------

        listview = (ListView) rootView.findViewById(R.id.lvEvent);
        listview.setAdapter(new EventItem(getContext(), getEventitems()));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle args = new Bundle();
                args.putString("EventType", EventType.values()[position].getEventName());
                EventList eventList = new EventList();
                eventList.setArguments(args);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.Content_id_, eventList).addToBackStack("CP").commit();
                getFragmentManager().beginTransaction().replace(R.id.Content_id_, eventList).commit();
            }
        });

        return rootView;
    }
}