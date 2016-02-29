/*
 * Copyright (c) 2016 - 1 - 21  10 : 59 :59
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.aop;

import java.lang.annotation.*;

/**
 * Procedure declaration of REST API.
 * @author horiga
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Procedure {
	String description() default "无";

}
