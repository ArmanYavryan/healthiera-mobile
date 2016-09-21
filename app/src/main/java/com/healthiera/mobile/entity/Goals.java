package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Davit on 21.09.2016.
 */
@Table(name = "goals")
public class Goals extends Model {

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "height")
    private Integer height;

    @Column(name = "bim")
    private Float bim;

    @Column(name = "ratio_thallium_hips")
    private Float ratioThalliumHips;

    @Column(name = "pulse")
    private Integer pulse;

    @Column(name = "blood_pressure_sys")
    private Integer bloodPressureSys;

    @Column(name = "blood_pressure_dia")
    private Integer bloodPressureDia;

    public Goals(Float bim, Integer bloodPressureDia, Integer bloodPressureSys, Integer height, Integer pulse, Float ratioThalliumHips, Integer weight) {
        this.bim = bim;
        this.bloodPressureDia = bloodPressureDia;
        this.bloodPressureSys = bloodPressureSys;
        this.height = height;
        this.pulse = pulse;
        this.ratioThalliumHips = ratioThalliumHips;
        this.weight = weight;
    }

    public Float getBim() {
        return bim;
    }

    public void setBim(Float bim) {
        this.bim = bim;
    }

    public Integer getBloodPressureDia() {
        return bloodPressureDia;
    }

    public void setBloodPressureDia(Integer bloodPressureDia) {
        this.bloodPressureDia = bloodPressureDia;
    }

    public Integer getBloodPressureSys() {
        return bloodPressureSys;
    }

    public void setBloodPressureSys(Integer bloodPressureSys) {
        this.bloodPressureSys = bloodPressureSys;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Float getRatioThalliumHips() {
        return ratioThalliumHips;
    }

    public void setRatioThalliumHips(Float ratioThalliumHips) {
        this.ratioThalliumHips = ratioThalliumHips;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
