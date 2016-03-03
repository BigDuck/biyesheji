/*
 * Copyright (c) 2016 - 2 - 26  10 : 51 :32
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.daomain.TbSubmenuitem;

import java.util.List;

/**
 * Created by WPJ587 on 2016/2/26.
 */
public interface SubMenuItemService extends IService<TbSubmenuitem> {
    /**
     * 根据子菜单获取子菜单数据
     * @param tbSubmenuitem
     * @return
     */
    List<TbSubmenuitem> getSubItemByTbSubmenuItem(TbSubmenuitem tbSubmenuitem);

}
