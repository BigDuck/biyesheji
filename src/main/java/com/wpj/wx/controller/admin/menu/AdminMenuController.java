/*
 * Copyright (c) 2016 - 2 - 14  10 : 53 :28
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin.menu;

import com.wpj.wx.daomain.TbMenu;
import com.wpj.wx.daomain.TbMenuitem;
import com.wpj.wx.service.MenuItemService;
import com.wpj.wx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Name：MenuController
 * Time：2016/2/14 22:53
 * author：WPJ587
 * description：侧边栏菜单
 **/
@Controller
@RequestMapping("/admin")
public class AdminMenuController {
    @Autowired
    MenuService menuService;
    @Autowired
    MenuItemService menuItemService;

    @RequestMapping("/menu")
    public Object toMenu(ModelMap map){
        map.addAttribute("MyTemplate", "admin/menu/menu.vm");
        List<TbMenu> allMenu=menuService.getMenuByPage(new TbMenu(),1,10);
        List<TbMenuitem> allMenuItem=menuItemService.getMenuByPage(new TbMenuitem(),1,100);
        map.addAttribute("allMenu",allMenu);
        map.addAttribute("allMenuItem",allMenuItem);
        return "admin/index";
    }
}
