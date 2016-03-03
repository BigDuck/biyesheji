/*
 * Copyright (c) 2016 - 3 - 3  4 : 26 :26
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.daomain.SRole;

import java.util.List;

/**
 * Created by WPJ587 on 2016/3/3.
 */
public interface SRoleService extends IService<SRole> {
    List<SRole> findByUser(SRole sUser);
}
