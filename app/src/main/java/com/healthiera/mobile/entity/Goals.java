package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * @author Davit Ter-Arakelyan
 * @date 21.09.2016
 */
@Table(name = "goals")
public class Goals extends Model {

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    public Goals(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }
    public Goals() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}