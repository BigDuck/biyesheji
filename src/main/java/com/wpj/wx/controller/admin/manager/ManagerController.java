/*
 * Copyright (c) 2016 - 1 - 21  10 : 24 :43
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin.manager;

import com.github.pagehelper.PageInfo;
import com.wpj.wx.daomain.TbIplogs;
import com.wpj.wx.service.IpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Name：ManagerController
 * Time：2016/1/21 22:24
 * author：WPJ587
 * description：系统管理
 **/
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    IpLogService ipLogService;

    @RequestMapping("/iplist")
    public Object ipLog(ModelMap map,
                        @RequestParam(required = false, defaultValue = "1") int page,
                        @RequestParam(required = false, defaultValue = "10") int rows
    ) {
        List<TbIplogs> iplist = ipLogService.selectByListmain(new TbIplogs(), page, rows);
        map.addAttribute("iplist", new PageInfo<>(iplist));
        map.addAttribute("page", page);
        map.addAttribute("rows", rows);
        map.addAttribute("MyTemplate", "admin/system/ipList.vm");
        return "admin/index";
    }
}
