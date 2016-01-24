/*
 * Copyright (c) 2016 - 1 - 21  11 : 19 :0
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.wpj.wx.dao.TbIplogsMapper;
import com.wpj.wx.daomain.PageRequest;
import com.wpj.wx.daomain.TbIplogs;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.IpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Name：IpLogServiceImpl
 * Time：2016/1/21 23:18
 * author：WPJ587
 * description：ip相关日志
 **/
@Service
public class IpLogServiceImpl extends BaseService<TbIplogs> implements IpLogService {
    @Autowired
    TbIplogsMapper tbIplogsMapper;
    @Override
    public List<TbIplogs> selectByListmain(TbIplogs tbIplogs, PageRequest pageRequest) {
        Example example = new Example(TbIplogs.class);
        Example.Criteria criteria = example.createCriteria();
        if (tbIplogs.getId()!=null) {
            criteria.andEqualTo("id",tbIplogs.getId());
        }
        if(pageRequest.getStartTime()!=null){
            criteria.andBetween("createTime",pageRequest.getStartTime(),pageRequest.getEndTime());
        }
        //分页查询
        PageHelper.startPage(pageRequest.getPage(), pageRequest.getRows());
        return selectByExample(example);
    }
}