package com.wpj.wx.dao;

import com.wpj.wx.daomain.TbList;
import com.wpj.wx.util.MyMapper;
import tk.mybatis.mapper.common.Mapper;

public interface TbListMapper extends MyMapper<TbList> {
    TbList selectAllListMessage(int id);
}