package com.weimob.dotwoven.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by chenpengfei on 2017/1/18.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WovenTap {

    /**
     *  界面
     */
    String pageName() default "";

    /**
     *  操作
     */
    String elementId() default "";

}
