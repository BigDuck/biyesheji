/*
 * Copyright (c) 2015 - 11 - 1  9 : 42 :5
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.common.Page;
import com.wpj.wx.daomain.TbListmain;

import java.util.List;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/11/1.
 */
public interface ListMainService  extends IService<TbListmain> {
    Map<String,Object>  findContentMessageById(int id);
    List<TbListmain>  selectByExample(Object example);
    List<TbListmain>   findListMainByPage(Page page);
    int findCountNo();
}
