/*
 * Copyright (c) 2015 - 10 - 13  10 : 34 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.daomain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by WPJ587 on 2015/10/8.
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段
public class BaseDamain implements Serializable {
}
