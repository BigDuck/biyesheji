/*
 * Copyright (c) 2016 - 3 - 3  2 : 29 :12
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.wpj.wx.common.Page;
import com.wpj.wx.dao.TbListmainMapper;
import com.wpj.wx.daomain.TbListmain;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.ListMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/11/1.
 */
@Service
public class ListMainServiceImpl extends BaseService<TbListmain> implements ListMainService {
    @Autowired
    TbListmainMapper tbListmainMapper;

    @Override
    @Cacheable(value = "myCache",key ="'ListMain'+#id")
    public Map<String, Object> findContentMessageById(int id) {
        Map<String, Object> content;
        content = tbListmainMapper.selectContentMapById(id);
        return content;
    }

    /**
     * 根据条件分页查询
     *
     * @param listmain
     * @param page
     * @param rows
     * @return
     */
    @Override
    @Cacheable(value = "myCache",key = "'listmain'+#page+'-'+#rows")
    public List<TbListmain> selectByListmain(TbListmain listmain, int page, int rows) {
        Example example = new Example(TbListmain.class);
        Example.Criteria criteria = example.createCriteria();
        if (listmain.getListId() != null) {
            criteria.andEqualTo("list_id", listmain.getListId());
        }

        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }


    /**
     * 自己写的分页，推荐使用PageHelper
     *
     * @param page
     * @return
     */
    @Override
    public List<TbListmain> findListMainByPage(Page page) {
        int count = tbListmainMapper.selectAllCount();
        System.out.println(page.toString());
        return tbListmainMapper.selectListMainByPage(page);
    }


    @Override
    @Cacheable(value = "myCache",key = "listMainCount")
    public int findCountNo() {
        int count = tbListmainMapper.selectAllCount();
        if (count >= 0) {
            return count;
        }
        return 0;
    }

    /**
     * 根据listmain的id获取listmain文章具体内容
     *
     * @param id
     * @return
     */
    @Override
    public TbListmain getListMainById(int id) {
        return tbListmainMapper.selectByPrimaryKey(id);
    }

}
