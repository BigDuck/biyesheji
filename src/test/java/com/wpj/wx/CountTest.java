/*
 * Copyright (c) 2016 - 2 - 23  3 : 32 :7
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx;

import com.wpj.wx.daomain.TbRemote;
import com.wpj.wx.service.RemoteService;
import com.wpj.wx.util.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Name：CountTest
 * 运维统计测试类
 * Time：2016/2/23 15:32
 * author：WPJ587
 * description：
 **/

public class CountTest extends BaseTest {
    @Autowired
    RemoteService remoteService;
    @Test
    public void getCountMessage(){
        java.util.List<TbRemote> res =remoteService.
                findRemotebList(DateUtil.getYesterday(new Date(),true,1),
                        new Date(),null);
        System.out.println(res.toString());
    }

}
