package com.wpj.wx.dao;

import com.wpj.wx.damain.TbSlider;
import com.wpj.wx.util.MyMapper;

public interface TbSliderMapper extends MyMapper<TbSlider> {
    TbSlider selectAllMenuMessageById(int id);
}