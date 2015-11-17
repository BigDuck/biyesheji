/*
 * Copyright (c) 2015 - 11 - 1  9 : 54 :8
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceImpl;

import com.wpj.wx.common.Page;
import com.wpj.wx.dao.TbListmainMapper;
import com.wpj.wx.daomain.TbListmain;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.ListMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/11/1.
 */
@Service
public class ListMainServiceImpl  extends BaseService<TbListmain> implements ListMainService {
    @Autowired
    TbListmainMapper tbListmainMapper;
    @Override
    public Map<String, Object> findContentMessageById(int id) {
        Map<String ,Object> content=new HashMap<>();
        content= tbListmainMapper.selectContentMapById(id);
        return content;
    }

    @Override
    public List<TbListmain> selectByExample(Object example) {
        return super.selectByExample(example);
    }

    /**
     * 自己写的分页，推荐使用PageHelper
     * @param page
     * @return
     */
    @Override
    public List<TbListmain> findListMainByPage(Page page) {
        int count=tbListmainMapper.selectAllCount();
        System.out.println(page.toString());
        return tbListmainMapper.selectListMainByPage(page);
    }


    @Override
    public int findCountNo() {
        int count=tbListmainMapper.selectAllCount();
        if(count>=0){
            return count;
        }
        return 0;
    }

}
