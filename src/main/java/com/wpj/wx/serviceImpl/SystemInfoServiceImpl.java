/*
 * Copyright (c) 2016 - 3 - 3  2 : 29 :12
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.wpj.wx.daomain.PageRequest;
import com.wpj.wx.daomain.TbSystemInfo;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.SystemInfoService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Name：SystemInfoServiceImpl
 * Time：2016/1/23 16:16
 * author：WPJ587
 * description：系统监控业务
 **/
@Service
public class SystemInfoServiceImpl  extends BaseService<TbSystemInfo> implements SystemInfoService {

    @Override
    @Cacheable(value = "myCache",key = "#pageRequest")
    public List<TbSystemInfo> selectByListmain(TbSystemInfo tbSystemInfo, PageRequest pageRequest) {
        Example example = new Example(TbSystemInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(pageRequest.getStartTime()!=null){
            criteria.andBetween("createTime",pageRequest.getStartTime(),pageRequest.getEndTime());
        }
        //分页查询
        PageHelper.startPage(pageRequest.getPage(), pageRequest.getRows());
        return selectByExample(example);
    }

}
