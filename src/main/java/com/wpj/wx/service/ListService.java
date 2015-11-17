/*
 * Copyright (c) 2015 - 10 - 18  1 : 1 :55
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.daomain.TbList;

/**
 * Created by WPJ587 on 2015/10/18.
 */
public interface ListService extends IService<TbList> {
TbList findALlListById(int id);
}
