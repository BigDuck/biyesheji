/*
 * Copyright (c) 2016 - 1 - 23  4 : 15 :47
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.daomain.PageRequest;
import com.wpj.wx.daomain.TbSystemInfo;

import java.util.List;

/**
 * Name：SystemInfo
 * Time：2016/1/23 16:15
 * author：WPJ587
 * description：系统监监控
 **/

public interface SystemInfoService extends IService<TbSystemInfo> {
    List<TbSystemInfo> selectByListmain(TbSystemInfo tbSystemInfo, PageRequest pageRequest);

}
