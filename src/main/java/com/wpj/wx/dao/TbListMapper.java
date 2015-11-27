package com.wpj.wx.dao;

import com.wpj.wx.daomain.TbList;
import com.wpj.wx.util.MyMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbListMapper extends MyMapper<TbList> {
    TbList selectAllListMessage(int id);

    /**
     * 获取List的id和标题这两个必填项目
     * @return
     */
   List<TbList> selectSimpleMessage();
}