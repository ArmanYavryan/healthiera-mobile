package com.healthiera.mobile.serivce;

import com.activeandroid.query.Select;
import com.healthiera.mobile.entity.HealthDate;
import com.healthiera.mobile.entity.enumeration.HealthDateType;
import com.healthiera.mobile.entity.enumeration.Hormone;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Davit Ter-Arakelyan
 * @date 29.10.2016
 */

public class HealthDateService {
    public Long createHealthDate(HealthDate healthDate) {
        healthDate.setDate(new Date());
        final Long id = healthDate.save();
        return id;
    }

    public HealthDate findHealthDatesByType(HealthDateType type) {

        if(type!=null) {
            HealthDate healthDate = new Select()
                    .from(HealthDate.class)
                    .where("health_date_type=?",type)
                    .orderBy("ID DESC")
                    .executeSingle();
            return healthDate;
        }
        return null;
    }

    public Long[] createGlucocorticoidsIntake(Date sd, Date ed, Hormone h) {
        if(sd!=null && h !=null) {
            Long[] id = new Long[3];
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            HealthDate healthDate = new HealthDate();
            healthDate.setValue(sdf.format(sd));
            healthDate.setHealthDateType(HealthDateType.Glucocriticoids_intake_start_date);
            id[0] = createHealthDate(healthDate);

            healthDate = new HealthDate();
            healthDate.setValue(ed==null? "": sdf.format(ed));
            healthDate.setHealthDateType(HealthDateType.Glucocriticoids_intake_end_date);
            id[1] = createHealthDate(healthDate);

            healthDate = new HealthDate();
            healthDate.setValue(h.toString());
            healthDate.setHealthDateType(HealthDateType.Glucocriticoids_intake_hormone);
            id[2] = createHealthDate(healthDate);

            return id;
        }
        else return null;
    }

    public List<HealthDate> findGlucocorticoidsIntake() {

         List<HealthDate> healthDate = new ArrayList<>(3);
        HealthDate h=new Select()
                .from(HealthDate.class)
                .where("health_date_type=?",HealthDateType.Glucocriticoids_intake_hormone)
                .orderBy("ID DESC")
                .executeSingle();

        HealthDate sd= new Select()
                .from(HealthDate.class)
                .where("health_date_type=?",HealthDateType.Glucocriticoids_intake_start_date)
                .orderBy("ID DESC")
                .executeSingle();

        HealthDate ed=new Select()
                .from(HealthDate.class)
                .where("health_date_type=?",HealthDateType.Glucocriticoids_intake_end_date)
                .orderBy("ID DESC")
                .executeSingle();

        HealthDate g=new Select()
                .from(HealthDate.class)
                .where("health_date_type=?",HealthDateType.Glucocriticoids_intake)
                .orderBy("ID DESC")
                .executeSingle();
        if(g!=null && g.getValue().equals("false") && g.getId()>h.getId())
        {
            healthDate.add(g);
            return healthDate;
        }
if(sd !=null && ed !=null && h !=null) {
    healthDate.add(h);
    healthDate.add(sd);
    healthDate.add(ed);
}
        return healthDate;
    }
}

