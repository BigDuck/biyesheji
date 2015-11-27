/*
 * Copyright (c) 2015 - 11 - 16  4 : 52 :20
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wpj.wx.controller.BaseController;
import com.wpj.wx.daomain.TbList;
import com.wpj.wx.daomain.TbListmain;
import com.wpj.wx.serviceImpl.ListMainServiceImpl;
import com.wpj.wx.serviceImpl.ListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Time：2015/11/16 16:51
 * author：WPJ587
 * description：ListMain信息的维护
 **/
@Controller
@RequestMapping(value = "/admin")
public class ListMainController extends BaseController {
    @Autowired
    ListMainServiceImpl listMainService;
    @Autowired
    ListServiceImpl listService;
    /**
     * @param map  map前台展示
     * @param page 页码
     * @param rows 页面大小
     * @return
     * @see --对列表数据的展示
     */
    @RequestMapping(value = "/main/list")
    public String menuMain(ModelMap map,
                           @RequestParam(required = false, defaultValue = "1") int page,
                           @RequestParam(required = false, defaultValue = "10") int rows
    )
    {


        List<TbListmain> listmains = listMainService.selectByListmain(new TbListmain(),page,rows);
        MyLogeer.info(MYTAG + "-->"+listmains.toString());
        map.addAttribute("listMain", new PageInfo<TbListmain>(listmains));
        map.addAttribute("listTypes",listService.findSimpleMessage());
        map.addAttribute("page", page);
        map.addAttribute("rows", rows);
        map.addAttribute("MyTemplate", "admin/module/ListContent.vm");
        return "admin/index";
    }
    @RequestMapping(value = "/main/list/{flag}/search")
    public String searchList(ModelMap map,@PathVariable("flag")String flag
    ){

        return "admin/index";
    }


}
