package com.wpj.wx.dao;

import com.wpj.wx.daomain.TbMenu;
import com.wpj.wx.util.MyMapper;
import tk.mybatis.mapper.common.Mapper;

public interface TbMenuMapper extends MyMapper<TbMenu> {
    TbMenu selectAllMenuMessageById(int menuId);
}