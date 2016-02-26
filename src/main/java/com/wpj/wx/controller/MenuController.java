/*
 * Copyright (c) 2015 - 10 - 14  11 : 19 :44
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.daomain.BaseResult;
import com.wpj.wx.daomain.TbMenu;
import com.wpj.wx.serviceimpl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/14.
 */
@RestController
@RequestMapping("/menus")
@Api(basePath = "/menus", value = "TbMenu", description = "菜单")
public class MenuController extends BaseController {
    @Autowired
    private MenuServiceImpl menuService;

    /**
     * Gets menu by id.
     *
     * @param id            the id
     * @param callbackparam the callbackparam
     * @return the menu by id
     */
    @RequestMapping(value = "/menu/{id}")
    @ApiOperation(value = "获取菜单信息", httpMethod = "GET",
            notes = "根据菜单id获取菜单的信息", response = BaseResult.class)
    public final Object getMenuById(
            @ApiParam(name = "id", required = true, value = "菜单Id")
                                    @PathVariable("id")final int id,
                                    final String callbackparam) {
        Map<String, Object> menu = new HashMap<>();
        System.out.println(menu);
        TbMenu tbMenu = menuService.findAllMenuMessageById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("menu", tbMenu);
        return super.toClient(callbackparam, map);
    }


}
