/*
 * Copyright (c) 2016 - 3 - 3  2 : 52 :54
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin.list;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wpj.wx.aop.Procedure;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.daomain.TbList;
import com.wpj.wx.daomain.TbListmain;
import com.wpj.wx.service.ListMainService;
import com.wpj.wx.service.ListService;
import com.wpj.wx.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Time：2015/11/16 16:51
 * author：WPJ587
 * description：ListMain信息的维护
 **/
@Controller
@RequestMapping(value = "/admin")
@ApiIgnore
public class ListMainAdminController extends BaseController {
    @Autowired
    ListMainService listMainService;
    @Autowired
    ListService listServiceImpl;

    /**
     * @param map  map前台展示
     * @param page 页码
     * @param rows 页面大小
     * @return
     * @see --对列表数据的展示
     */
    @RequestMapping(value = "/main/list")
    @Procedure(description = "admin的菜单menu")
    public String menuMain(ModelMap map,
                           @RequestParam(required = false, defaultValue = "1") int page,
                           @RequestParam(required = false, defaultValue = "10") int rows
    ) {

        List<TbListmain> listmains = listMainService.selectByListmain(new TbListmain(), page, rows);
        MyLogeer.info(MYTAG + "-->" + listmains.toString());
        map.addAttribute("listMain", new PageInfo<TbListmain>(listmains));
        map.addAttribute("listTypes", listServiceImpl.findSimpleMessage());
        map.addAttribute("page", page);
        map.addAttribute("rows", rows);
        map.addAttribute("MyTemplate", "admin/module/ListContent.vm");
        return "admin/index";
    }

    @RequestMapping(value = "/main/list/{flag}/search")
    @Procedure(description = "搜索list详情")
    public String searchList(ModelMap map, @PathVariable("flag") String flag
    ) {

        return "admin/index";
    }

    /**
     * 查看详情
     * @param listId id号
     * @param map UI交互
     * @return
     */
    @RequestMapping(value = "/main/list/{listId}")
    @Procedure(description = "访问list的相信内容")
    public String detailPage(@PathVariable(value = "listId") int listId,
                             @RequestParam(value = "type",required = false)String type,
                             ModelMap map) {
        MyLogeer.info(MYTAG + "listId is {}", listId);
        TbListmain result = listMainService.selectByKey(listId);
        List<TbList> tbLists = listServiceImpl.findSimpleMessage();
        map.addAttribute("listMain", result);
        map.addAttribute("listMsg",tbLists);
       if((!Strings.isNullOrEmpty(type))&&"view".equals(type)){
           map.addAttribute("MyTemplate","admin/module/list/view.vm");
       }else{

           map.addAttribute("MyTemplate", "admin/module/list/listMainDetail.vm");
       }

        return "admin/index";
    }

    /**
     * 保存listMain
     * @param
     * @return
     */
    @RequestMapping(value = "/main/list/add",method = RequestMethod.POST)
     @Procedure(description = "添加listMain")
    public String listMainAdd(HttpServletRequest request){
      //  MyLogeer.info("--result---{}",tbListmain.toString());
        TbListmain tbListmain=new TbListmain();
        if(request.getParameter("link")!=null){
            tbListmain.setLink(request.getParameter("link").toString());
        }
        if(request.getParameter("className")!=null){
            tbListmain.setClassName(request.getParameter("className").toString());

        } if(request.getParameter("title")!=null){
            tbListmain.setTitle(request.getParameter("title").toString());


        } if(request.getParameter("listId")!=null){
            tbListmain.setListId(Integer.valueOf(request.getParameter("listId").toString()));
        } if(request.getParameter("desc")!=null){
            tbListmain.setDesc(request.getParameter("desc").toString());

        } if(request.getParameter("date")!=null){
            tbListmain.setDate(DateUtil.str2Date(request.getParameter("date")));
            System.out.println(request.getParameter("date"));

        } if(request.getParameter("img")!=null){
            tbListmain.setImg(request.getParameter("img").toString());

        } if(request.getParameter("thumbAddition")!=null){
            tbListmain.setThumbAddition(request.getParameter("thumbAddition").toString());

        } if(request.getAttribute("mainAddition")!=null){
            tbListmain.setMainAddition(request.getParameter("mainAddition").toString());

        } if(request.getParameter("contents")!=null){
            tbListmain.setContents(request.getParameter("contents").toString());
        }
        int result= listMainService.save(tbListmain);
        MyLogeer.info("保存结果{}",result);

        return "redirect:/admin/main/list";
    }
    @RequestMapping(value = "/main/list/add",method = RequestMethod.GET)
    public String toListMainAdd(ModelMap map) {
        List<TbList> tbLists = listServiceImpl.findSimpleMessage();
        map.addAttribute("listMsg",tbLists);
        map.addAttribute("MyTemplate", "admin/module/list/listAdd.vm");
        return "admin/index";
    }

    /**
     * 更新
     * @param request
     * @return
     *@history  WPJ587 2016/1/20 0:01
     */
    @RequestMapping(value = "/main/list/update",method = RequestMethod.POST)
    @Procedure(description = "更新了Listmain")
    public String updateListMain(HttpServletRequest request){
        TbListmain tbListmain=new TbListmain();
        if(request.getParameter("link")!=null){
            tbListmain.setLink(request.getParameter("link").toString());
        }
        if(request.getParameter("className")!=null){
            tbListmain.setClassName(request.getParameter("className").toString());

        } if(request.getParameter("title")!=null){
            tbListmain.setTitle(request.getParameter("title").toString());
        } if(request.getParameter("listId")!=null){
            tbListmain.setListId(Integer.valueOf(request.getParameter("listId").toString()));
        } if(request.getParameter("desc")!=null){
            tbListmain.setDesc(request.getParameter("desc").toString());

        } if(request.getParameter("date")!=null){
            tbListmain.setDate(DateUtil.str2Date(request.getParameter("date")));
            System.out.println(request.getParameter("date"));

        } if(request.getParameter("img")!=null){
            tbListmain.setImg(request.getParameter("img").toString());

        } if(request.getParameter("thumbAddition")!=null){
            tbListmain.setThumbAddition(request.getParameter("thumbAddition").toString());

        } if(request.getAttribute("mainAddition")!=null){
            tbListmain.setMainAddition(request.getParameter("mainAddition").toString());

        } if(request.getParameter("contents")!=null){
            tbListmain.setContents(request.getParameter("contents").toString());
        }if (request.getParameter("id")!=null){
            tbListmain.setId(Integer.valueOf(request.getParameter("id")));

        }
       MyLogeer.info("待更新的实体:{}",tbListmain);
        try{
         int res=  listMainService.updateNotNull(tbListmain);
        MyLogeer.info("result:{}",res);
        }catch (Exception e){
            MyLogeer.error("更新失败：{}",e.getCause());
        }
        return "redirect:/admin/main/list";
    }
    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @Procedure(description = "删除menu")
    public String deleteById(int id){
        MyLogeer.info("id:{}",id);
        try {
            listMainService.delete(id);
        }catch (Exception e){
            MyLogeer.error("删除发生错误：{}",e.getCause());
            return "-1";
        }
        return "1";
    }
}
