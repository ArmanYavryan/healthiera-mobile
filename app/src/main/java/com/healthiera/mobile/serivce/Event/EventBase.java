package com.healthiera.mobile.serivce.Event;

import com.activeandroid.Model;
import com.activeandroid.query.Select;

/**
 * @author Davit Ter-Arakelyan
 * @date 29.09.2016
 */

public class EventBase<T extends Model>
{
    public void Create()
    {
        com.healthiera.mobile.entity.Procedure ap =new com.healthiera.mobile.entity.Procedure();
        ap.setDoctorId(new Long(55));
        ap.save();
    }

    public com.healthiera.mobile.entity.Procedure Read()
    {
        final com.healthiera.mobile.entity.Procedure ap = new Select().from(com.healthiera.mobile.entity.Procedure.class).executeSingle();
        return  ap;
    }

    public void Update()
    {

    }

    public void Delete()
    {

    }
}
