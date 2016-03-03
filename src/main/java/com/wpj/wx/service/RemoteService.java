/*
 * Copyright (c) 2016 - 3 - 3  2 : 26 :42
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.daomain.TbRemote;

import java.util.Date;
import java.util.List;

/**
 * Name：RemoteService
 * Time：2016/2/23 9:11
 * author：WPJ587
 * description：远程调用访问统计
 **/

public interface RemoteService extends IService<TbRemote> {
    /**
     * 根据条件获取数据
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param ipAddress ip地址
     * @return
     */
    List<TbRemote> findRemotebList(Date startTime, Date endTime, String ipAddress);

    /**
     * 转换为echart
     * @param remotes
     * @param startTime
     * @param endTime
     * @param ip 如果是按照ip查询的话传入ip
     * @return
     */
    String toEchartData(List<TbRemote> remotes, Date startTime, Date endTime, String ip);
}
