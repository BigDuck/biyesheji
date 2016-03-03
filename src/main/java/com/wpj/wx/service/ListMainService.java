/*
 * Copyright (c) 2015 - 11 - 1  9 : 42 :5
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.common.Page;
import com.wpj.wx.daomain.TbListmain;

import java.util.List;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/11/1.
 */
public interface ListMainService  extends IService<TbListmain> {
    /**
     * Find content message by id map.
     *
     * @param id the id
     * @return the map
     */
    Map<String,Object>  findContentMessageById(int id);

    /**
     * 根据条件分页查询
     *
     * @param listmain the listmain
     * @param page     the page
     * @param rows     the rows
     * @return list
     */
    List<TbListmain> selectByListmain(TbListmain listmain, int page, int rows);
    
    /**
     * Find list main by page list.
     *
     * @param page the page
     * @return the list
     */
    List<TbListmain>   findListMainByPage(Page page);

    /**
     * 获取总数
     * @return
     */
    int findCountNo();

    /**
     * 根据listmain的id获取listmain文章具体内容
     * @param id
     * @return
     */
    TbListmain getListMainById(int id);
}
