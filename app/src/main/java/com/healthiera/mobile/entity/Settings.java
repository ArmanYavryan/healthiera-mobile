package com.healthiera.mobile.entity;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.Model;

/**
 * Created by Davit on 05.08.2016.
 */
@Table(name = "settings")
public class Settings extends Model {

    public Settings() {
    super();
    }

    public Settings(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    @Column(name = "key",index = true)
    private String key;

    @Column(name = "value")
    private String value;

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
