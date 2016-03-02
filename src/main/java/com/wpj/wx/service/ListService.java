/*
 * Copyright (c) 2015 - 10 - 18  1 : 1 :55
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.damain.TbList;

import java.util.List;

/**
 * Created by WPJ587 on 2015/10/18.
 */
public interface ListService extends IService<TbList> {
    TbList findALlListById(int id);
    /**
     * 获取List的id和标题这两个必填项目
     * @return
     */
    List<TbList> findSimpleMessage();
    /**
     * 获取分页分类
     *
     */


}
