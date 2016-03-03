/*
 * Copyright (c) 2016 - 3 - 3  2 : 26 :42
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.daomain.TbMenu;

import java.util.List;

/**
 * Created by WPJ587 on 2015/10/13.
 */
public interface MenuService extends IService<TbMenu> {
    TbMenu findAllMenuMessageById(int menuId);
    List<TbMenu> getMenuByPage(TbMenu tbMenu, int page, int rows);
}
