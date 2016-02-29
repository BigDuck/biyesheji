/*
 * Copyright (c) 2015 - 10 - 18  5 : 1 :50
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceimpl;

import com.wpj.wx.dao.TbListMapper;
import com.wpj.wx.daomain.TbList;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.ListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WPJ587 on 2015/10/18.
 */
@Service
public class ListServiceImpl extends BaseService<TbList> implements ListService {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private TbListMapper tbListMapper;

    @Override
    @Cacheable(key = "'list'+#id",value = "myCache")
    public TbList findALlListById(int id) {
        TbList tbList = tbListMapper.selectAllListMessage(id);
        return tbList;
    }


    /**
     *
     * @return
     */
    @Override
    @Cacheable(key = "simpleMsg",value = "myCache")
    public List<TbList> findSimpleMessage() {
        return tbListMapper.selectSimpleMessage();
    }
}
