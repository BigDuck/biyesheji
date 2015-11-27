/*
 * Copyright (c) 2015 - 11 - 17  3 : 23 :9
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx;

import com.wpj.wx.daomain.TbList;
import com.wpj.wx.serviceImpl.ListServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Name：List
 * Time：2015/11/17 15:23
 * author：WPJ587
 * description：关于List的测试
 **/

public class List extends BaseTest{
    @Autowired
    ListServiceImpl listService;
    @Test
    public void test(){
      java.util.List<TbList> tbList= listService.findSimpleMessage();
        System.out.println("--->"+tbList.toString());
    }
}
