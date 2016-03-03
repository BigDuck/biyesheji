/*
 * Copyright (c) 2016 - 3 - 3  2 : 29 :12
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceImpl;

import com.wpj.wx.dao.TbSliderMapper;
import com.wpj.wx.daomain.TbSlider;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by WPJ587 on 2015/10/17.
 */
@Service
public class SliderServiceImpl extends BaseService<TbSlider> implements SliderService {
    @Autowired
    TbSliderMapper tbSliderMapper;


    @Override
    @Cacheable(value = "myCache",key = "'tbslider'+#id")
    public TbSlider findAllMenuMessageById(int id) {
        TbSlider tbSlider=tbSliderMapper.selectAllMenuMessageById(id);
//        System.out.println("----》"+tbSlider.getContent().size());
        return tbSlider;
    }
}
