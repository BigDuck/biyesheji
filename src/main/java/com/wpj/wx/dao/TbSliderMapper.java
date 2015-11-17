package com.wpj.wx.dao;

import com.wpj.wx.daomain.TbSlider;
import com.wpj.wx.util.MyMapper;
import tk.mybatis.mapper.common.Mapper;

public interface TbSliderMapper extends MyMapper<TbSlider> {
    TbSlider selectAllMenuMessageById(int id);
}