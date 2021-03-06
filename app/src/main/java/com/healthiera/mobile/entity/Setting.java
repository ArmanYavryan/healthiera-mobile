package com.healthiera.mobile.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Davit on 05.08.2016.
 */
@Table(name = "setting")
public class Setting extends Model {

    @Column(name = "key", index = true)
    private String key;

    @Column(name = "value")
    private String value;

    public Setting() {
        super();
    }

    public Setting(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

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
