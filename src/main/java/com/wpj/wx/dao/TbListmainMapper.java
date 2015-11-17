package com.wpj.wx.dao;

import com.wpj.wx.common.Page;
import com.wpj.wx.daomain.TbListmain;
import com.wpj.wx.util.MyMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TbListmainMapper extends MyMapper<TbListmain> {
    Map<String,Object> selectContentMapById(int id);
    int selectAllCount();
    List<TbListmain> selectListMainByPage(Page page);
}