package com.wpj.wx.dao;

import com.wpj.wx.daomain.TbRemote;
import com.wpj.wx.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface TbRemoteMapper extends MyMapper<TbRemote> {
    /**
     * 根据map获取数据
     * map的key 有：startTime 开始时间，endTime ipAddress
     * @param map
     * @return
     */
    List<TbRemote> getTbRemote(Map map);
}