package com.healthiera.mobile.entity;

/**
 * Created by Davit on 05.08.2016.
 */
public class Settings extends BaseEntity {
    public String key;
    public String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
