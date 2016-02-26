/*
 * Copyright (c) 2015 - 11 - 16  2 : 39 :29
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wpj.wx.daomain.TbSlidercontent;
import com.wpj.wx.serviceimpl.SliderContentServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * projectName：com-byteslounge-websockets
 * Time：2015/11/16 14:39
 * author：WPJ587
 * description：测试下mybatis对于关键字的处理问题
 **/

public class SliderTest extends BaseTest{

    @Autowired
    SliderContentServiceImpl sliderContentService;

    /*******************************************************
     *
     *
     *
     *
     * ******************************************************/
    @Test
    public void nihao() {
        Example example=new Example(TbSlidercontent.class);
        PageHelper.startPage(1, 3);
         List<TbSlidercontent> tbLists= sliderContentService.selectByExample(example);
        PageInfo<TbSlidercontent> tbListPageInfo=new PageInfo<>(tbLists);
        System.out.println("---------------------------");
        System.out.println(tbListPageInfo.getList().get(0).toString());
       // sliderContentService.selectByKey(1);
    }
}