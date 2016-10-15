package com.healthiera.mobile.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Davit Ter-Arakelyan
 * @date 08.10.2016
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //can use in method only.
public @interface EventField {
    public boolean isViewable() default false;
    public String name();
}