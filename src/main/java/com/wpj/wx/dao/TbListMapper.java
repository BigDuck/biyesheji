package com.wpj.wx.dao;

import com.wpj.wx.damain.TbList;
import com.wpj.wx.util.MyMapper;

import java.util.List;

public interface TbListMapper extends MyMapper<TbList> {
    TbList selectAllListMessage(int id);

    /**
     * 获取List的id和标题这两个必填项目
     * @return
     */
   List<TbList> selectSimpleMessage();
}