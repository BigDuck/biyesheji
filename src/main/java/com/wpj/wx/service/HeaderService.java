/*
 * Copyright (c) 2015 - 10 - 13  10 : 34 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;


import com.wpj.wx.daomain.TbHeader;

import java.util.List;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/12.
 */
public interface HeaderService  extends IService<TbHeader> {
    /**
     * 根据条件分页查询
     *
     * @param tbHeader
     * @param page
     * @param rows
     * @return
     */
    List<TbHeader> selectByCountry(TbHeader tbHeader, int page, int rows);
    /**
     * 生成Amazeui需要的构造数据（map）
     *
     */
    Map<String,Object> findDataMapById(int headerId);

}
