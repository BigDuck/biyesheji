/*
 * Copyright (c) 2015 - 10 - 13  10 : 34 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceimpl;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.wpj.wx.dao.TbHeaderMapper;
import com.wpj.wx.daomain.TbHeader;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.HeaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/12.
 */
@Service
public class HeaderServiceImpl extends BaseService<TbHeader> implements HeaderService {
    private static Logger logger = LoggerFactory.getLogger(HeaderServiceImpl.class);

    @Resource

  private TbHeaderMapper tbHeaderMapper;

    @Override
    public List<TbHeader> selectByCountry(TbHeader tbHeader, int page, int rows) {
        return null;
    }

    /**
     * {
     * "id": "",
     * <p>
     * "className": "",
     * <p>
     * "theme": "",
     * <p>
     * "options": {
     * "fixed": false
     * },
     * <p>
     * "content": {
     * "left": [{
     * "link": "",
     * "title": "",
     * "icon": "",
     * "customIcon": "",
     * "className": ""
     * }],
     * <p>
     * "title": "",
     * <p>
     * "right": [{
     * "link": "",
     * "title": "",
     * "icon": "",
     * "customIcon": "",
     * "className": ""
     * }]
     * }
     * }
     *
     * @param headerId
     * @return
     */
    @Override
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段
    @Cacheable(value = "myCache",key ="#headerId")
    public Map<String, Object> findDataMapById(int headerId) {
        TbHeader tbHeader = tbHeaderMapper.selectByPrimaryKey(headerId);
        logger.info("tbHeader--->:" + tbHeader);
        Map<String, Object> data = new HashMap<>();
        //option
        Map<String, Object> options = new HashMap<>();
        if(tbHeader==null){
            return null;
        }
        if(tbHeader.isFixed()){
        options.put("fixed", true);
        }
        //right
        Map<String, Object> right = new HashMap<>();
        if(tbHeader.getLeftLink()!=null){
            right.put("link", tbHeader.getRightLink());
        }
        if(tbHeader.getRightTitle()!=null){
            right.put("title", tbHeader.getRightTitle());

        }
        if(tbHeader.getRightIcon()!=null){
            right.put("icon", tbHeader.getRightIcon());
        }
        if(tbHeader.getRightClassName()!=null){
            right.put("className", tbHeader.getRightClassName());
        }
        //left
        Map<String, Object> left = new HashMap<>();
        if(tbHeader.getLeftLink()!=null){
            left.put("link", tbHeader.getLeftLink());
        }

        if(tbHeader.getLeftTitle()!=null){
            left.put("title", tbHeader.getLeftTitle());
        }

        if(tbHeader.getLeftIcon()!=null){
            left.put("icon", tbHeader.getLeftIcon());
        }

        if(tbHeader.getLeftClassName()!=null){
            left.put("className", tbHeader.getLeftClassName());
        }
        //content
        Map<String, Object> content = new HashMap<>();
        List<  Map<String, Object>> listLeft=new ArrayList<>();
        List<  Map<String, Object>> listRight=new ArrayList<>();
        if(left.size()>0){
            listLeft.add(left);
        }
        if(right.size()>0) {
            listRight.add(right);
        }
        if(listLeft.size()>0){

            content.put("left",listLeft);

        }
        if(listRight.size()>0){
            content.put("right",listRight);
        }
        content.put("title", tbHeader.getTitle());
        //header
        Map<String, Object> header = new HashMap<>();
        header.put("content", content);
//        if(tbHeader.getLeftClassName()!=null){
//            header.put("className", tbHeader.getLeftClassName());
//        }
        if(tbHeader.getTheme()!=null){
            header.put("theme", tbHeader.getTheme());
        }
    if(tbHeader.getClassId()!=null){
        header.put("id", tbHeader.getClassId());

    }
        if(options.size()>0){
            header.put("options",options);

        }


        data.put("header", header);
        return data;
    }
}
