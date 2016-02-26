/*
 * Copyright (c) 2016 - 1 - 21  10 : 24 :43
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin.manager;

import com.github.pagehelper.PageInfo;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wpj.wx.aop.Procedure;
import com.wpj.wx.common.Config;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.daomain.PageRequest;
import com.wpj.wx.daomain.TbIplogs;
import com.wpj.wx.daomain.TbSystemInfo;
import com.wpj.wx.service.IpLogService;
import com.wpj.wx.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Name：ManagerController
 * Time：2016/1/21 22:24
 * author：WPJ587
 * description：系统管理
 **/
@Controller
@RequestMapping("/manager")
@ApiIgnore
public class ManagerController extends BaseController {
    @Autowired
    IpLogService ipLogService;
    @Autowired
    SystemInfoService systemInfoService;

    @RequestMapping("/iplist")
    public Object ipLog(ModelMap map, PageRequest pageRequest
    ) {

        MyLogeer.info("开始时间：{} 结束时间:{}", pageRequest.getEndTime(), pageRequest.getStartTime());
        List<TbIplogs> iplist = ipLogService.selectByListmain(new TbIplogs(), pageRequest);
        map.addAttribute("iplist", new PageInfo<>(iplist));
        map.addAttribute("page", pageRequest.getPage());
        map.addAttribute("rows", pageRequest.getRows());
        map.addAttribute("MyTemplate", "admin/system/ipList.vm");
        return Config.INDEX;
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @RequestMapping("/system")
    public Object getSystemInfo(ModelMap map, PageRequest pageRequest) {
        List<TbSystemInfo> systemInfos = systemInfoService.selectByListmain(new TbSystemInfo(), pageRequest);
        map.addAttribute("systemInfos", new PageInfo<>(systemInfos));
        map.addAttribute("page", pageRequest.getPage());
        map.addAttribute("rows", pageRequest.getRows());
        map.addAttribute("MyTemplate", "admin/system/systeminfo.vm");
        return "admin/index";
    }

    @RequestMapping("/detail")
    @Procedure(description = "获取系统信息详情")
    @ResponseBody
    public Object getDetailById(long id) {
        MyLogeer.info("id{}", id);
        TbSystemInfo tbSystemInfo = null;
        try {
            tbSystemInfo  =systemInfoService.selectByKey(id);
        }catch (Exception e){
            MyLogeer.error("获取详情失败{}",e.getCause());
        }
        return tbSystemInfo;
    }
}
