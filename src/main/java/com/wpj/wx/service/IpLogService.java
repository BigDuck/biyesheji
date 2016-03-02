/*
 * Copyright (c) 2016 - 1 - 21  11 : 17 :59
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.damain.PageRequest;
import com.wpj.wx.damain.TbIplogs;

import java.util.List;

/**
 * Created by WPJ587 on 2016/1/21.
 */
public interface IpLogService  extends IService<TbIplogs>  {
    List<TbIplogs> selectByListmain(TbIplogs tbIplogs, PageRequest pageRequest);
}
