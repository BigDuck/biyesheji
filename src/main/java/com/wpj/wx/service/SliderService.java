/*
 * Copyright (c) 2015 - 10 - 17  5 : 16 :55
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.service;

import com.wpj.wx.damain.TbSlider;

/**
 * Created by WPJ587 on 2015/10/17.
 */
public interface SliderService extends IService<TbSlider>  {
    TbSlider findAllMenuMessageById(int id);

}
