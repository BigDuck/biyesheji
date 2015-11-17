/*
 * Copyright (c) 2015 - 11 - 16  4 : 52 :20
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wpj.wx.controller.BaseController;
import com.wpj.wx.daomain.TbListmain;
import com.wpj.wx.serviceImpl.ListMainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Time：2015/11/16 16:51
 * author：WPJ587
 * description：ListMain信息的维护
 **/
@RequestMapping(name = "/admin")
public class ListMainController extends BaseController
{
    @Autowired
    ListMainServiceImpl listMainService;
    /**
     *@see --对列表数据的展示
     * @param map map前台展示
     * @param page 页码
     * @param rows 页面大小
     * @return
     */
    @RequestMapping(value = "/main/list")
    public String menuMain(ModelMap map,
                           @RequestParam(required = false, defaultValue = "1") int page,
                           @RequestParam(required = false, defaultValue = "10") int rows
    ){
        MyLogeer.info(MYTAG+":后台主页");
        Example example=new Example(TbListmain.class);
        PageHelper.startPage(page, rows);
        List<TbListmain> listmains=listMainService.selectByExample(example);
        map.addAttribute("listMain",  new PageInfo<TbListmain>(listmains));
        map.addAttribute("MyTemplate","admin/module/ListContent.vm");
        return "admin/index";
    }
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String login(ModelMap map,
                        @RequestParam(required = false, defaultValue = "1") int page,
                        @RequestParam(required = false, defaultValue = "10") int rows
    ){
        MyLogeer.info(MYTAG+":后台主页");
        Example example=new Example(TbListmain.class);
        PageHelper.startPage(page,rows);
        List<TbListmain> listmains=listMainService.selectByExample(example);

//        Page page=new Page();
//        page.setPageNo(1);
//        page.setPageSize(5);
        // List<TbListmain> listMain=listMainService.findListMainByPage(page);
        map.addAttribute("listMain",    new PageInfo<TbListmain>(listmains));
        map.addAttribute("MyTemplate","admin/module/ListContent.vm");
        return "admin/index";
    }
}
