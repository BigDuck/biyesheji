package com.wpj.wx.dao;

import com.wpj.wx.daomain.TbMenu;
import com.wpj.wx.util.MyMapper;

public interface TbMenuMapper extends MyMapper<TbMenu> {
    TbMenu selectAllMenuMessageById(int menuId);
}