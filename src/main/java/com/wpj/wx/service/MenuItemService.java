/*
 * Copyright (c) 2015 - 10 - 13  3 : 30 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;


import com.wpj.wx.damain.TbMenuitem;

import java.util.List;

/**
 * Created by WPJ587 on 2015/10/13.
 */
public interface MenuItemService extends IService<TbMenuitem> {
    List<TbMenuitem> getMenuByPage(TbMenuitem tbMenuitem, int page, int rows);
}
