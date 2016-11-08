package com.healthiera.mobile.serivce;

import com.activeandroid.query.Select;
import com.healthiera.mobile.entity.HealthDate;
import com.healthiera.mobile.entity.enumeration.HealthDateType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Davit Ter-Arakelyan
 * @date 29.10.2016
 */

public class HealthDateService {
    public Long createHealthDate(HealthDate healthDate) {
        final Long id = healthDate.save();
        return id;
    }

    public List<HealthDate> findHealthDatesByType(HealthDateType type) {

        if(type!=null) {
            List<HealthDate> healthDate = new Select()
                    .from(HealthDate.class)
                    .where("health_date_type=?",type)
                    .orderBy("ID DESC")
                    .execute();
            return healthDate;
        }
        return null;
    }
}

